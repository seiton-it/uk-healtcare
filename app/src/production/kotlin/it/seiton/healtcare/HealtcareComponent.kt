package it.seiton.healtcare

import dagger.Component
import it.seiton.healtcare.application.ApplicationServiceModule
import it.seiton.healtcare.domain.DomainModule
import it.seiton.healtcare.infrastructure.ReleaseInfrastructureModule
import it.seiton.healtcare.infrastructure.di.ApplicationScope
import it.seiton.healtcare.infrastructure.sync.HealtcareSyncAdapter

/**
 * Created by lukasw44 on 17/10/2016.
 */
@Component(modules = arrayOf(AppModule::class, DomainModule::class, ApplicationServiceModule::class, ReleaseInfrastructureModule::class))
@ApplicationScope
interface HealtcareComponent : HealtcareDependencies {

    fun inject(healtcareSyncAdapter: HealtcareSyncAdapter)

    companion object Initializer {

        fun init(healtcareApp: HealtcareApp): HealtcareComponent {
            return DaggerHealtcareComponent.builder()
                    .appModule(AppModule(healtcareApp))
                    .build()
        }
    }
}