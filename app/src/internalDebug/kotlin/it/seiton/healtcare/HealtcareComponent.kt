package it.seiton.healtcare

import dagger.Component
import it.seiton.healtcare.application.ApplicationServiceModule
import it.seiton.healtcare.domain.DomainModule
import it.seiton.healtcare.infrastructure.DebugInfrastructureModule
import it.seiton.healtcare.infrastructure.di.ApplicationScope
import it.seiton.healtcare.infrastructure.sync.HealtcareSyncAdapter
import it.seiton.healtcare.ui.main.hospitals.HospitalsListFragment

/**
 * Created by lukasw44 on 17/10/2016.
 */
@Component(modules = arrayOf(AppModule::class, DomainModule::class, ApplicationServiceModule::class, DebugInfrastructureModule::class))
@ApplicationScope
interface HealtcareComponent : HealtcareDebugDependencies {

    fun inject(healtcareSyncAdapter: HealtcareSyncAdapter)

    fun inject(healtcareSyncAdapter: HospitalsListFragment)

    companion object Initializer {

        fun init(healtcareApp: HealtcareApp): HealtcareComponent {
            return DaggerHealtcareComponent.builder()
                    .appModule(AppModule(healtcareApp))
                    .build()
        }
    }

}