package com.databinding.activity

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.databinding.BR

import com.databinding.R
import com.databinding.databinding.EmployeeEditActivityBinding
import com.databinding.model.Employee
import com.databinding.presenter.EmployeePresenter


/**
 * Created by zyb
 *
 * @date 2018/3/26
 * @description
 */
class EmployeeEditActivity : AppCompatActivity() {
    private var employee: Employee? = null
    private var mBinding: EmployeeEditActivityBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.employee_edit_activity)
        mBinding!!.employeePresenter = EmployeePresenter()
        employee = Employee()
        employee!!.setFirstName("111")
        employee!!.setLastName("222")
        mBinding!!.setVariable(BR.employee, employee)
    }
}