package it.seiton.healtcare.ui.main.hospitals

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import it.seiton.common.ui.list.DividerItemDecoration
import it.seiton.healtcare.HealtcareComponent
import it.seiton.healtcare.R
import it.seiton.healtcare.application.HospitalsApplicationService
import it.seiton.healtcare.domain.model.HospitalEntity
import it.seiton.library.infrastructure.di.Injector
import it.seiton.library.ui.BaseFragment
import it.seiton.library.ui.recycler.OnItemClickListener
import it.seiton.library.ui.safeIsRtl
import kotlinx.android.synthetic.main.fragment_hospitals_list.*
import rx.android.schedulers.AndroidSchedulers
import rx.subscriptions.CompositeSubscription
import timber.log.Timber
import javax.inject.Inject

/**
 * Created by lukasw44 on 19/10/2016.
 */
class HospitalsListFragment : BaseFragment() {

    @Inject
    lateinit var hospitalService: HospitalsApplicationService

    val compositeSubscription: CompositeSubscription = CompositeSubscription()

    lateinit var hospitalAdapter: HospitalAdapter

    override fun layoutResId(): Int = R.layout.fragment_hospitals_list

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Injector.obtain(context.applicationContext, HealtcareComponent::class.java).inject(this)

        hospitalAdapter = HospitalAdapter(object : OnItemClickListener<HospitalEntity> {

        })
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        val linearLayout = LinearLayoutManager(context)
        rvRecyclerView.apply {
            layoutManager = linearLayout
            rvRecyclerView.setHasFixedSize(true)
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL_LIST, 0.0f, safeIsRtl()))
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        ensureRecyclerHasAdapter()

        fastScroll.setRecyclerView(rvRecyclerView)

        val hospitalSubscription = hospitalService.getAllHospitals()
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(hospitalAdapter)
                .subscribe(
                        { n ->
                            Timber.d("Get All Hospitals size: ${n.size}, first: ${n.first()}")
                        },
                        { e -> Timber.e(e, "Damn ... ") },
                        {
                            Timber.i("Completed")
                        }
                )

        compositeSubscription.add(hospitalSubscription)
    }

    override fun onPause() {
        super.onPause()
        compositeSubscription.unsubscribe()
    }

    private fun ensureRecyclerHasAdapter(){
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