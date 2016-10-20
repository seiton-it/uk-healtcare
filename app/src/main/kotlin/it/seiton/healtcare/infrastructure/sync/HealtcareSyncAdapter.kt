package it.seiton.healtcare.infrastructure.sync

import android.accounts.Account
import android.content.AbstractThreadedSyncAdapter
import android.content.ContentProviderClient
import android.content.Context
import android.content.SyncResult
import android.os.Bundle
import it.seiton.healtcare.application.SyncApplicationService
import it.seiton.healtcare.HealtcareComponent
import it.seiton.library.infrastructure.di.HasComponent
import it.seiton.library.infrastructure.di.Injector
import timber.log.Timber
import javax.inject.Inject

/**
 * Created by lukasw44 on 17/10/2016.
 */
class HealtcareSyncAdapter(context: Context, autoInitialize: Boolean) : AbstractThreadedSyncAdapter(context, autoInitialize) {

    @Inject
    lateinit var syncService: SyncApplicationService

    init {
        Injector.obtain(context.applicationContext, HealtcareComponent::class.java).inject(this)
    }

    override fun onPerformSync(account: Account, extras: Bundle, authority: String, provider: ContentProviderClient, syncResult: SyncResult) {
        Timber.tag(TAG).d("(SA)::onPerformSync()")

        syncService.sync()
    }

    companion object {
        private val TAG = "HealtcareSyncAdapter"
    }
}
