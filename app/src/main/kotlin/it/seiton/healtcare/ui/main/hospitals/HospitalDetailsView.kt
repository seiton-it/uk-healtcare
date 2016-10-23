package it.seiton.healtcare.ui.main.hospitals

import it.seiton.healtcare.domain.model.HospitalEntity
import it.seiton.library.ui.mvp.Mvp

/**
 * Created by lukasw44 on 22/10/2016.
 */
interface HospitalDetailsView : Mvp.View {

    fun showHospitalDetails(hospital: HospitalEntity)

}
