package it.seiton.healtcare.ui.main.hospitals

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import it.seiton.healtcare.R
import it.seiton.healtcare.domain.model.HospitalEntity
import it.seiton.library.ui.gone
import it.seiton.library.ui.inflate
import it.seiton.library.ui.visible
import kotlinx.android.synthetic.main.custom_hospital_details.view.*

/**
 * Created by lukasw44 on 21/10/2016.
 */
open class HospitalDetailsPanel : LinearLayout {

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    init {
        this.inflate(R.layout.custom_hospital_details, true)
    }

    var listener: OnHospitalInfoClickListener? = null

    fun showHospital(hospital: HospitalEntity) {

        tvAddress.text = hospital.fullAddress
        tvCityAndCounty.text = hospital.cityAndCounty
        tvPostcode.text = hospital.postcode

        llAddressContainer.visible()
        llAddressContainer.setOnClickListener { listener?.onAddressItemClick(hospital) }

        if (hospital.phone.isNotEmpty()) {
            llPhoneContainer.visible()
            tvPhone.text = hospital.phone
            llPhoneContainer.setOnClickListener { listener?.onPhoneItemClick(hospital) }
        } else {
            llPhoneContainer.gone()
        }

        if (hospital.email.isNotEmpty()) {
            llEmailContainer.visible()
            tvEmail.text = hospital.email
            llEmailContainer.setOnClickListener { listener?.onEmailItemClick(hospital) }
        } else {
            llEmailContainer.gone()
        }

        if (hospital.website.isNotEmpty()) {
            llWebsiteContainer.visible()
            tvWebsite.text = hospital.website
            llWebsiteContainer.setOnClickListener { listener?.onWebsiteItemClick(hospital) }
        } else {
            llWebsiteContainer.gone()
        }

        if (hospital.fax.isNotEmpty()) {
            llFaxContainer.visible()
            tvFax.text = hospital.fax
        } else {
            llFaxContainer.gone()
        }

        if (hospital.sector.isNotEmpty()) {
            llSectorContainer.visible()
            tvSector.text = hospital.sector
        } else {
            llSectorContainer.gone()
        }
    }
}