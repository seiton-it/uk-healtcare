package it.seiton.healtcare.ui.main.hospitals

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import it.seiton.healtcare.domain.model.HospitalEntity
import kotlinx.android.synthetic.main.item_row_hospital.view.*

/**
 * Created by lukasw44 on 19/10/2016.
 */
class HospitalItemRowView : LinearLayout {

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    fun bindTo(hospital: HospitalEntity) {
        tvName.text = hospital.organisationName
        tvAddress.text = hospital.fullAddress
        tvCityAndCounty.text = hospital.cityAndCounty
        tvPostcode.text = hospital.postcode
    }

}