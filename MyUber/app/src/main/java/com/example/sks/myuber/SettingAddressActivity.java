package com.example.sks.myuber;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.sks.myuber.adapter.MyArrayAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sks on 2016/1/16.
 */
public class SettingAddressActivity extends Activity {

    private RelativeLayout mStartAddress;
    private RelativeLayout mEndAddress;
    private LinearLayout mLinearLayout;

    private PopupWindow mPopupWindow1;
    private PopupWindow mPopupWindow2;
    private TextView mTvStart;
    private TextView mTvEnd;

    private MyArrayAdapter mAdapter;

    private List<String> startList;
    private List<String> endList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);
        TextView mTvTitle = (TextView) findViewById(R.id.tv_title);
         mTvTitle.setText("您的上班路线");

        setStartAdd();
        setEndAdd();
        String end_place  = getIntent().getStringExtra("end_place");
        String start_place  =  getIntent().getStringExtra("start_place");
        int avg_time  =  getIntent().getIntExtra("avg_time",0);
        mLinearLayout = (LinearLayout) findViewById(R.id.linear);
        mTvStart = (TextView) findViewById(R.id.tv_start);
        mTvEnd = (TextView) findViewById(R.id.tv_end);
        mTvStart.setText(start_place);
        mTvEnd.setText(end_place);
        mStartAddress = (RelativeLayout) findViewById(R.id.rela_start);
        mEndAddress = (RelativeLayout) findViewById(R.id.rela_end);
        findViewById(R.id.tv_address_next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SettingAddressActivity.this,SettingTimeActivity.class));
            }
        });

        mStartAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showStartPw();
            }
        });

        mEndAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showEndPw();
            }
        });

    }

    /**
     * popuwindow 起点
     */
    private void showStartPw() {
        int textViewWidth = mLinearLayout.getWidth() + 70 ;
        View view = View.inflate(this, R.layout.activity_select_drop, null);
        ListView listView = (ListView) view.findViewById(R.id.listView_drop);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
//                mTvStart.setGravity(Gravity.CENTER);
                mTvStart.setHeight(mStartAddress.getHeight());
                mTvStart.setText(startList.get(position));
                mPopupWindow1.dismiss();
            }
        });

        mAdapter = new MyArrayAdapter(SettingAddressActivity.this,startList);
        listView.setAdapter(mAdapter);
        mPopupWindow1 = new PopupWindow(view, textViewWidth,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        mPopupWindow1.setOutsideTouchable(true);
        mPopupWindow1.setTouchable(true);
        mPopupWindow1.setFocusable(true);
        mPopupWindow1.setBackgroundDrawable(new BitmapDrawable(getResources(), (Bitmap) null));
        mPopupWindow1.showAsDropDown(mStartAddress, -40, -20);
    }

    /**
     * popuwindow 起点
     */
    private void showEndPw() {
        int textViewWidth = mLinearLayout.getWidth() + 70;
        View view = View.inflate(this, R.layout.activity_select_drop, null);
        ListView listView = (ListView) view.findViewById(R.id.listView_drop);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
//                mTvEnd.setGravity(Gravity.CENTER);
                mTvEnd.setHeight(mStartAddress.getHeight());
                mTvEnd.setText(endList.get(position));
                mPopupWindow2.dismiss();
            }
        });

        mAdapter = new MyArrayAdapter(SettingAddressActivity.this,endList);
        listView.setAdapter(mAdapter);
        mPopupWindow2 = new PopupWindow(view, textViewWidth,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        mPopupWindow2.setOutsideTouchable(true);
        mPopupWindow2.setTouchable(true);
        mPopupWindow2.setFocusable(true);
        mPopupWindow2.setBackgroundDrawable(new BitmapDrawable(getResources(), (Bitmap) null));
        mPopupWindow2.showAsDropDown(mEndAddress, -40, -20);
    }

    private void setStartAdd(){
        startList = new ArrayList<>();
        startList.add("回龙观龙城花园北二区18号楼");
        startList.add("通州DBC家州小镇C区");
        startList.add("望京方舟苑三期五号楼");
        startList.add("和平里七区2号楼");
        startList.add("海淀区霍营旗胜家园");
    }

    private void setEndAdd(){
        endList = new ArrayList<>();
        endList.add("海淀区丹棱街5号微软亚太研发集团1号楼");
        endList.add("朝阳区东三环中路49号建外soho东区A座");
        endList.add("东城区南竹竿胡同2号银河soho");
        endList.add("北京海淀区海淀北二街8号中关村SOHO");
        endList.add("北京市海淀区中关村东路1号院8号清华科技园");
    }
}
