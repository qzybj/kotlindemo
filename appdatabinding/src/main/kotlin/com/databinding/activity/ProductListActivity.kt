package com.databinding.activity

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.databinding.R
import com.databinding.adapter.ProductListAdapter
import com.databinding.databinding.ProductlistViewBinding
import com.databinding.presenter.ProductListPresenter

/**
 * Created by zyb
 *
 * @date 2018/3/28
 * @description
 */
class ProductListActivity : AppCompatActivity() {
    private var binding: ProductlistViewBinding? = null

    val items = listOf(
            "给初学者的RxJava2.0教程（七）: Flowable",
            "Android之View的诞生之谜",
            "Android之自定义View的死亡三部曲之Measure",
            "Using ThreadPoolExecutor in Android ",
            "Kotlin 泛型定义与 Java 类似，但有着更多特性支持。",
            "Android异步的姿势，你真的用对了吗？",
            "Android 高质量录音库。",
            "Android 边缘侧滑效果，支持多种场景下的侧滑退出。"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.productlist_view)
        binding!!.productListPresenter = ProductListPresenter()

        val rvView = findViewById(R.id.rv_list) as RecyclerView
        rvView.layoutManager = LinearLayoutManager(this)
        rvView.adapter = ProductListAdapter(items)
    }
}