package it.seiton.healtcare

import android.util.Log
import com.squareup.leakcanary.LeakCanary
import com.squareup.leakcanary.RefWatcher
import it.seiton.common.ui.HasRefWatcher

/**
 * Created by lukasw44 on 19/10/2016.
 */
class ProductionDebugHealtcareApp : HealtcareApp(), HasRefWatcher {

    lateinit var refWatcher: RefWatcher

    override fun onCreate() {
        Log.d(TAG, "(PDAPP)::onCreate()")
        initLeakCanary()
        super.onCreate()
    }


    override fun refWatcher(): RefWatcher {
        return refWatcher
    }


    private fun initLeakCanary() {
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return
        }
        refWatcher = LeakCanary.install(this)
    }

    companion object {
        const val TAG = "ProdDebugHealtcareApp"
    }
}
