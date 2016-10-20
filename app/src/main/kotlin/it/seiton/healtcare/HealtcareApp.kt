package it.seiton.healtcare

import android.app.Application
import com.jakewharton.threetenabp.AndroidThreeTen
import it.seiton.library.infrastructure.di.HasComponent
import timber.log.Timber

/**
 * Created by lukasw44 on 17/10/2016.
 */
open class HealtcareApp : Application(), HasComponent<HealtcareComponent> {

    companion object {
        lateinit var component: HealtcareComponent
    }

    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())
        AndroidThreeTen.init(this)

        component = HealtcareComponent.init(this)
    }

    override fun component(): HealtcareComponent {
        return component
    }

}