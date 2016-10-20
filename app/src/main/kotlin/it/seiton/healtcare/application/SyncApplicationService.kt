package it.seiton.healtcare.application

/**
 * Created by lukasw44 on 17/10/2016.
 */
interface SyncApplicationService {

    fun requestSyncImmediate()

    fun sync()
}