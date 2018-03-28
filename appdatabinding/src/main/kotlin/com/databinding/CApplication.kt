package com.databinding


import com.brady.coreframe.FastApplication
import com.brady.libutil.UtilsManager

/**
 * Created by zyb
 *
 * @date 2018/3/27
 * @description
 */
class CApplication : FastApplication() {
    override fun onCreate() {
        super.onCreate()
        UtilsManager.init(this)
    }
}
