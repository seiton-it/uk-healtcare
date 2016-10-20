package it.seiton.healtcare

import android.content.res.Configuration
import android.util.Log
import com.facebook.stetho.Stetho
import com.squareup.leakcanary.LeakCanary
import com.squareup.leakcanary.RefWatcher
import it.seiton.common.ui.HasRefWatcher

/**
 * Created by lukasw44 on 19/10/2016.
 */
class InternalDebugHealtcareApp : HealtcareApp(), HasRefWatcher {

    lateinit var refWatcher: RefWatcher

    override fun onCreate() {
        Log.d(TAG, "(IDAPP)::onCreate()")
        initLeakCanary();
        super.onCreate()
        Stetho.initializeWithDefaults(this)
    }

    override fun onLowMemory() {
        super.onLowMemory()
        Log.d(TAG, "(APP)::onLowMemory()")
    }

    override fun onConfigurationChanged(newConfig: Configuration?) {
        super.onConfigurationChanged(newConfig)
        Log.d(TAG, "(APP)::onConfigurationChanged(newConfig), newConfig: $newConfig")
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
        const val TAG = "IntDebugHealtcareApp"
    }
}