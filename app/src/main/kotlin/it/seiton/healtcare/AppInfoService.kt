package it.seiton.healtcare

import android.content.res.Configuration
import android.content.res.Resources

/**
 * Created by lukasw44 on 21/10/2016.
 */
class AppInfoService(val app: HealtcareApp, val config: Config) {

    private val res: Resources

    init{
        res = app.resources
    }

    fun isTablet(): Boolean = config.tablet

    fun isLandscape(): Boolean = res.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE

}