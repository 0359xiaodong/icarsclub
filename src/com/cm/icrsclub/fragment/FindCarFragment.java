package com.cm.icrsclub.fragment;

import com.cm.icarsclub.R;
import com.cm.icrsclub.constant.Constant;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class FindCarFragment extends Fragment implements OnClickListener {
	private RelativeLayout rl_find_car_map;
	private RelativeLayout rl_find_car;
	private RelativeLayout rl_title;
	private ImageView img_title;
	private TextView title_city;
	
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
		
		rl_title.setOnClickListener(this);
		rl_find_car.setOnClickListener(this);
		rl_find_car_map.setOnClickListener(this);
		return view;
	}
	
	

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.find_car:
			rl_find_car.startAnimation(getTranslateAnimationDown());
			rl_find_car.setVisibility(View.GONE);
			break;
		case R.id.find_car_map:
			rl_find_car.startAnimation(getTranslateAnimationup());
			rl_find_car.setVisibility(View.VISIBLE);
			break;
		case R.id.rl_title:
			
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
	
}
