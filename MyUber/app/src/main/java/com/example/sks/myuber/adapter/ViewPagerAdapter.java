package com.example.sks.myuber.adapter;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.example.sks.myuber.LoginActivity;
import com.example.sks.myuber.R;

import java.util.ArrayList;

/**
 * @author YeChao
 * @功能描述：ViewPager适配器，用来绑定数据和view
 */
public class ViewPagerAdapter extends PagerAdapter {
    //界面列表
    private ArrayList<View> views;
    private LayoutInflater mInflater;
    private Context mContext;

    public ViewPagerAdapter(Context context) {
        mContext = context;
        mInflater = LayoutInflater.from(context);
        views = new ArrayList<>();
    }

    /**
     * 获得当前界面数
     */
    @Override
    public int getCount() {
        return 3;
    }

    /**
     * 判断是否由对象生成界面
     */
    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return (arg0 == arg1);
    }

    /**
     * 销毁position位置的界面
     */
    @Override
    public void destroyItem(View container, int position, Object object) {
        View temp = null;
        if (position < views.size()) {
            temp = views.get(position);
        }
        if (temp != null) {
            ((ViewPager) container).removeView(temp);
        }
    }

    /**
     * 初始化position位置的界面
     */
    @Override
    public Object instantiateItem(View container, int position) {
        View temp = null;
        if (position < views.size()) {
            temp = views.get(position);
        } else {
            switch (position) {
                case 0:
                    temp = mInflater.inflate(R.layout.activity_guide_imageview1, null);
                    break;
                case 1:
                    temp = mInflater.inflate(R.layout.activity_guide_imageview2, null);
                    break;
                case 2:
                    temp = mInflater.inflate(R.layout.activity_guide_imageview3, null);
                    Button button = (Button) temp.findViewById(R.id.btn_go);
                    button.setOnClickListener(new View.OnClickListener() {
                        @TargetApi(Build.VERSION_CODES.GINGERBREAD)
                        @Override
                        public void onClick(View v) {
                            SharedPreferences mConfig = mContext.getSharedPreferences("config", Context.MODE_PRIVATE);
                            mConfig.edit().putBoolean("is_need_guide", false).apply();
                            Intent intent = new Intent(mContext, LoginActivity.class);
                            mContext.startActivity(intent);
                        }
                    });
                    break;
            }
            views.add(temp);
        }
        ((ViewPager) container).addView(temp, 0);
        return temp;
    }
}
