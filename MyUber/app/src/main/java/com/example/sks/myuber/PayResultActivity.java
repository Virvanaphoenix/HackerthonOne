package com.example.sks.myuber;

import android.app.Activity;
import android.os.Bundle;


public class PayResultActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_finish);
        new Utils().notifi(this, "正在提前俩分钟自动为您叫车");
    }
}
