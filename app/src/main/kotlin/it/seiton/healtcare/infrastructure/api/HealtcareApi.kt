package it.seiton.healtcare.infrastructure.api

import it.seiton.healtcare.infrastructure.api.model.HospitalsResponse
import retrofit2.http.GET
import rx.Observable

/**
 * Created by lukasw44 on 18/10/2016.
 */
interface HealtcareApi {

    @GET("health/hospitals/all_hospitals")
    fun getAllHospitals(): Observable<HospitalsResponse>
}