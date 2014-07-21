package com.cm.icrsclub.fragment;

import com.cm.icarsclub.R;
import com.cm.icrsclub.adapter.CityListAdapter;
import com.cm.icrsclub.constant.Constant;
import com.cm.icrsclub.popup.ChangeCityPopup;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.transition.ChangeBounds;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class FindCarFragment extends Fragment implements OnClickListener, OnCheckedChangeListener, OnDismissListener {
	private RelativeLayout rl_find_car_map;
	private RelativeLayout rl_find_car;
	private RelativeLayout rl_title;
	private ImageView img_title;
	private TextView title_city;
	private CheckBox cb_chang_car_map;
	private ChangeCityPopup popup;
	private ListView find_car_listview;
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.fragment_find_car,container,false);
		rl_find_car_map = (RelativeLayout) view.findViewById(R.id.find_car_map);
		rl_find_car = (RelativeLayout) view.findViewById(R.id.find_car);
		rl_title = (RelativeLayout) view.findViewById(R.id.rl_title);
		img_title = (ImageView) view.findViewById(R.id.chang_city_img);
		title_city =(TextView) view.findViewById(R.id.city);
		cb_chang_car_map = (CheckBox) view.findViewById(R.id.chang_car_map);
		find_car_listview = (ListView) view.findViewById(R.id.find_car_list);
		
		rl_title.setOnClickListener(this);
		cb_chang_car_map.setOnCheckedChangeListener(this);
//		rl_find_car.setOnClickListener(this);
//		rl_find_car_map.setOnClickListener(this);
		return view;
	}
	
	

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.rl_title:
			img_title.setImageResource(R.drawable.ic_arrow_up_orange);
			int w = rl_title.getWidth();
			int h = rl_title.getHeight();
			popup = new ChangeCityPopup(getActivity());
			popup.setWidth(w);
			popup.setHeight(LayoutParams.WRAP_CONTENT);
			popup.showAsDropDown(rl_title, 0, 5*Constant.density);
			popup.setOnDismissListener(this);
			break;
		}
		
	}
	
	
	private Animation getTranslateAnimationDown(){
		TranslateAnimation anim = new TranslateAnimation(0, 0, 0, Constant.screenHeight);
		anim.setDuration(500);
		return anim;
	}
	private Animation getTranslateAnimationup(){
		TranslateAnimation anim = new TranslateAnimation(0, 0, Constant.screenHeight, 0);
		anim.setDuration(500);
		return anim;
	}

	@Override
	public void onCheckedChanged(CompoundButton arg0, boolean checked) {
		if(checked){
			rl_find_car.startAnimation(getTranslateAnimationDown());
			rl_find_car.setVisibility(View.GONE);
		}else{
			rl_find_car.startAnimation(getTranslateAnimationup());
			rl_find_car.setVisibility(View.VISIBLE);
		}
		
	}

	@Override
	public void onDismiss() {
		// TODO Auto-generated method stub
		img_title.setImageResource(R.drawable.ic_arrow_down_orange);
		String city = popup.getCity();
		if(!TextUtils.isEmpty(city)){
			title_city.setText("-"+city);
		}
	}
	
}
