package it.seiton.healtcare.ui.main.hospitals

import android.content.Intent
import android.net.Uri
import android.support.v4.app.DialogFragment
import it.seiton.healtcare.AppInfoService
import it.seiton.healtcare.R
import it.seiton.healtcare.application.HospitalsApplicationService
import it.seiton.healtcare.domain.model.HospitalEntity
import it.seiton.library.ui.mvp.BaseRxPresenter
import rx.android.schedulers.AndroidSchedulers
import timber.log.Timber

/**
 * Created by lukasw44 on 20/10/2016.
 */
class HospitalListPresenter(val hospitalService: HospitalsApplicationService, val appInfo: AppInfoService) : BaseRxPresenter<HospitalListView>() , OnHospitalInfoClickListener{

    override fun onTakeView(v: HospitalListView) {
        super.onTakeView(v)
        v.showLoading()
    }

    override fun onActivityCreated() {
        super.onActivityCreated()

        compositeSubscription.add(hospitalService.getAllHospitals()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { n ->
                            view?.let {it->
                                if(n.isNotEmpty()){
                                    it.showList()
                                    it.showHospitals(n)
                                    if(isTabletAndLandscape()){
                                        it.showHospitalDetails(n.first())
                                    }
                                }else{
                                    it.showEmpty()
                                }
                            }
                        },
                        { e ->
                            view?.let {it->
                                it.showError(R.string.loading_error)
                            }
                            Timber.e(e, "Error while loading hospitals list ... ")
                        },
                        {
                            Timber.d("Complete loading hospitals list")
                        }
                ))
    }

    fun onItemClick(item: HospitalEntity) {
        if (isTabletAndLandscape()) {
            view?.showHospitalDetails(item)
        } else {
            showDialog(item)
        }
    }

    private fun isTabletAndLandscape(): Boolean {
        return appInfo.isTablet() && appInfo.isLandscape()
    }

    private fun showDialog(item: HospitalEntity) {
        val dialog = HospitalDetailsFragment.newInstance(item.id)
        dialog.setStyle(DialogFragment.STYLE_NORMAL, R.style.Fullscreen)
        view?.showDialog(dialog)
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