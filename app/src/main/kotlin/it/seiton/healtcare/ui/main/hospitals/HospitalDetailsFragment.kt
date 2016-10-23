package it.seiton.healtcare.ui.main.hospitals

import android.os.Bundle
import android.view.View
import it.seiton.healtcare.HealtcareComponent
import it.seiton.healtcare.R
import it.seiton.healtcare.domain.model.HospitalEntity
import it.seiton.library.infrastructure.di.Injector
import it.seiton.library.ui.fragment.BaseMvpDialogFragment
import kotlinx.android.synthetic.main.fragment_hospital_details.*

/**
 * Created by lukasw44 on 20/10/2016.
 */
open class HospitalDetailsFragment : BaseMvpDialogFragment<HospitalDetailsView, HospitalDetailsPresenter>(), HospitalDetailsView {

    override fun layoutResId(): Int = R.layout.fragment_hospital_details

    override fun onCreatePresenter(): HospitalDetailsPresenter {
        return Injector.obtain(context.applicationContext, HealtcareComponent::class.java).hospitalDetailsPresenter()
    }

    override fun onCreateFragment(savedInstanceState: Bundle?) {
        super.onCreateFragment(savedInstanceState)
        Injector.obtain(context.applicationContext, HealtcareComponent::class.java).inject(this)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        toolbar.setNavigationOnClickListener {
            dismiss()
        }

        hospitalDetailsPanel.listener = presenter
        dialog.window.attributes.windowAnimations = R.style.DialogAnimation
        btFab.listener = presenter
    }

    override fun showHospitalDetails(hospital: HospitalEntity) {
        hospitalDetailsPanel.showHospital(hospital)
        collapsingToolbar.title = hospital.organisationName
        btFab.initAction(hospital)
    }

    override fun onDestroyView() {
        hospitalDetailsPanel.listener = null
        btFab.listener = null
        super.onDestroyView()
    }

    companion object {

        const val ARG_ID = "HospitalDetailsFragment.Id"

        fun newInstance(id: Int): HospitalDetailsFragment {
            val fragment: HospitalDetailsFragment = HospitalDetailsFragment()
            val args: Bundle = Bundle()
            args.putInt(ARG_ID, id)
            fragment.arguments = args
            return fragment
        }
    }
}