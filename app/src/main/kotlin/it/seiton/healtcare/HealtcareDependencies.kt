package it.seiton.healtcare

import it.seiton.healtcare.application.HospitalsApplicationService
import it.seiton.healtcare.application.SyncApplicationService
import it.seiton.healtcare.ui.main.hospitals.HospitalDetailsPresenter
import it.seiton.healtcare.ui.main.hospitals.HospitalListPresenter

/**
 * Created by lukasw44 on 17/10/2016.
 */
interface HealtcareDependencies {

    fun syncApplicationService(): SyncApplicationService

    fun hospitalsApplicationService(): HospitalsApplicationService

    fun hospitalListPresenter(): HospitalListPresenter

    fun appInfoService(): AppInfoService

    fun hospitalDetailsPresenter(): HospitalDetailsPresenter
}