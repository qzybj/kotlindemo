package com.databinding.activity

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

import com.databinding.R
import com.databinding.databinding.LoginActivityBinding
import com.databinding.view.LoginViewHelper

/**
 * Created by zyb
 *
 * @date 2018/3/27
 * @description
 */
class LoginActivity : AppCompatActivity() {
    //DataBinding自动生成的类，命名规则是取xml文件名加Binding结尾
    private var binding: LoginActivityBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.login_activity)
        binding!!.loginViewHelper = LoginViewHelper()
    }
}

