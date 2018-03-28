package com.databinding.activity

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.databinding.BR
import com.databinding.R
import com.databinding.databinding.UserEditActivityBinding
import com.databinding.model.User
import com.databinding.presenter.UserPresenter

/**
 * Created by zyb
 *
 * @date 2018/3/27
 * @description
 */
class UserEditActivity : AppCompatActivity() {
    private var user: User? = null
    private var mBinding: UserEditActivityBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.user_edit_activity)
        mBinding!!.userPresenter = UserPresenter()
        user = User()
        user!!.name = "111"
        user!!.address = "222"
        mBinding!!.setVariable(BR.user, user)
    }
}