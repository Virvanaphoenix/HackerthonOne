package com.example.sks.myuber;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.telephony.TelephonyManager;
import android.util.Log;

import java.io.IOException;

/**
 * Created by sks on 2016/1/17.
 */
public class MyBrodcast extends BroadcastReceiver {
    private static int state = 0;
    private MediaPlayer mediaPlayer;
    private static Intent i = new Intent(LoginActivity.instantce,MyService.class);
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.intent.action.PHONE_STATE")) {
            TelephonyManager tm = (TelephonyManager) context
                    .getSystemService(Service.TELEPHONY_SERVICE);
            switch (tm.getCallState()) {
                case TelephonyManager.CALL_STATE_RINGING:
                    Log.e("hg", "电话状态……RINGING1");
                    state = 1;
                    if(MyService.instance.isPlay){
                        MyService.instance.stop();
                    }
                    break;
                case TelephonyManager.CALL_STATE_OFFHOOK:
                    Log.e("hg", "电话状态……OFFHOOK2");
                    state = 2;
                    break;
                case TelephonyManager.CALL_STATE_IDLE:
                    Log.e("hg", "电话状态……IDLE0");
                    if(state  == 2){
                        LoginActivity.isPlay = true;
                        //挂断
                        if(!MyService.instance.isPlay){
                            LoginActivity.instantce.startService(i);
                        }else{
                            MyService.instance.stop();
                            LoginActivity.instantce.stopService(i);

                        }
                    }
                    state = 0;
                    break;
            }
        }
    }
    public void play(){
        boolean createState=false;
        if(mediaPlayer==null){
            mediaPlayer=createLocalMp3();
            createState=true;
        }else{
            mediaPlayer.stop();
            return;
        }
        //当播放完音频资源时，会触发onCompletion事件，可以在该事件中释放音频资源，
        //以便其他应用程序可以使用该资源:
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener(){
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.release();//释放音频资源
            }
        });
        try {
            //在播放音频资源之前，必须调用Prepare方法完成些准备工作
            if(createState) mediaPlayer.prepare();
            //开始播放音频
            mediaPlayer.start();
            Log.e("love", "stsssart");
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 创建本地MP3
     * @return
     */
    public MediaPlayer createLocalMp3(){
        /**
         * 创建音频文件的方法：
         * 1、播放资源目录的文件：MediaPlayer.create(MainActivity.this,R.raw.beatit);//播放res/raw 资源目录下的MP3文件
         * 2:播放sdcard卡的文件：mediaPlayer=new MediaPlayer();
         *   mediaPlayer.setDataSource("/sdcard/beatit.mp3");//前提是sdcard卡要先导入音频文件
         */
        MediaPlayer mp= MediaPlayer.create(LoginActivity.instantce, R.raw.mm);
        mp.stop();
        return mp;
    }
}
