package it.seiton.healtcare.application

import dagger.Module
import dagger.Provides
import it.seiton.healtcare.Config
import it.seiton.healtcare.HealtcareApp
import it.seiton.healtcare.application.impl.HospitalApplicationServiceDefault
import it.seiton.healtcare.application.implementation.SyncApplicationServiceDefault
import it.seiton.healtcare.domain.model.HospitalMapper
import it.seiton.healtcare.domain.repository.HospitalRepository
import it.seiton.healtcare.infrastructure.api.HealtcareApi
import it.seiton.healtcare.infrastructure.di.ApplicationScope

/**
 * Created by lukasw44 on 17/10/2016.
 */
@Module
class ApplicationServiceModule {

    @Provides
    @ApplicationScope
    fun provideSyncApplicationService(app: HealtcareApp, config: Config, api: HealtcareApi, hospitalMapper: HospitalMapper, hospitalRepository: HospitalRepository): SyncApplicationService {
        return SyncApplicationServiceDefault(app, config, api, hospitalMapper, hospitalRepository)
    }

    @Provides
    @ApplicationScope
    fun provideHospitalApplicationService(hospitalRepository: HospitalRepository): HospitalsApplicationService {
        return HospitalApplicationServiceDefault(hospitalRepository)
    }

}