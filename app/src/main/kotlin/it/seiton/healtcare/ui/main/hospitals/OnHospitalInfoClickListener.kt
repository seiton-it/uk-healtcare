package it.seiton.healtcare.ui.main.hospitals

import it.seiton.healtcare.domain.model.HospitalEntity

/**
 * Created by lukasw44 on 23/10/2016.
 */
interface OnHospitalInfoClickListener {
    fun onAddressItemClick(item: HospitalEntity)

    fun onPhoneItemClick(item: HospitalEntity)

    fun onEmailItemClick(item: HospitalEntity)

    fun onWebsiteItemClick(item: HospitalEntity)
}
