package com.example.test;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.os.Build;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		Button btn = (Button) findViewById(R.id.btn);
		btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(MainActivity.this, BActivity.class));
			}
		});

	}

	public Bitmap getTurnOverBitmap(Bitmap bitmap) {
		Canvas canvas = new Canvas();
		Bitmap output = Bitmap.createBitmap(bitmap.getWidth(),
				bitmap.getHeight(), Config.ARGB_8888);
		canvas.setBitmap(output);
		Matrix matrix = new Matrix();
		// 缩放 当sy为-1时向上翻转 当sx为-1时向左翻转 sx、sy都为-1时相当于旋转180°
		matrix.postScale(1, -1);
		// 因为向上翻转了所以y要向下平移一个bitmap的高度
		matrix.postTranslate(0, bitmap.getHeight());
		canvas.drawBitmap(bitmap, matrix, null);
		return output;
	}

	int a;

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		if (a > 0) {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		a++;
		super.onResume();
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		Handler handler = new Handler();
		// handler.sendMessage(msg)
		super.onDestroy();
	}

}
