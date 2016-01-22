package com.example.sks.myuber;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;

/**
 * Created by sks on 2016/1/17.
 */
public class MyService extends Service {
    private MediaPlayer mp;
    public static MyService instance;
    public static boolean isPlay = false;
    @Override
    public IBinder onBind(Intent intent) {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        mp= MediaPlayer.create(this, R.raw.mm);

    }
    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        Log.e("love", "server=start");
        mp.start();
        isPlay =true;
        new Utils().notifi(this, "正在为您播放：财富从哪里来");
    }
    public void stop(){
        if(mp!=null&&mp.isPlaying()) {
            mp.stop();
            new Utils().notifi(LoginActivity.instantce, "您今天的肉夹馍+豆浆组合已由司机送达");
        }
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();

    }
}
