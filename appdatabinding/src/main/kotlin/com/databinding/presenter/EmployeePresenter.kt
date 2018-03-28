package com.databinding.presenter

import android.databinding.ObservableField
import android.text.TextUtils
import android.view.View
import com.brady.libutil.log.CLog
import com.brady.libutil.view.ToastUtil
import com.databinding.model.Employee

/**
 * Created by zyb
 *
 * @date 2018/3/27
 * @description
 */
class EmployeePresenter {
    private var employee: Employee? = null
    var firstName = ObservableField<String>()
    var lastName = ObservableField<String>()

    fun canSave(employee: Employee?): Boolean {
        if (employee == null
                || TextUtils.isEmpty(employee.getFirstName())
                || TextUtils.isEmpty(employee.getLastName())) {
            CLog.d("canSave false")
            return false
        }
        this.employee = employee
        CLog.d("canSave true")
        return true
    }

    fun save(view: View?) {
        ToastUtil.showToast(employee!!.toString())
    }
}
