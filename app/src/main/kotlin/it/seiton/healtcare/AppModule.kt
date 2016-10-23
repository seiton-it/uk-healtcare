package it.seiton.healtcare

import dagger.Module
import dagger.Provides
import it.seiton.healtcare.infrastructure.di.ApplicationScope

/**
 * Created by lukasw44 on 17/10/2016.
 */
@Module
class AppModule(val app: HealtcareApp) {

    @Provides
    @ApplicationScope
    fun provideApplication(): HealtcareApp {
        return app
    }

    @Provides
    @ApplicationScope
    fun provideGlobalConfig(): Config {
        return Config(app)
    }

    @Provides
    @ApplicationScope
    fun provideAppInfoService(config: Config): AppInfoService {
        return AppInfoService(app, config)
    }

}
