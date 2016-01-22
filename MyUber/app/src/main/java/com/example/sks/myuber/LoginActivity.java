package com.example.sks.myuber;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class LoginActivity extends Activity {
    private boolean isRember = true;
    private EditText mAdmin;
    private EditText mPwd;
    private MediaPlayer mediaPlayer;
    public static LoginActivity instantce;
    public static MediaPlayer mp;
    public static Timer t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        instantce = this;
        mp= MediaPlayer.create(LoginActivity.instantce, R.raw.mm);
        TextView login = (TextView) findViewById(R.id.tv_time_next);
        final Button rember = (Button) findViewById(R.id.rember_btn);
        mAdmin  = (EditText) findViewById(R.id.editText);
        mPwd  = (EditText) findViewById(R.id.editText2);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                sendData();
                Intent i   = new Intent(LoginActivity.this,WeekupTimeActivity.class);
                startActivity(i);
            }
        });
        rember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isRember) {
                    rember.setBackgroundResource(R.drawable.checkbox_select);
                } else {
                    rember.setBackgroundResource(R.drawable.checkbox_unselect);
                }
                isRember = !isRember;

            }
        });

        play();
    }
    public static void play(){
        if(mp.isPlaying()){
            return;
        }
        mp.start();
    }
    public static void stop(){
        mp.stop();
    }
    public static  boolean isPlay = false;
    @Override
    protected void onResume() {
        super.onResume();
        if(t!=null){
            t.cancel();
            t = null;
        }
        t = new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                if(isPlay){
                    play();
                }else{
                    stop();
                }
            }
        },0,1000);
    }

    /**
     * 获取内置SD卡路径
     * @return
     */
    public String getInnerSDCardPath() {
        return Environment.getExternalStorageDirectory().getPath();
    }
//    private void sendData(){
//        HttpUtils http = new HttpUtils();
//
//        http.send(HttpRequest.HttpMethod.GET, "http://193.168.4.68:7000/login", new RequestCallBack<Object>() {
//
//            @Override
//            public void onStart() {
//            }
//
//            @Override
//            public void onSuccess(ResponseInfo<Object> responseInfo) {
//                try {
//                    JSONObject jo = new JSONObject(responseInfo.result.toString());
////                    "end_place": "\u7ba1\u5e84", "start_place": "\u5c0f\u9ec4\u5e84", "avg_time": 578
//                    String end_place  = jo.getString("end_place");
//                    String start_place  = jo.getString("start_place");
//                    int avg_time  = jo.getInt("avg_time");
//                    Intent i   = new Intent(LoginActivity.this,WeekupTimeActivity.class);
//                    i.putExtra("start_place",start_place);
//                    i.putExtra("end_place",end_place);
//                    i.putExtra("avg_time",avg_time);
//                    startActivity(i);
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//
//            }
//
//            @Override
//            public void onFailure(HttpException e, String s) {
//            }
//        });
//
//    }
}
