package it.seiton.healtcare

import it.seiton.healtcare.application.HospitalsApplicationService
import it.seiton.healtcare.application.SyncApplicationService

/**
 * Created by lukasw44 on 17/10/2016.
 */
interface HealtcareDependencies {

    fun syncApplicationService(): SyncApplicationService

    fun hospitalsApplicationService(): HospitalsApplicationService
}