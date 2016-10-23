package it.seiton.healtcare.application.implementation

import android.accounts.AccountManager
import android.content.ContentResolver
import android.content.Context
import android.os.Bundle
import android.preference.PreferenceManager
import android.provider.Telephony
import android.text.TextUtils
import it.seiton.healtcare.application.SyncApplicationService
import it.seiton.healtcare.Config
import it.seiton.healtcare.HealtcareApp
import it.seiton.healtcare.domain.model.HospitalMapper
import it.seiton.healtcare.domain.repository.HospitalRepository
import it.seiton.healtcare.infrastructure.api.HealtcareApi
import it.seiton.healtcare.infrastructure.sync.HealtcareAccountService
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import timber.log.Timber
import kotlin.concurrent.thread

/**
 * Created by lukasw44 on 17/10/2016.
 */
class SyncApplicationServiceDefault(app: HealtcareApp, val config: Config, val api: HealtcareApi, val hospitalMapper: HospitalMapper, val hospitalRepository: HospitalRepository) : SyncApplicationService {

    init {
        Timber.tag(TAG).d("(SAS)Init sync application service")
        var newAccount = false
        val setupComplete = PreferenceManager.getDefaultSharedPreferences(app).getBoolean(PREF_SETUP_COMPLETE, false)

        // Create account, if it's missing. (Either first run, or user has deleted account.)
        val account = HealtcareAccountService.getAccount(config.accountName)
        val accountManager = app.getSystemService(Context.ACCOUNT_SERVICE) as AccountManager
        if (accountManager.addAccountExplicitly(account, null, null)) {
            // Inform the system that this account supports sync
            ContentResolver.setIsSyncable(account, config.contentProvider, 1)
            // Inform the system that this account is eligible for auto sync when the network is up
            ContentResolver.setSyncAutomatically(account, config.contentProvider, true)
            // Recommend a schedule for automatic synchronization. The system may modify this based
            // on other scheduled syncs and network utilization.
            ContentResolver.addPeriodicSync(
                    account, config.contentProvider, Bundle(), config.frequency)
            newAccount = true
        }

        // Schedule an initial sync if we detect problems with either our account or our local
        // data has been deleted. (Note that it's possible to clear app data WITHOUT affecting
        // the account list, so wee need to check both.)
        if (newAccount || !setupComplete) {
            //requestSyncImmediate()
            PreferenceManager.getDefaultSharedPreferences(app).edit().putBoolean(PREF_SETUP_COMPLETE, true).commit()
        }
    }

    @Synchronized
    override fun requestSyncImmediate() {
        Timber.tag(TAG).d("reqest sync immediate ....")
        val b = Bundle()
        // Disable sync backoff and ignore sync preferences. In other words...perform sync NOW!
        b.putBoolean(ContentResolver.SYNC_EXTRAS_MANUAL, true)
        b.putBoolean(ContentResolver.SYNC_EXTRAS_EXPEDITED, true)
        ContentResolver.requestSync(
                HealtcareAccountService.getAccount(config.accountName), // Sync account
                config.contentProvider, // Content authority
                b)
    }

    override fun sync() {
        //TODO Check why two thread call that methos at the same time ...
        Timber.tag(TAG).d("Sync ...")
        Timber.tag(TAG).d("Thread name : %s", Thread.currentThread().name)


        /* api.getAllHospitals()

                 .map { r ->
                     r.result
                             .filter { it -> !TextUtils.isEmpty(it.organisationName) }
                             .mapNotNull { r -> hospitalMapper.mapToEntity(r) }
                 }
                 .observeOn(AndroidSchedulers.mainThread())
                 .subscribeOn(Schedulers.io())
                 .subscribe(
                         { n ->
                             hospitalRepository.saveOrUpdate(n)
                         },
                         { e -> println("Damn: $e") },
                         { println("Completed") })*/
    }

    companion object {
        const val TAG: String = "SyncApplicationService"
        const val PREF_SETUP_COMPLETE = "setup_complete"
    }
}