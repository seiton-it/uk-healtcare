package it.seiton.healtcare.ui.main.clinics

import it.seiton.healtcare.R
import it.seiton.library.ui.fragment.BaseFragment

/**
 * Created by lukasw44 on 20/10/2016.
 */
class SocialCaresListFragment : BaseFragment() {
    override fun layoutResId(): Int = R.layout.fragment_socialcare_list

    companion object Factory {

        fun newInstance(): SocialCaresListFragment {
            val fragment: SocialCaresListFragment = SocialCaresListFragment()
            return fragment
        }
    }
}