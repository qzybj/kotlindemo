package com.brady.apptest;

import android.app.Application;

import com.facebook.stetho.Stetho;

/**
 * Created by zyb
 *
 * @date 2017/11/7
 * @description
 */
public class MApplication extends Application {

    public static Application application;

    @Override
    public void onCreate() {
        super.onCreate();
        this.application = this;
        Stetho.initialize(
                Stetho.newInitializerBuilder(this)
                        .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                        .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
                        .build());
    }
}
