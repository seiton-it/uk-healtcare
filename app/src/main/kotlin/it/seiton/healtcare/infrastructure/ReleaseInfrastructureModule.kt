package it.seiton.healtcare.infrastructure

import android.database.sqlite.SQLiteOpenHelper
import com.squareup.sqlbrite.BriteDatabase
import com.squareup.sqlbrite.SqlBrite
import dagger.Module
import dagger.Provides
import it.seiton.healtcare.Config
import it.seiton.healtcare.infrastructure.di.ApplicationScope
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import rx.schedulers.Schedulers
import timber.log.Timber
import java.util.concurrent.TimeUnit
import javax.inject.Named

/**
 * Created by lukasw44 on 18/10/2016.
 */
@Module(includes = arrayOf(InfrastructureModule::class))
class ReleaseInfrastructureModule {

    @Provides
    @ApplicationScope
    @Named("api")
    fun provideOkHttpClient(config: Config): OkHttpClient {
        return OkHttpClient()
                .newBuilder()
                .connectTimeout(config.connectTimeoutSec.toLong(), TimeUnit.SECONDS)
                .readTimeout(config.readTimeoutSec.toLong(), TimeUnit.SECONDS)
                .writeTimeout(config.writeTimeoutSec.toLong(), TimeUnit.SECONDS)
                .build()
    }

    @Provides
    @ApplicationScope
    @Named("api")
    fun provideRetrofit(@Named("api") okHttpClient: OkHttpClient, config: Config, converterFactory: GsonConverterFactory): Retrofit {
        return Retrofit
                .Builder()
                .addConverterFactory(converterFactory)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(okHttpClient)
                .baseUrl(config.endpoint)
                .build()
    }

    @Provides
    @ApplicationScope
    fun provideSqlBrite(): SqlBrite {
        return SqlBrite.create()
    }

    @Provides
    @ApplicationScope
    fun provideDatabase(sqlBrite: SqlBrite, sqLiteOpenHelper: SQLiteOpenHelper): BriteDatabase {
        val db = sqlBrite.wrapDatabaseHelper(sqLiteOpenHelper, Schedulers.io())
        return db
    }
}