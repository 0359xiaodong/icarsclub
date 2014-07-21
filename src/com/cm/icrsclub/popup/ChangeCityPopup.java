package com.cm.icrsclub.popup;

import com.cm.icarsclub.R;
import com.cm.icrsclub.adapter.CityListAdapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.PopupWindow;

public class ChangeCityPopup extends PopupWindow implements OnItemClickListener {
	private ListView lv_city;
	private CityListAdapter adapter;
	private String city;
	public ChangeCityPopup(Context context){
		View view = LayoutInflater.from(context).inflate(R.layout.popup_chang_city, null);
		lv_city = (ListView) view.findViewById(R.id.lv_city);
		adapter = new CityListAdapter(context);
		lv_city.setAdapter(adapter);
		setContentView(view);
		// 设置SelectPicPopupWindow弹出窗体可点击  
        this.setFocusable(true);  
        this.setOutsideTouchable(true); 
		
		 // 实例化一个ColorDrawable颜色为透明  
        ColorDrawable dw = new ColorDrawable(Color.TRANSPARENT);  
        // 点back键和其他地方使其消失,设置了这个才能触发OnDismisslistener ，设置其他控件变化等操作  
        this.setBackgroundDrawable(dw); 
        
        lv_city.setOnItemClickListener(this);
	}
	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
		// TODO Auto-generated method stub
		city = adapter.getCity(position);
		dismiss();
	}
	
	public String getCity(){
		return city;
	}
	
	
}
