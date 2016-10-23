package it.seiton.healtcare.ui.main.hospitals

import it.seiton.healtcare.domain.model.HospitalEntity
import it.seiton.library.ui.mvp.Mvp

/**
 * Created by lukasw44 on 20/10/2016.
 */
interface HospitalListView : Mvp.View {

    fun showHospitals(items: List<HospitalEntity>)

    fun showHospitalDetails(item: HospitalEntity)
}