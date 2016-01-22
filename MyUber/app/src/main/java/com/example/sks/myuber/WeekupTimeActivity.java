package com.example.sks.myuber;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sks.myuber.wheel.AbstractWheelTextAdapter;
import com.example.sks.myuber.wheel.OnWheelChangedListener;
import com.example.sks.myuber.wheel.OnWheelScrollListener;
import com.example.sks.myuber.wheel.WheelView;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by sks on 2016/1/17.
 */
public class WeekupTimeActivity extends Activity {

    private ArrayList<String> mHourList;
    private ArrayList<String> mMinList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weekup);
        TextView textView = (TextView) findViewById(R.id.title);
        textView.setText("您的起床时间");

        findViewById(R.id.tv_w_next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(WeekupTimeActivity.this, SettingAddressActivity.class);
                String end_place = getIntent().getStringExtra("end_place");
                String start_place = getIntent().getStringExtra("start_place");
                int avg_time = getIntent().getIntExtra("avg_time", 0);
                i.putExtra("start_place", start_place);
                i.putExtra("end_place", end_place);
                i.putExtra("avg_time", avg_time);
                startActivity(i);
            }
        });
        setTime();
        WheelView mWv = (WheelView) findViewById(R.id.wheel);
        final CalendarTextAdapter mYearAdapter = new CalendarTextAdapter(this, mHourList,getCurrentIndex(1), 18, 16);
        mWv.setVisibleItems(3);
        mYearAdapter.setTextColor(getResources().getColor(R.color.blue));
        mYearAdapter.setTextMinColor(Color.GRAY);
        mWv.setViewAdapter(mYearAdapter);
        mWv.setCurrentItem(getCurrentIndex(1));
        setTextviewSize(getSysTime(1) + "", mYearAdapter);
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

        WheelView mWv2 = (WheelView) findViewById(R.id.wheel2);
        final CalendarTextAdapter mYearAdapter2 = new CalendarTextAdapter(this, mMinList,getCurrentMinIndex(0), 30, 20);
        mWv2.setVisibleItems(3);
        mYearAdapter2.setTextColor(getResources().getColor(R.color.blue));
        mYearAdapter2.setTextMinColor(Color.GRAY);
        mWv2.setViewAdapter(mYearAdapter2);
        mWv2.setCurrentItem(getCurrentMinIndex(0));
        setTextviewSize(getSysTime(2)+"", mYearAdapter2);
        Log.e("feng", "getSysTime(2) = " + getSysTime(2));
        mWv2.addChangingListener(new OnWheelChangedListener() {

            @Override
            public void onChanged(WheelView wheel, int oldValue, int newValue) {
                String currentText = (String) mYearAdapter2.getItemText(wheel.getCurrentItem());

            }
        });

        mWv2.addScrollingListener(new OnWheelScrollListener() {

            @Override
            public void onScrollingStarted(WheelView wheel) {

            }

            @Override
            public void onScrollingFinished(WheelView wheel) {
                String currentText = (String) mYearAdapter2.getItemText(wheel.getCurrentItem());
                setTextviewSize(currentText, mYearAdapter2);
            }
        });

    }
    private int getCurrentIndex(int hour){
        int index = 0;
        for (int i = 0; i < 24; i++) {
            if(i == getSysTime(hour)){
                index = i;
            }
        }
        return index-1;
    }
    private int getCurrentMinIndex(int hour){
        int index = 0;
        for (int i = 0; i < 60; i++) {
            if(i == getSysTime(hour)){
                index = i;
            }
        }
        return index;
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

    private int getSysTime(int t){
        Calendar c = Calendar.getInstance();
        int hour = 0;
        if (t == 1){
            hour = c.get(Calendar.HOUR_OF_DAY);
        }else {
            hour = c.get(Calendar.MINUTE);
        }
        return hour;
    }


    private void setTime(){
        mHourList = new ArrayList<>();
        mHourList.add("1");
        mHourList.add("2");
        mHourList.add("3");
        mHourList.add("4");
        mHourList.add("5");
        mHourList.add("6");
        mHourList.add("7");
        mHourList.add("8");
        mHourList.add("9");
        mHourList.add("10");
        mHourList.add("11");
        mHourList.add("12");
        mHourList.add("13");
        mHourList.add("14");
        mHourList.add("15");
        mHourList.add("16");
        mHourList.add("17");
        mHourList.add("18");
        mHourList.add("19");
        mHourList.add("20");
        mHourList.add("22");
        mHourList.add("23");
        mHourList.add("24");
        mMinList = new ArrayList<>();
        mMinList.add("00");
        mMinList.add("01");
        mMinList.add("02");
        mMinList.add("03");
        mMinList.add("04");
        mMinList.add("05");
        mMinList.add("06");
        mMinList.add("07");
        mMinList.add("08");
        mMinList.add("09");
        mMinList.add("10");
        mMinList.add("11");
        mMinList.add("12");
        mMinList.add("13");
        mMinList.add("14");
        mMinList.add("15");
        mMinList.add("16");
        mMinList.add("17");
        mMinList.add("18");
        mMinList.add("19");
        mMinList.add("20");
        mMinList.add("21");
        mMinList.add("22");
        mMinList.add("23");
        mMinList.add("24");
        mMinList.add("25");
        mMinList.add("26");
        mMinList.add("27");
        mMinList.add("28");
        mMinList.add("29");
        mMinList.add("30");
        mMinList.add("31");
        mMinList.add("32");
        mMinList.add("33");
        mMinList.add("34");
        mMinList.add("35");
        mMinList.add("36");
        mMinList.add("37");
        mMinList.add("38");
        mMinList.add("39");
        mMinList.add("40");
        mMinList.add("41");
        mMinList.add("42");
        mMinList.add("43");
        mMinList.add("44");
        mMinList.add("45");
        mMinList.add("46");
        mMinList.add("47");
        mMinList.add("48");
        mMinList.add("49");
        mMinList.add("50");
        mMinList.add("51");
        mMinList.add("52");
        mMinList.add("53");
        mMinList.add("54");
        mMinList.add("55");
        mMinList.add("56");
        mMinList.add("57");
        mMinList.add("58");
        mMinList.add("59");
    }
}
