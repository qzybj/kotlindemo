package com.databinding.model

import android.databinding.BaseObservable
import android.databinding.Bindable
import com.databinding.BR


/**
 * Created by zyb
 *
 * @date 2018/3/27
 * @description
 */
class Employee : BaseObservable {
    private var firstName: String? = null
    private var lastName: String? = null

    constructor() {}

    constructor(firstName: String, lastName: String) {
        this.firstName = firstName
        this.lastName = lastName
    }

    @Bindable
    fun getFirstName(): String? {
        return this.firstName
    }

    @Bindable
    fun getLastName(): String? {
        return this.lastName
    }

    @Bindable
    fun setFirstName(firstName: String) {
        this.firstName = firstName
        notifyPropertyChanged(BR.firstName)
    }

    fun setLastName(lastName: String) {
        this.lastName = lastName
        notifyPropertyChanged(BR.lastName)
    }

    override fun toString(): String {
        return "Employee{" +
                "firstName='" + firstName + '\''.toString() +
                ", lastName='" + lastName + '\''.toString() +
                '}'.toString()
    }
}
