package it.seiton.healtcare.ui.main.hospitals

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import it.seiton.common.ui.list.DividerItemDecoration
import it.seiton.healtcare.HealtcareComponent
import it.seiton.healtcare.R
import it.seiton.healtcare.domain.model.HospitalEntity
import it.seiton.library.infrastructure.di.Injector
import it.seiton.library.ui.fragment.BaseMvpFragment
import it.seiton.library.ui.recycler.OnItemClickListener
import it.seiton.library.ui.safeIsRtl
import kotlinx.android.synthetic.main.fragment_hospitals_list.*

/**
 * Created by lukasw44 on 19/10/2016.
 */
class HospitalsListFragment : BaseMvpFragment<HospitalListView, HospitalListPresenter>(), HospitalListView {

    lateinit var hospitalAdapter: HospitalAdapter

    override fun layoutResId(): Int = R.layout.fragment_hospitals_list

    override fun onCreatePresenter(): HospitalListPresenter {
        return Injector.obtain(context.applicationContext, HealtcareComponent::class.java).hospitalListPresenter()
    }

    override fun onCreateFragment(savedInstanceState: Bundle?) {
        super.onCreateFragment(savedInstanceState)
        hospitalAdapter = HospitalAdapter(object : OnItemClickListener<HospitalEntity> {
            override fun onListItemClick(position: Int, item: HospitalEntity) {
                presenter.onItemClick(item)
            }
        })
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val linearLayout = LinearLayoutManager(context)
        rvRecyclerView.apply {
            layoutManager = linearLayout
            rvRecyclerView.setHasFixedSize(true)
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL_LIST, 0.0f, safeIsRtl()))
        }
        ensureRecyclerHasAdapter()

        fastScroll?.let{it->
            it.setRecyclerView(rvRecyclerView)
        }

        hospitalDetailsPanel?.let{it->
            it.listener = presenter
        }

        btFab?.let {
            btFab.listener = presenter
        }
    }

    override fun onDestroyView() {
        hospitalDetailsPanel?.let{it->
            it.listener = null
        }
        btFab?.let {
            btFab.listener = null
        }
        super.onDestroyView()
    }

    override fun showHospitals(items: List<HospitalEntity>) {
        hospitalAdapter.addAll(items)
    }

    override fun showHospitalDetails(item: HospitalEntity) {
        hospitalDetailsPanel.showHospital(item)
        btFab.initAction(item)
        tvOrganisationName.text = item.organisationName
    }

    private fun ensureRecyclerHasAdapter() {
        if (rvRecyclerView.adapter == null) {
            rvRecyclerView.adapter = hospitalAdapter
        }
    }

    companion object {
        fun newInstance(): HospitalsListFragment {
            return HospitalsListFragment()
        }
    }
}