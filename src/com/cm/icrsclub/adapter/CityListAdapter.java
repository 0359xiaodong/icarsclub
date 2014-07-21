package com.cm.icrsclub.adapter;

import com.cm.icarsclub.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CityListAdapter extends BaseAdapter {
	private Context context;
	private String[] data;
	private LayoutInflater inflater;
	public CityListAdapter(Context context){
		data = context.getResources().getStringArray(R.array.city_array);
		inflater = LayoutInflater.from(context);
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		if(data != null){
			return data.length;
		}
		return 0;
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup arg2) {
		// TODO Auto-generated method stub
		TextView tv_city = null;
		if(convertView == null){
			convertView = inflater.inflate(R.layout.item_chang_city, null);
		}
		tv_city = (TextView) convertView;
		if(position == data.length-1){
			tv_city.setBackgroundResource(R.drawable.bg_item_city_bottom);
		}else{
			tv_city.setBackgroundResource(R.drawable.bg_item_city);
		}
		tv_city.setText(data[position]);
		return convertView;
	}

	public String getCity(int position){
		if(data != null && data.length > position){
			return data[position];
		}
		return null;
	}
	
}
