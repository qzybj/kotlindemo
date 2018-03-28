package com.databinding.presenter

import android.widget.SearchView

/**
 * Created by zyb
 *
 * @date 2018/3/28
 * @description
 */
class ProductListPresenter{
    fun search(){

    }

    var onQueryTextListener = object: SearchView.OnQueryTextListener {
        override fun onQueryTextSubmit(query: String): Boolean {

            return false
        }

        override fun onQueryTextChange(query: String): Boolean {
//            val filteredModelList = filter(adapter.getContacts(), query)
//            adapter.animateTo(filteredModelList)
//            if (recyclerView != null)
//                recyclerView.scrollToPosition(0)
            return true
        }
    }

}