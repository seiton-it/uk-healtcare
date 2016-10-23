package it.seiton.healtcare.ui.main

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.view.MenuItem
import android.view.View
import com.mikepenz.materialdrawer.Drawer
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem
import it.seiton.healtcare.R
import it.seiton.healtcare.ui.main.clinics.*
import it.seiton.healtcare.ui.main.hospitals.HospitalsListFragment
import it.seiton.library.ui.activity.BaseActivity
import it.seiton.library.ui.fragment.BaseFragment
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by lukasw44 on 17/10/2016.
 */
class MainActivity : BaseActivity(),  Drawer.OnDrawerItemClickListener {

    lateinit var navigation: MainNavigation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation = MainNavigation(this, savedInstanceState)
        navigation.setToolbar(this, toolbar)

        if (savedInstanceState == null) {
            replaceFragment(HospitalsListFragment.newInstance())
        }
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        val state = navigation.saveInstanceState(outState)
        super.onSaveInstanceState(state)
    }

    override fun onBackPressed() {
        if (navigation.isDrawerOpen()) {
            navigation.closeDrawer()
        } else {
            super.onBackPressed()
        }
    }

    override fun onItemClick(view: View?, position: Int, drawerItem: IDrawerItem<*, *>?): Boolean {
        val identifier = drawerItem!!.identifier

        when (identifier) {
            MainNavigation.Navigation.CLINICS_LIST -> replaceFragment(DentalListFragment.newInstance())
            MainNavigation.Navigation.GP_SURGERIES_LIST -> replaceFragment(GpListFragment.newInstance())
            MainNavigation.Navigation.DENTAL_LIST -> replaceFragment(DentalListFragment.newInstance())
            MainNavigation.Navigation.PHARMACIES_LIST -> replaceFragment(PharmaciesListFragment.newInstance())
            MainNavigation.Navigation.SOCIAL_CARE_LIST -> replaceFragment(SocialCaresListFragment.newInstance())
            MainNavigation.Navigation.SETTINGS -> replaceFragment(SettingsFragment.newInstance())
            MainNavigation.Navigation.FEEDBACK -> replaceFragment(FeedbackFragment.newInstance())
            else -> replaceFragment(HospitalsListFragment.newInstance())
        }

        if (navigation.isDrawerOpen()) {
            navigation.closeDrawer()
        }
        return true
    }

    private fun replaceFragment(fragment: BaseFragment) {
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.mainContent, fragment, fragment.fragmentTag())
                .commit()
    }
}
