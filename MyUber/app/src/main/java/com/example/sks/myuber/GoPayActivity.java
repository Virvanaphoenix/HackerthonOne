package com.example.sks.myuber;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class GoPayActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_go_pay);
        TextView login = (TextView) findViewById(R.id.tv_time_next);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               startActivity(new Intent(GoPayActivity.this, PayResultActivity.class));
            }
        });

    }
}
