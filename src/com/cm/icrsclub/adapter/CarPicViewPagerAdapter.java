package com.cm.icrsclub.adapter;

import java.util.List;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

public class CarPicViewPagerAdapter extends PagerAdapter {
	private List<View> carPicViews;
	
	public CarPicViewPagerAdapter(List<View> carPicViews){
		this.carPicViews = carPicViews;
	}
	
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return carPicViews.size();
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		// TODO Auto-generated method stub
		return arg0==arg1;
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		// TODO Auto-generated method stub
		container.removeView(carPicViews.get(position));
	}

	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		// TODO Auto-generated method stub
		container.addView(carPicViews.get(position), 0);//添加页卡  
		return carPicViews.get(position);
	}

	
}
