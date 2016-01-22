package com.example.sks.myuber;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by feng on 2016/1/16.
 */
public class SettingActivity extends Activity {


    private TextView mNativeFile;
    private PopupWindow mPopupWindow;
    private List<String> mFileSize;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        mNativeFile = (TextView) findViewById(R.id.textView_selsct);
        setNativeFileSize();
        mNativeFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPw();
            }
        });
    }

    /**
     * popuwindow
     */
    private void showPw() {
        int textViewWidth = mNativeFile.getWidth() - 60;
        View view = View.inflate(this, R.layout.activity_select_drop, null);

        ListView listView = (ListView) view.findViewById(R.id.listView_drop);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                mNativeFile.setText(mFileSize.get(position));
                mPopupWindow.dismiss();
            }
        });

        listView.setAdapter(new ArrayAdapter(this,
                R.layout.list_view_item, R.id.text_view_item, mFileSize));

        mPopupWindow = new PopupWindow(view, textViewWidth,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        mPopupWindow.setOutsideTouchable(true);
        mPopupWindow.setTouchable(true);
        mPopupWindow.setFocusable(true);
        mPopupWindow.setBackgroundDrawable(new BitmapDrawable(getResources(), (Bitmap) null));
        mPopupWindow.showAsDropDown(mNativeFile, 10, 0);
    }

    private void setNativeFileSize() {
        mFileSize = new ArrayList<String>();
        mFileSize.add("5分");
        mFileSize.add("10分");
        mFileSize.add("20分");
        mFileSize.add("30分");
        mFileSize.add("45分");
        mFileSize.add("60分");
        mNativeFile.setText(mFileSize.get(1));
    }


}
