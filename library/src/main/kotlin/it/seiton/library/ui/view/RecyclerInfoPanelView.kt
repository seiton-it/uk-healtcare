package it.seiton.library.ui.view

import android.content.Context
import android.util.AttributeSet
import android.view.animation.AnimationUtils
import android.widget.ViewAnimator
import it.seiton.library.R
import it.seiton.library.ui.inflate
import kotlinx.android.synthetic.main.custom_recycler_info_panel.view.*

/**
 * Created by lukasw44 on 23/10/2016.
 */
class RecyclerInfoPanelView(context: Context?, attrs: AttributeSet?) : ViewAnimator(context, attrs) {

    private val recyclerViewId: Int
    private val loadingResId: Int
    private val loadingMessageRes: Int

    init {
        this.inflate(R.layout.custom_recycler_info_panel, true)

        val a = context!!.theme.obtainStyledAttributes(attrs, R.styleable.RecyclerInfoPanelView, 0, 0)

        try {
            recyclerViewId = a.getResourceId(R.styleable.RecyclerInfoPanelView_recyclerViewId, R.id.recyclerViewContainer)
            loadingResId = a.getResourceId(R.styleable.RecyclerInfoPanelView_loadingDrawableId, R.drawable.ic_hospital_1)
            loadingMessageRes = a.getResourceId(R.styleable.RecyclerInfoPanelView_loadingMessage, R.string.loading_message)

            loadingSwitcher.setImageResource(loadingResId)
            loadingMessage.text = resources.getString(loadingMessageRes)
        } finally {
            a.recycle()
        }
    }

    fun showList() {
        this.setDisplayedChildId(recyclerViewId)
    }

    fun showError(message: String) {
        this.setDisplayedChildId( R.id.recyclerErrorContainer)
    }

    fun showLoading() {
        this.setDisplayedChildId(R.id.recyclerLoadingContainer)
        loadingSwitcher.animation = AnimationUtils.loadAnimation(context, R.anim.blink)
        loadingDots.start()
    }

    fun showEmpty() {
        this.setDisplayedChildId(R.id.recyclerEmptyContainer)
    }

    fun setDisplayedChildId(id: Int) {
        if (getDisplayedChildId() == id) {
            return
        }
        var i = 0
        val count = childCount
        while (i < count) {
            if (getChildAt(i).id == id) {
                displayedChild = i
                return
            }
            i++
        }
        val name = resources.getResourceEntryName(id)
        throw IllegalArgumentException("No view with ID " + name)
    }

    fun getDisplayedChildId(): Int {
        return getChildAt(displayedChild).id
    }

}