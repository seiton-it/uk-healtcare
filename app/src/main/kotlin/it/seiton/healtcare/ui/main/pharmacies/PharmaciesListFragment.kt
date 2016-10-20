package it.seiton.healtcare.ui.main.clinics

import it.seiton.healtcare.R
import it.seiton.library.ui.BaseFragment

/**
 * Created by lukasw44 on 20/10/2016.
 */
class PharmaciesListFragment : BaseFragment() {
    override fun layoutResId(): Int = R.layout.fragment_gp_list

    companion object Factory {

        fun newInstance(): PharmaciesListFragment {
            val fragment: PharmaciesListFragment = PharmaciesListFragment()
            return fragment
        }
    }
}