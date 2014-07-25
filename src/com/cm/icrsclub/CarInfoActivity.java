package com.cm.icrsclub;

import java.util.ArrayList;
import java.util.List;

import com.cm.icarsclub.R;
import com.cm.icrsclub.adapter.CarPicViewPagerAdapter;
import com.cm.icrsclub.constant.Constant;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

public class CarInfoActivity extends Activity {
	private ViewPager carPicViewPager;
	private CarPicViewPagerAdapter mAdapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_car_info);
		carPicViewPager = (ViewPager) findViewById(R.id.car_pic);
		initCarPicViewPager();
	}
	private void initCarPicViewPager() {
		// TODO Auto-generated method stub
//		LayoutParams params = carPicViewPager.getLayoutParams();
//		params.height = Constant.screenHeight/5;
//		carPicViewPager.setLayoutParams(params);
		
		List<View> views = new ArrayList<View>();
		for(int i=0;i<5;i++){
			View v = LayoutInflater.from(this).inflate(R.layout.car_pic_view, null);
			views.add(v);
		}
		mAdapter = new CarPicViewPagerAdapter(views);
		carPicViewPager.setAdapter(mAdapter);
	}
}
