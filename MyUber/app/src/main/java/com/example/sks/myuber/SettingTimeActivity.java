package com.example.sks.myuber;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sks.myuber.wheel.AbstractWheelTextAdapter;
import com.example.sks.myuber.wheel.OnWheelChangedListener;
import com.example.sks.myuber.wheel.OnWheelScrollListener;
import com.example.sks.myuber.wheel.WheelView;

import java.util.ArrayList;

public class SettingTimeActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        TextView mTvTitle = (TextView) findViewById(R.id.title);
        mTvTitle.setText("从起床到下楼您需要");
        findViewById(R.id.tv_time_next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SettingTimeActivity.this, InterestActivity.class));
            }
        });
        WheelView mWv = (WheelView) findViewById(R.id.wheel);
        ArrayList<String> list = new ArrayList<>();
        list.add("5min");
        list.add("10min");
        list.add("20min");
        list.add("30min");
        list.add("45min");
        list.add("60min");
        final CalendarTextAdapter mYearAdapter = new CalendarTextAdapter(this, list,0, 30, 20);
        mWv.setVisibleItems(3);
        mYearAdapter.setTextColor(getResources().getColor(R.color.blue));
        mYearAdapter.setTextMinColor(Color.GRAY);
        mWv.setViewAdapter(mYearAdapter);
        mWv.setCurrentItem(0);
        setTextviewSize("5min", mYearAdapter);
        mWv.addChangingListener(new OnWheelChangedListener() {

            @Override
            public void onChanged(WheelView wheel, int oldValue, int newValue) {
                String currentText = (String) mYearAdapter.getItemText(wheel.getCurrentItem());

            }
        });

        mWv.addScrollingListener(new OnWheelScrollListener() {

            @Override
            public void onScrollingStarted(WheelView wheel) {

            }

            @Override
            public void onScrollingFinished(WheelView wheel) {
                String currentText = (String) mYearAdapter.getItemText(wheel.getCurrentItem());
                setTextviewSize(currentText, mYearAdapter);
            }
        });

    }
    /**
     *
     * @param curriteItemText
     * @param adapter
     */
    public void setTextviewSize(String curriteItemText, CalendarTextAdapter adapter) {
        ArrayList<View> arrayList = adapter.getTestViews();
        int size = arrayList.size();
        String currentText;
        for (int i = 0; i < size; i++) {
            TextView textvew = (TextView) arrayList.get(i);
            currentText = textvew.getText().toString();
            if (curriteItemText.equals(currentText)) {
                textvew.setTextSize(30);
                textvew.setTextColor(getResources().getColor(R.color.blue));
            } else {
                textvew.setTextSize(20);
                textvew.setTextColor(Color.GRAY);
            }
        }
    }
    private class CalendarTextAdapter extends AbstractWheelTextAdapter {
        ArrayList<String> list;

        protected CalendarTextAdapter(Context context, ArrayList<String> list, int currentItem, int maxsize, int minsize) {
            super(context, R.layout.item_birth_year, NO_RESOURCE, currentItem, maxsize, minsize);
            this.list = list;
            setItemTextResource(R.id.tempValue);
        }

        @Override
        public View getItem(int index, View cachedView, ViewGroup parent) {
            View view = super.getItem(index, cachedView, parent);
            return view;
        }

        @Override
        public int getItemsCount() {
            return list.size();
        }

        @Override
        protected CharSequence getItemText(int index) {
            return list.get(index) + "";
        }
    }
}
