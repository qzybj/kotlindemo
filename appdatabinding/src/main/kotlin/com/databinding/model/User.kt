package com.databinding.model

/**
 * Created by zyb
 *
 * @date 2018/3/27
 * @description
 */
class User {
    var name: String? = null
    var address: String? = null
    var sex: Int? = null

    constructor() {}

    override fun toString(): String {
        return "User(name=$name, address=$address, sex=$sex)"
    }

}