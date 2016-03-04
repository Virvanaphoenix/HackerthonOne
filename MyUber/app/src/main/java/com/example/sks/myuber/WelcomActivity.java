package com.example.sks.myuber;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by feng on 2016/1/17.
 */
public class WelcomActivity extends Activity {

    private SharedPreferences mConfig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        mConfig = getSharedPreferences("config", Context.MODE_PRIVATE);

        Timer timer = new Timer();// 实例化Timer类
        timer.schedule(new TimerTask() {
            public void run() {
                boolean isNeedGuide = mConfig.getBoolean("is_need_guide", true);
                if (isNeedGuide){
                    startActivity(new Intent(WelcomActivity.this,NewGuideActivity.class));
                }else{
                    startActivity(new Intent(WelcomActivity.this,LoginActivity.class));
                }
                WelcomActivity.this.finish();
            }
        }, 1500);// 这里毫秒
    }
}
