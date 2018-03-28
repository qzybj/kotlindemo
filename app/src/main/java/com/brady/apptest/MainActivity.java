package com.brady.apptest;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.brady.apptest.util.Json2ModelUtil;
import com.brady.mylibrary.viewservice.ViewServer;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by zyb
 *
 * @date 2017/11/7
 * @description
 */
public class MainActivity extends Activity implements View.OnClickListener {
    TextView tv_text;
    /**
     * 英文简写如：12:01
     */
    public static String FORMAT_HM = "HH:00";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        initView();
        initData();
        ViewServer.get(this).addWindow(this);
    }

    private void initView() {
        tv_text = (TextView) findViewById(R.id.tv_text);
        tv_text.setOnClickListener(this);
    }

    private void initData() {
        //tv_text.setText( getCurrentTime(FORMAT_HM));
        tv_text.setText(Json2ModelUtil.readAssetResource("sysconfigjson.txt"));
    }

    /**
     * 获取当前时间，格式为可选
     *
     * @return
     */
    public static String getCurrentTime(String pattern) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(calendar.getTime());
    }

    public void onResume() {
        super.onResume();
        ViewServer.get(this).setFocusedWindow(this);
    }

    public void onDestroy() {
        super.onDestroy();
        ViewServer.get(this).removeWindow(this);
    }

    @Override
    public void onClick(View v) {
        if (v == tv_text) {
            //startActivity(new Intent(this, DataBindingTest.class));
        }
    }
}