package com.cm.icrsclub;

import com.cm.icarsclub.R;
import com.cm.icrsclub.constant.Constant;
import com.cm.icrsclub.fragment.FindCarFragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.util.DisplayMetrics;
import android.widget.LinearLayout;

@SuppressLint("Recycle")
public class MainActivity extends FragmentActivity{
	private FindCarFragment findFragment;
	private FragmentTransaction ft;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		initScreen();
		findFragment = new FindCarFragment();
		ft = getSupportFragmentManager().beginTransaction();
		ft.replace(R.id.content, findFragment).commit();
	}
	
	private void initScreen(){
		DisplayMetrics dm = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(dm);
		Constant.screenWidth = dm.widthPixels;
		Constant.screenHeight = dm.heightPixels;
		Constant.density = (int)dm.density;
	}
}
