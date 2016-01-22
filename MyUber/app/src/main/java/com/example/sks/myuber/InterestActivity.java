package com.example.sks.myuber;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.example.sks.myuber.adapter.InterestAdapter;
import com.example.sks.myuber.bean.InterestBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sks on 2016/1/16.
 */
public class InterestActivity extends Activity {

    private ListView mListView;
    private TextView mTvTitle;
    private List<InterestBean> mBeans;
    private InterestAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interest);
        mTvTitle = (TextView) findViewById(R.id.tv_title);
        mTvTitle.setText("您可能会对以下声音感兴趣");
        mListView = (ListView) findViewById(R.id.lv_interest);
        setData();
        mAdapter = new InterestAdapter(this,mBeans);
        mListView.setAdapter(mAdapter);

        findViewById(R.id.tv_next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(InterestActivity.this,BreakfastActivity.class));
            }
        });

    }

    private void setData(){
        mBeans = new ArrayList<>();
        InterestBean bean = new InterestBean();
        bean.setmTitle("规模越大，系统反而越脆弱");
        bean.setmTip("财经");
        bean.setmTime("18:17");
        mBeans.add(bean);
        bean = new InterestBean();
        bean.setmTitle("厉以宁：怎么把梳子卖给和尚");
        bean.setmTip("经济");
        bean.setmTime("15:13");
        mBeans.add(bean);
        bean = new InterestBean();
        bean.setmTitle("人类祖先靠什么征服了地球");
        bean.setmTip("文化");
        bean.setmTime("16:18");
        mBeans.add(bean);
        bean = new InterestBean();
        bean.setmTitle("核武器也不是万能的");
        bean.setmTip("军事");
        bean.setmTime("11:11");
        mBeans.add(bean);
    }
}
