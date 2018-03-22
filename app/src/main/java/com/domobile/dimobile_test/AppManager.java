package com.domobile.dimobile_test;

import android.app.Application;


/*
 *  @创建者:   zhua
 *  @创建时间:  2018/3/21 20:24
 *  @描述：    自定义application
 */
public class AppManager
        extends Application
{
    //全局Context
    public static AppManager appManager;

    @Override
    public void onCreate() {
        super.onCreate();
        appManager = this;
    }

    public static AppManager getAppManager() {
        return appManager;
    }
}
