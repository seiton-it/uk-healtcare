package it.seiton.healtcare.ui.main.clinics

import it.seiton.healtcare.R
import it.seiton.library.ui.fragment.BaseFragment

/**
 * Created by lukasw44 on 20/10/2016.
 */
class DentalListFragment : BaseFragment() {
    override fun layoutResId(): Int = R.layout.fragment_dental_list

    companion object Factory {

        fun newInstance(): DentalListFragment {
            val fragment: DentalListFragment = DentalListFragment()
            return fragment
        }
    }
}