package it.seiton.healtcare.ui.main.clinics

import it.seiton.healtcare.R
import it.seiton.library.ui.fragment.BaseFragment

/**
 * Created by lukasw44 on 20/10/2016.
 */
class FeedbackFragment : BaseFragment() {
    override fun layoutResId(): Int = R.layout.fragment_feedback

    companion object Factory {

        fun newInstance(): FeedbackFragment {
            val fragment: FeedbackFragment = FeedbackFragment()
            return fragment
        }
    }
}