package it.seiton.healtcare.infrastructure

import android.database.sqlite.SQLiteOpenHelper
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import it.seiton.healtcare.Config
import it.seiton.healtcare.HealtcareApp
import it.seiton.healtcare.infrastructure.api.HealtcareApi
import it.seiton.healtcare.infrastructure.datasource.sql.HealtcareDbOpenHelper
import it.seiton.healtcare.infrastructure.di.ApplicationScope
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named

/**
 * Created by lukasw44 on 18/10/2016.
 */
@Module
class InfrastructureModule {

    @Provides
    @ApplicationScope
    fun provideHealtcareApi(@Named("api") retrofit: Retrofit): HealtcareApi {
        return retrofit.create(HealtcareApi::class.java)
    }

    @Provides
    @ApplicationScope
    fun provideGsonConverterFactory() : GsonConverterFactory {
        val gson : Gson = GsonBuilder().create()
        return GsonConverterFactory.create(gson)
    }

    @Provides
    @ApplicationScope
    fun provideSqlOpenHelper(app: HealtcareApp, config: Config): SQLiteOpenHelper {
        return HealtcareDbOpenHelper(app, config)
    }
}