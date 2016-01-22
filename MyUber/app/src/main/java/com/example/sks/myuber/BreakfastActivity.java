package com.example.sks.myuber;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import com.example.sks.myuber.adapter.BreakfastAdapter;
import com.example.sks.myuber.bean.BreakfastBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sks on 2016/1/17.
 */
public class BreakfastActivity extends Activity {

    private CheckBox mBoy;
    private CheckBox mGirl;
    private ListView mListView;
    private List<BreakfastBean> mBeans;
    private BreakfastAdapter mAdapter;
    public static boolean isSelect = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breakfast);
        TextView textView = (TextView) findViewById(R.id.tv_title);
        setData();

        mBoy = (CheckBox) findViewById(R.id.cb_boy);
        mGirl = (CheckBox) findViewById(R.id.cb_girl);
        mListView = (ListView) findViewById(R.id.lv_break);
        findViewById(R.id.tv_b_next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BreakfastActivity.this,PinCarActivity.class));
            }
        });

        textView.setText("是否需要司机带早餐");
         mAdapter = new BreakfastAdapter(this,mBeans);
        Log.i("feng", "mBeans = " + mBeans.size());
        mListView.setAdapter(mAdapter);
        mBoy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mBoy.isChecked()){
                    if(mGirl.isChecked()){
                        mGirl.setChecked(false);
                    }
                    isSelect = true;
                }else{
                    isSelect = false;
                    if(!mGirl.isChecked()){
                        mBoy.setChecked(true);
                        isSelect = true;
                    }
                }
                mAdapter.notifyDataSetChanged();
            }
        });
        mGirl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mGirl.isChecked()){
                    if(mBoy.isChecked()){
                        mBoy.setChecked(false);
                    }
                    isSelect = false;
                }else{
                    isSelect = true;
                    if(!mBoy.isChecked()){
                        mGirl.setChecked(true);
                        isSelect = false;
                    }
                }
                mAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        isSelect = true;
    }

    private void setData(){
        mBeans = new ArrayList<>();
        BreakfastBean bean = new BreakfastBean();
        bean.setmWeek("周一");
        bean.setmFood("咖啡 + 甜甜圈");
        bean.setmPrice("￥ 25");
        bean.setmIcon(R.drawable.one_true);
        bean.setmNoSelectIcon(R.drawable.one_false);
        mBeans.add(bean);
        bean = new BreakfastBean();
        bean.setmWeek("周二");
        bean.setmFood("豆花 + 烧饼");
        bean.setmPrice("￥ 10");
        bean.setmIcon(R.drawable.two_true);
        bean.setmNoSelectIcon(R.drawable.two_false);
        mBeans.add(bean);
        bean = new BreakfastBean();
        bean.setmWeek("周三");
        bean.setmFood("寿司 + 煎蛋");
        bean.setmPrice("￥ 15");
        bean.setmIcon(R.drawable.three_true);
        bean.setmNoSelectIcon(R.drawable.three_false);
        mBeans.add(bean);
        bean = new BreakfastBean();
        bean.setmWeek("周四");
        bean.setmFood("八宝粥 +  蒸饺");
        bean.setmPrice("￥ 10");
        bean.setmIcon(R.drawable.four_true);
        bean.setmNoSelectIcon(R.drawable.four_false);
        mBeans.add(bean);
        bean = new BreakfastBean();
        bean.setmWeek("周五");
        bean.setmFood("豆浆  +  油饼");
        bean.setmPrice("￥ 7");
        bean.setmIcon(R.drawable.five_true);
        bean.setmNoSelectIcon(R.drawable.five_false);
        mBeans.add(bean);
    }
}
