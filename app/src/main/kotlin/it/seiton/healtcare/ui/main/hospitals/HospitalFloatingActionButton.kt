package it.seiton.healtcare.ui.main.hospitals

import android.content.Context
import android.support.design.widget.FloatingActionButton
import android.util.AttributeSet
import it.seiton.healtcare.R
import it.seiton.healtcare.domain.model.HospitalEntity
import it.seiton.library.ui.gone
import it.seiton.library.ui.visible

/**
 * Created by lukasw44 on 23/10/2016.
 */
class HospitalFloatingActionButton : FloatingActionButton{

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    var listener: OnHospitalInfoClickListener? = null

    fun setOnHospitalInfoClickListener(listener: OnHospitalInfoClickListener){
        this.listener = listener
    }

    fun initAction(hospital: HospitalEntity){
        if(hospital.phone.isNotEmpty()){
            this.visible()
            this.setImageResource(R.drawable.ic_telephone_white)
            this.setOnClickListener { listener?.onPhoneItemClick(hospital) }
        }else if(hospital.email.isNotEmpty()){
            this.visible()
            this.setImageResource(R.drawable.ic_mail_white)
            this.setOnClickListener { listener?.onEmailItemClick(hospital) }
        }else if(hospital.website.isNotEmpty()){
            this.visible()
            this.setImageResource(R.drawable.ic_planet_earth_white)
            this.setOnClickListener { listener?.onWebsiteItemClick(hospital) }
        }else{
            this.gone()
        }
    }
}