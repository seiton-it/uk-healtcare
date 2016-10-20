package it.seiton.healtcare.domain

import com.squareup.sqlbrite.BriteDatabase
import dagger.Module
import dagger.Provides
import it.seiton.healtcare.domain.model.HospitalMapper
import it.seiton.healtcare.domain.repository.HospitalRepository
import it.seiton.healtcare.domain.repository.HospitalSqlRepository
import it.seiton.healtcare.infrastructure.di.ApplicationScope

/**
 * Created by lukasw44 on 18/10/2016.
 */
@Module
class DomainModule {

    @Provides
    @ApplicationScope
    fun provideHospitalMapper(): HospitalMapper {
        return HospitalMapper()
    }

    @Provides
    @ApplicationScope
    fun provideHospitalRepository(database: BriteDatabase, mapper: HospitalMapper): HospitalRepository {
        return HospitalSqlRepository(database, mapper)
    }
}