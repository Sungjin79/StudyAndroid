package com.villmanager;


import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.os.Handler;

public class Main extends ActionBarActivity {

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		//2초 후에 화면이 사라집니다.
		Handler handler = new Handler();
		handler.postDelayed(new Runnable() {
			@Override
				public void run(){
					finish();
				}
			}, 2000);

		
//		getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);//화면이 꺼지지 않도록 하는 명령어
	}

	/*@Override
	public void onClick(View v) {
		Intent intent = new Intent(this, mainHome.class);
		startActivity(intent);

		overridePendingTransition(R.anim.push_left_in,R.anim.push_left_out);
		Toast.makeText(this, "시작하겠습니다.",Toast.LENGTH_SHORT).show();		
	}*/
	
	
}
