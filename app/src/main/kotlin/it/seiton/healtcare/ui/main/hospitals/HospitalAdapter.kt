package it.seiton.healtcare.ui.main.hospitals

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.futuremind.recyclerviewfastscroll.SectionTitleProvider
import it.seiton.healtcare.R
import it.seiton.healtcare.domain.model.HospitalEntity
import it.seiton.library.ui.recycler.OnItemClickListener
import it.seiton.library.ui.recycler.RxRecyclerAdapter

/**
 * Created by lukasw44 on 19/10/2016.
 */
class HospitalAdapter(val listener: OnItemClickListener<HospitalEntity>) : RxRecyclerAdapter<HospitalEntity, HospitalAdapter.HospitalViewHolder>(), SectionTitleProvider {


    override fun onCreateViewHolder(inflater: LayoutInflater, parent: ViewGroup, viewType: Int): HospitalViewHolder {
        val hospitalView = inflater.inflate(R.layout.item_row_hospital, parent, false) as HospitalItemRowView
        val hospitalViewHolder = HospitalViewHolder(hospitalView)
        hospitalView.setOnClickListener({ v -> listener.onListItemClick(hospitalViewHolder.adapterPosition, getItem(hospitalViewHolder.adapterPosition))})
        return hospitalViewHolder
    }

    override fun onBindViewHolder(holder: HospitalViewHolder, position: Int) {
        val item: HospitalEntity = getItem(position)
        holder.onBind(item)
    }

    override fun getSectionTitle(position: Int): String {
        return getItem(position).organisationName.substring(0,1)
    }

    inner class HospitalViewHolder(val hospitalItem: HospitalItemRowView) : RecyclerView.ViewHolder(hospitalItem) {

        fun onBind(hospital: HospitalEntity) {
            hospitalItem.bindTo(hospital)
        }
    }

}