package com.databinding.net

import java.net.URL

/**
 * Created by zyb
 *
 * @date 2018/3/29
 * @description
 */
class BaseRequest(val url: String) {

    companion object {
        val BASE_URL = "http://gank.io/api/"
    }

    fun run(): String {
        val resultStr = URL(url).readText()
        return resultStr
    }
}

