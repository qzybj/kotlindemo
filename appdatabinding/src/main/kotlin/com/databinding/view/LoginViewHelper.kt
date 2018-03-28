package com.databinding.view

import android.databinding.ObservableField
import android.text.TextUtils
import android.view.View
import android.widget.Toast

/**
 * Created by zyb
 *
 * @date 2018/3/27
 * @description
 */
class LoginViewHelper {
    //监听属性
    var name = ObservableField<String>()
    var pwd = ObservableField<String>()

    /**
     * 登录点击回调
     */
    fun login(view: View) {
        Toast.makeText(view.context, "click login!", Toast.LENGTH_SHORT).show()
    }

    /**
     * 是否可以登录
     */
    fun canLogin(name: String, pwd: String): Boolean {
        return !(TextUtils.isEmpty(name) || !TextUtils.isEmpty(pwd))
    }
}
