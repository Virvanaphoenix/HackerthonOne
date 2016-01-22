package com.example.sks.myuber;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class PinCarActivity extends Activity {
    LinearLayout mOtherLin;
    LinearLayout mSelfLin;
    TextView mOtherMoney;
    TextView mOtherTitle;
    TextView mOtherBring;
    TextView mSelfMoney;
    TextView mSelfTitle;
    TextView mSelfBring;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pin_car);
         mOtherLin = (LinearLayout) findViewById(R.id.other_lin);
         mSelfLin = (LinearLayout) findViewById(R.id.self_lin);
        mOtherMoney= (TextView) findViewById(R.id.other_money);
        mOtherTitle= (TextView) findViewById(R.id.other_title);
        mOtherBring= (TextView) findViewById(R.id.other_bring);
        mSelfMoney= (TextView) findViewById(R.id.self_money);
        mSelfTitle= (TextView) findViewById(R.id.self_title);
        mSelfBring= (TextView) findViewById(R.id.self_bring);
        mOtherLin.setEnabled(false);
        mOtherLin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setEnabled(false);
                mSelfLin.setEnabled(true);
                mOtherMoney.setTextColor(Color.parseColor("#f28d17"));
                mOtherTitle.setTextColor(Color.parseColor("#000000"));
                mOtherBring.setTextColor(Color.parseColor("#000000"));
                mSelfMoney.setTextColor(Color.parseColor("#989898"));
                mSelfTitle.setTextColor(Color.parseColor("#989898"));
                mSelfBring.setTextColor(Color.parseColor("#989898"));
            }
        });
        mSelfLin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setEnabled(false);
                mOtherLin.setEnabled(true);
                mOtherMoney.setTextColor(Color.parseColor("#989898"));
                mOtherTitle.setTextColor(Color.parseColor("#989898"));
                mOtherBring.setTextColor(Color.parseColor("#989898"));
                mSelfMoney.setTextColor(Color.parseColor("#f28d17"));
                mSelfTitle.setTextColor(Color.parseColor("#000000"));
                mSelfBring.setTextColor(Color.parseColor("#000000"));
            }
        });
        TextView login = (TextView) findViewById(R.id.tv_time_next);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PinCarActivity.this, GoPayActivity.class));
            }
        });
    }
}
