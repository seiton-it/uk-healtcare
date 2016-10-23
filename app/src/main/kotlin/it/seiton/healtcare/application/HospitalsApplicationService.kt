package it.seiton.healtcare.application

import it.seiton.healtcare.domain.model.HospitalEntity
import rx.Observable

/**
 * Created by lukasw44 on 18/10/2016.
 */
interface HospitalsApplicationService {

    fun getAllHospitals(): Observable<List<HospitalEntity>>

    fun getHospital(id: Int): Observable<HospitalEntity?>
}