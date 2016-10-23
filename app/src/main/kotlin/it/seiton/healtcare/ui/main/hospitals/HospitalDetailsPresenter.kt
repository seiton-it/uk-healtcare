package it.seiton.healtcare.ui.main.hospitals

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import it.seiton.healtcare.application.HospitalsApplicationService
import it.seiton.healtcare.domain.model.HospitalEntity
import it.seiton.library.ui.mvp.BaseRxPresenter
import rx.android.schedulers.AndroidSchedulers
import timber.log.Timber

/**
 * Created by lukasw44 on 22/10/2016.
 */
open class HospitalDetailsPresenter(val hospitalService: HospitalsApplicationService) : BaseRxPresenter<HospitalDetailsView>(), OnHospitalInfoClickListener {


    var argId: Int? = null

    override fun onCreate(arguments: Bundle?, savedInstanceState: Bundle?) {
        super.onCreate(arguments, savedInstanceState)

        if (arguments != null) {
            argId = arguments.getInt(HospitalDetailsFragment.ARG_ID)
        } else if (savedInstanceState != null) {
            argId = savedInstanceState.getInt(HospitalDetailsFragment.ARG_ID)
        } else {
            throw IllegalStateException("Hospital id do not exist in arguments and saveInstanceState")
        }
    }

    override fun onActivityCreated() {
        super.onActivityCreated()
        val subscription = hospitalService.getHospital(argId!!)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { hospital ->
                            Timber.d("Get Hospital: ${hospital}")
                            hospital?.let {
                                view?.showHospitalDetails(hospital)
                            }
                        },
                        { e -> Timber.e(e, "Damn ... ") },
                        {
                            Timber.i("Completed")
                        }
                )

        compositeSubscription.add(subscription)
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        argId?.let { it ->
            outState?.putInt(HospitalDetailsFragment.ARG_ID, it)
        }
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        argId = savedInstanceState?.getInt(HospitalDetailsFragment.ARG_ID)
    }

    override fun onAddressItemClick(item: HospitalEntity) {
        //todo
    }

    override fun onPhoneItemClick(item: HospitalEntity) {
        val intent: Intent = Intent(Intent.ACTION_DIAL)
        intent.data = Uri.parse("tel:" + item.phone)
        view?.maybeStartActivity(intent)
    }

    override fun onEmailItemClick(item: HospitalEntity) {
        val intent = Intent(Intent.ACTION_SENDTO)
        intent.data = Uri.parse("mailto:" + item.email)
        view?.maybeStartActivity(intent)
    }

    override fun onWebsiteItemClick(item: HospitalEntity) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(item.website)
        view?.maybeStartActivity(intent)
    }

}