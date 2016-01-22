package com.example.sks.myuber;

import android.app.Application;

/**
 * Created by sks on 2016/1/17.
 */
public class MyApplication extends Application {
    private static MyApplication instance;
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

    }
    public static MyApplication getInstance(){
        return instance;
    }
}
