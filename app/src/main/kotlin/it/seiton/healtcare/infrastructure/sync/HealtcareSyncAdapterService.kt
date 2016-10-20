package it.seiton.healtcare.infrastructure.sync

import android.app.Service
import android.content.Intent
import android.os.IBinder
import timber.log.Timber

/**
 * Define a Service that returns an IBinder for the
 * sync adapter class, allowing the sync adapter framework to call
 * onPerformSync().
 */
class HealtcareSyncAdapterService : Service() {

    companion object {
        private var syncAdapter: HealtcareSyncAdapter? = null
        private val syncAdapterLock = Any()
    }

    override fun onCreate() {
        Timber.d("HealtcareSyncAdapterService::onCreate()")
        synchronized(syncAdapterLock) {
            if (syncAdapter == null) {
                syncAdapter = HealtcareSyncAdapter(applicationContext, true)
            }
        }
    }

    override fun onBind(intent: Intent): IBinder? {
        return syncAdapter!!.syncAdapterBinder
    }
}
