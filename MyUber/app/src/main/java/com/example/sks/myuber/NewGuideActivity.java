package com.example.sks.myuber;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.example.sks.myuber.adapter.ViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;


public class NewGuideActivity extends Activity implements ViewPager.OnPageChangeListener {
    /**
     * 记录当前选中位置
     */
    private int mOldPosition = 0;
    /**
     * 五个点
     */
    private List<View> mDots;

    /**
     * 又圆点的layout
     */
    private LinearLayout mLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //如果系统版本是4.4(KITKAT)及以上,则使用透明状态栏+透明导航栏
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        setContentView(R.layout.activity_guide);
        mOldPosition = 0;
        initView();
    }

    /**
     * 初始化组件
     */
    private void initView() {
        // 实例化ViewPager
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        mLayout = (LinearLayout) findViewById(R.id.new_guide_index);
        mDots = new ArrayList<>();
        mDots.add(findViewById(R.id.dot_1));
        mDots.add(findViewById(R.id.dot_2));
        mDots.add(findViewById(R.id.dot_3));
        mDots.get(0).setBackgroundResource(R.drawable.shape_guide_focused);
        ViewPagerAdapter vpAdapter = new ViewPagerAdapter(this);
        viewPager.setAdapter(vpAdapter);
        // 设置监听
        viewPager.setOnPageChangeListener(this);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        if (position == 2) {
            mLayout.setVisibility(View.GONE);
        } else {
            mLayout.setVisibility(View.VISIBLE);
            mDots.get(mOldPosition).setBackgroundResource(R.drawable.shape_guide_normal);
            mDots.get(position).setBackgroundResource(R.drawable.shape_guide_focused);
            mOldPosition = position;
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
