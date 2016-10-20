package it.seiton.healtcare.application.impl

import it.seiton.healtcare.application.HospitalsApplicationService
import it.seiton.healtcare.domain.model.HospitalEntity
import it.seiton.healtcare.domain.model.HospitalMapper
import it.seiton.healtcare.domain.model.HospitalModel
import it.seiton.healtcare.domain.repository.HospitalRepository
import it.seiton.library.infrastructure.sql.Sort
import rx.Observable

/**
 * Created by lukasw44 on 18/10/2016.
 */
class HospitalApplicationServiceDefault(val hospitalRepository: HospitalRepository) : HospitalsApplicationService {

    override fun getAllHospitals(): Observable<List<HospitalEntity>> {
        return hospitalRepository.findAll(Sort(HospitalModel.ORGANISATIONNAMELOWERCASE))
    }
}
