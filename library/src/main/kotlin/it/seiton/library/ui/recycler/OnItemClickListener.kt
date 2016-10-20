package it.seiton.library.ui.recycler

import it.seiton.library.domain.model.BaseEntity
import timber.log.Timber

/**
 * Created by lukasw44 on 19/10/2016.
 */
interface OnItemClickListener<in E : BaseEntity> {

    fun onListItemClick(position: Int, item: E) {
        Timber.i("on recycler item click, position : $position, item : $item")
    }

}
