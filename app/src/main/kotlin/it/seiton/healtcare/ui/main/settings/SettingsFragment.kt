package it.seiton.healtcare.ui.main.clinics

import it.seiton.healtcare.R
import it.seiton.library.ui.fragment.BaseFragment

/**
 * Created by lukasw44 on 20/10/2016.
 */
class SettingsFragment : BaseFragment() {
    override fun layoutResId(): Int = R.layout.fragment_settings

    companion object Factory {

        fun newInstance(): SettingsFragment {
            val fragment: SettingsFragment = SettingsFragment()
            return fragment
        }
    }
}