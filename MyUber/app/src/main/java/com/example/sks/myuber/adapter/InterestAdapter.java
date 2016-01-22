package com.example.sks.myuber.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.sks.myuber.R;
import com.example.sks.myuber.bean.InterestBean;

import java.util.List;

/**
 * Created by sks on 2016/1/16.
 */
public class InterestAdapter extends BaseAdapter {

    private Context mContext;
    private List<InterestBean> mBeans;
    private LayoutInflater mInflater;

    public InterestAdapter(Context context,List<InterestBean> beans){
        mContext = context;
        mBeans = beans;
        mInflater = LayoutInflater.from(mContext);
    }


    @Override
    public int getCount() {
        return mBeans.size();
    }

    @Override
    public Object getItem(int position) {
        return mBeans.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null){
            holder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.interest_adapter,null);
            holder.mInterTiele = (TextView) convertView.findViewById(R.id.tv_interest_title);
            holder.mInterTime = (TextView) convertView.findViewById(R.id.tv_interest_time);
            holder.mInterTip = (TextView) convertView.findViewById(R.id.tv_interest_tip);

            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }

        InterestBean bean = mBeans.get(position);
        holder.mInterTiele.setText(bean.getmTitle());
        holder.mInterTime.setText(bean.getmTime());
        holder.mInterTip.setText(bean.getmTip());

        return convertView;
    }

    class ViewHolder{
        private TextView mInterTiele;
        private TextView mInterTime;
        private TextView mInterTip;
    }
}
