package it.seiton.healtcare.domain.repository

import com.squareup.sqlbrite.BriteDatabase
import it.seiton.library.domain.repository.BaseSqlRepository
import it.seiton.healtcare.domain.model.HospitalEntity
import it.seiton.healtcare.domain.model.HospitalMapper
import it.seiton.healtcare.domain.model.HospitalModel

/**
 * Created by lukasw44 on 18/10/2016.
 */
class HospitalSqlRepository(database: BriteDatabase, mapper: HospitalMapper) : BaseSqlRepository<HospitalEntity, HospitalMapper>(database, mapper, HospitalModel.TABLE_NAME), HospitalRepository {


}
