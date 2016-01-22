package com.example.sks.myuber.wheel;

import android.app.Activity;
import android.os.Bundle;

import com.example.sks.myuber.R;
import com.example.sks.myuber.Utils;


public class PayResultActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_finish);

        new Utils().notifi(this,"正在提前俩分钟自动为您叫车");
    }
}
