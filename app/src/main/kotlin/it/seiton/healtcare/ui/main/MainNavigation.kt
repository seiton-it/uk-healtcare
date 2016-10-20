package it.seiton.healtcare.ui.main

import android.os.Bundle
import android.support.annotation.IntDef
import android.support.v4.app.FragmentActivity
import android.support.v7.widget.Toolbar
import com.mikepenz.materialdrawer.Drawer
import com.mikepenz.materialdrawer.DrawerBuilder
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem
import it.seiton.healtcare.R

/**
 * Created by lukasw44 on 20/10/2016.
 */
class MainNavigation(activity: MainActivity, savedInstanceState: Bundle?) {

    @Retention(AnnotationRetention.SOURCE)
    @IntDef(HOSPITALS_LIST, CLINICS_LIST, GP_SURGERIES_LIST, DENTAL_LIST, PHARMACIES_LIST, SOCIAL_CARE_LIST, SETTINGS, FEEDBACK)
    annotation class NavigationMode

    companion object Navigation {
        const val HOSPITALS_LIST: Long = 1
        const val CLINICS_LIST: Long = 2
        const val GP_SURGERIES_LIST: Long = 3
        const val DENTAL_LIST: Long = 4
        const val PHARMACIES_LIST: Long = 5
        const val SOCIAL_CARE_LIST: Long = 6
        const val SETTINGS: Long = 7
        const val FEEDBACK: Long = 8
    }

    interface OnMainNavigationListener : Drawer.OnDrawerItemClickListener {
    }

    private val drawer: Drawer

    init {
        drawer = DrawerBuilder()
                .withActivity(activity)
                .withHeader(R.layout.main_drawer_header)
                .addDrawerItems(
                        PrimaryDrawerItem().withName(R.string.navigation_drawer_hospitals).withIcon(R.drawable.ic_hospital).withIdentifier(Navigation.HOSPITALS_LIST),
                        PrimaryDrawerItem().withName(R.string.navigation_drawer_clinics).withIcon(R.drawable.ic_hospital_1).withIdentifier(Navigation.CLINICS_LIST),
                        PrimaryDrawerItem().withName(R.string.navigation_drawer_gp_surgeries).withIcon(R.drawable.ic_doctor).withIdentifier(Navigation.GP_SURGERIES_LIST),
                        PrimaryDrawerItem().withName(R.string.navigation_drawer_dental_practices).withIcon(R.drawable.ic_dentist).withIdentifier(Navigation.DENTAL_LIST),
                        PrimaryDrawerItem().withName(R.string.navigation_drawer_pharmacies).withIcon(R.drawable.ic_pharmacy).withIdentifier(Navigation.PHARMACIES_LIST),
                        PrimaryDrawerItem().withName(R.string.navigation_drawer_social_care).withIcon(R.drawable.ic_health_care).withIdentifier(Navigation.SOCIAL_CARE_LIST))
                .addStickyDrawerItems(
                        PrimaryDrawerItem().withName(R.string.navigation_drawer_settings).withIcon(R.drawable.ic_settings).withIdentifier(Navigation.SETTINGS),
                        PrimaryDrawerItem().withName(R.string.navigation_drawer_feedback).withIcon(R.drawable.ic_message_1).withIdentifier(Navigation.FEEDBACK)
                )
                .withSavedInstance(savedInstanceState)
                .withOnDrawerItemClickListener(activity)
                // build only the view of the Drawer (don't inflate it automatically in our layout which is done with .build())
                .build()
    }

    fun saveInstanceState(outState: Bundle?): Bundle {
        var outState = outState
        //add the values which need to be saved from the drawer to the bundle
        outState = drawer.saveInstanceState(outState)
        //add the values which need to be saved from the accountHeader to the bundle
        return outState
    }

    fun isDrawerOpen() = drawer.isDrawerOpen

    fun setToolbar(activity: FragmentActivity?, toolbar: Toolbar, recreate: Boolean = false) {
        if (activity != null)
            drawer.setToolbar(activity, toolbar, recreate)
    }

    fun closeDrawer() = drawer.closeDrawer()
}