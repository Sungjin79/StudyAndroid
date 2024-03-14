package com.manage.bang;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;

public class Intro extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ActionBar actionBar = getActionBar();
		actionBar.hide(); //액션바 삭제
		setContentView(R.layout.intro);
		
		
		//2초 후에 화면이 사라집니다.
		Handler handler = new Handler();
		handler.postDelayed(new Runnable() {
			@Override
				public void run(){
					finish();
					overridePendingTransition(R.anim.push_left_in,R.anim.push_left_out);
				}
			}, 2500);		
	}

}
