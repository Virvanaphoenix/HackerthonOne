package com.example.sks.myuber.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sks.myuber.BreakfastActivity;
import com.example.sks.myuber.R;
import com.example.sks.myuber.bean.BreakfastBean;

import java.util.List;

/**
 * Created by sks on 2016/1/17.
 */
public class BreakfastAdapter extends BaseAdapter {

    private Context mContext;
    private List<BreakfastBean> mBeans;
    private LayoutInflater mInflater;
    public BreakfastAdapter(Context context,List<BreakfastBean> beans){
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
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null){
            holder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.adapter_breakfast,null);
            holder.mWeek = (TextView) convertView.findViewById(R.id.tv_week);
            holder.mFood = (TextView) convertView.findViewById(R.id.tv_food);
            holder.mPrice = (TextView) convertView.findViewById(R.id.tv_price);
            holder.mIcon = (ImageView) convertView.findViewById(R.id.imageView2);

            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }

        BreakfastBean bean = mBeans.get(position);
        Log.i("feng", "bean.getmWeek() =" + bean.getmWeek());
        Log.i("feng", "bean.getmWeek() =" + bean.getmWeek());
        holder.mWeek.setText(bean.getmWeek());
        holder.mFood.setText(bean.getmFood());
        holder.mPrice.setText(bean.getmPrice());
    if(BreakfastActivity.isSelect){
        holder.mIcon.setImageResource(bean.getmIcon());
    }else{
        holder.mIcon.setImageResource(bean.getmNoSelectIcon());
    }
        return convertView;
    }

    class ViewHolder{
        private TextView mWeek;
        private TextView mFood;
        private TextView mPrice;
        private ImageView mIcon;
    }
}
