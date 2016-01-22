package com.example.sks.myuber.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * adater的共通类，继承该类可少实现几个通用的方法
 * 
 * @author wuwf
 *
 */
public abstract class AbCommonAdapter<T> extends BaseAdapter {
	protected Context mContext;
	protected List<T> mObjects;
	/**
	 * layoutinflater.
	 */
	protected LayoutInflater mInflater;

	public AbCommonAdapter(Context context, List<T> objects) {
		this.mContext = context;
		this.mObjects = objects;
		mInflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		return mObjects == null ? 0 : mObjects.size();
	}

	@Override
	public Object getItem(int position) {
		return mObjects == null ? null : mObjects.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = mInflater.inflate(getLayoutId(), parent, false);// 每一列的布局
		}

		getView(position, convertView);
		return convertView;
	}

	/**
	 * 每一项具体的布局，属性设置
	 * 
	 * @param position
	 * @param convertView
	 */
	public abstract void getView(int position, View convertView);

	/**
	 * 返回每一项用的布局
	 * 
	 * @return
	 */
	public abstract int getLayoutId();
}
