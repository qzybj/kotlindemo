package com.databinding.presenter

import android.databinding.ObservableField
import android.text.TextUtils
import android.view.View
import com.brady.libutil.log.CLog
import com.brady.libutil.view.ToastUtil
import com.databinding.model.User

/**
 * Created by zyb
 *
 * @date 2018/3/27
 * @description
 */
 class UserPresenter{
    private var user: User? = null
    var name = ObservableField<String>()
    var address = ObservableField<String>()

    fun canSave(user: User?): Boolean {
        if (TextUtils.isEmpty(name.get())
                || TextUtils.isEmpty(address.get())) {
            CLog.d("canSave false")
            return false
        }
        this.user = user
        CLog.d("canSave true")
        return true
    }

    fun canSave(name: String?,address: String?): Boolean {
        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(address)) {
            CLog.d("canSave false")
            return false
        }
        CLog.d("canSave true")
        return true
    }

    fun save(view: View?) {
        user = User()
        user!!.name = name.get()
        user!!.address = address.get()
        ToastUtil.showToast(user!!.toString())
    }
}