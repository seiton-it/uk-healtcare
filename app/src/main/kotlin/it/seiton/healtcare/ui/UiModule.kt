package it.seiton.healtcare.ui

import dagger.Module
import dagger.Provides
import it.seiton.healtcare.AppInfoService
import it.seiton.healtcare.application.HospitalsApplicationService
import it.seiton.healtcare.infrastructure.di.ApplicationScope
import it.seiton.healtcare.ui.main.hospitals.HospitalDetailsPresenter
import it.seiton.healtcare.ui.main.hospitals.HospitalListPresenter

/**
 * Created by lukasw44 on 20/10/2016.
 */
@Module
class UiModule {

    @Provides
    @ApplicationScope
    fun provideHospitalListPresenter(hospitalsApplicationService: HospitalsApplicationService, appInfo: AppInfoService): HospitalListPresenter {
        return HospitalListPresenter(hospitalsApplicationService, appInfo)
    }

    @Provides
    @ApplicationScope
    fun provideHospitalDetailsPresenter(hospitalsApplicationService: HospitalsApplicationService): HospitalDetailsPresenter {
        return HospitalDetailsPresenter(hospitalsApplicationService)
    }
}