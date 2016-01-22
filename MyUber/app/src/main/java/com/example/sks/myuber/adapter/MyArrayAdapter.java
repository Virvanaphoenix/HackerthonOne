package com.example.sks.myuber.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.sks.myuber.R;

import java.util.List;

/**
 * Created by sks on 2016/1/16.
 */
public class MyArrayAdapter extends BaseAdapter {

    private List<String> mList;
    private Context mContext;
    private LayoutInflater mInflater;
    public MyArrayAdapter(Context context,List<String> list){
        mContext = context;
        mList = list;
        mInflater = LayoutInflater.from(mContext);
    }
    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null){
            holder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.adapter_array,null);
            holder.mText = (TextView) convertView.findViewById(R.id.tv_adapter);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        String address = mList.get(position);
        holder.mText.setText(address);
        return convertView;
    }

    class ViewHolder{
        TextView mText;
    }
}
