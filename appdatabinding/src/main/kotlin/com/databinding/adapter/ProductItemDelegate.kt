package com.databinding.adapter

import android.view.ViewGroup
import com.databinding.R
import com.databinding.adapter.baseadapter.base.ItemViewDelegate


/**
 * Created by tong on 2017/12/27.
 */

class ProductItemDelegate : ItemViewDelegate<IMoreModel> {
    val itemViewLayoutId: Int
        get() = R.layout.adapter_item_more

    fun isForViewType(item: IMoreModel, position: Int): Boolean {
        return item.getUiType() === IMoreModel.TYPE_NORMAL
    }

    fun convert(viewHolder: ViewHolder, item: IMoreModel, position: Int) {
        if (item is IItemParam) {
            val topView = viewHolder.getView(R.id.v_top)
            var layoutParams: ViewGroup.LayoutParams? = topView.getLayoutParams()
            if (layoutParams == null) {
                layoutParams = ViewGroup.LayoutParams(0, (item as IItemParam).getTopMargin())
            } else {
                layoutParams.height = (item as IItemParam).getTopMargin()
            }
            topView.setLayoutParams(layoutParams)
        }
        viewHolder.setText(R.id.tv, item.getTitle())
        viewHolder.setImageResource(R.id.iv, item.getIcon())
    }
}
