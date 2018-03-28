package com.databinding.presenter

import android.view.View
import com.brady.libutil.view.ToastUtil

/**
 * Created by zyb
 *
 * @date 2018/3/28
 * @description
 */
class MyHandlers {
    fun onClickFriend(view: View?) {
        ToastUtil.showToast("onClickFriend")
    }
}