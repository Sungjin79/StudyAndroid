package com.villmanager;

import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBar.LayoutParams;
import android.support.v7.app.ActionBarActivity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class mainHome extends ActionBarActivity implements OnClickListener {

	private Button address,money,etc,binbang;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//커스텀액션바
		customActionBar();
		//스플레시
		startActivity(new Intent(this, Main.class));
		
		setContentView(R.layout.mainhome);
		address = (Button) findViewById(R.id.button1);
		money = (Button) findViewById(R.id.button2);
		etc = (Button) findViewById(R.id.button3);
		binbang = (Button) findViewById(R.id.button4);
		
		address.setOnClickListener(this);
		money.setOnClickListener(this);
		etc.setOnClickListener(this);
		binbang.setOnClickListener(this);
	
	}

	@Override
	public void onClick(View v) {
		Intent intent = null;
		switch (v.getId()) {
		case R.id.button1:
			intent = new Intent(this, roomList.class);
			startActivity(intent);
			overridePendingTransition(R.anim.push_left_in,R.anim.push_left_out);
			
			
			/*Toast.makeText(this, "1번 버튼 눌렀습니다.",Toast.LENGTH_SHORT).show();*/	
			break;
		case R.id.button2:
			
//			intent = new Intent(this, test.class);
//			startActivity(intent);
			overridePendingTransition(R.anim.push_left_in,R.anim.push_left_out);
			
			Toast.makeText(this, "2번버튼 눌렀습니다.",Toast.LENGTH_SHORT).show();	
			break;		
		case R.id.button3:
			Toast.makeText(this, "3번 버튼 눌렀습니다.",Toast.LENGTH_SHORT).show();	
			break;
		case R.id.button4:
			Toast.makeText(this, "4번버튼 눌렀습니다.",Toast.LENGTH_SHORT).show();	
			break;		
		}
		
		
		
	}
	
	/*@TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)*/
    private void customActionBar() {
          ActionBar actionBar = getSupportActionBar();          
  		    //actionBar.hide(); //액션바 삭제
          
          //actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#004d40"))); 배경색바꾸기
          actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.backempty));;
          actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_HOME);
          actionBar.setDisplayShowCustomEnabled(true);
          
          /*actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM | ActionBar.DISPLAY_SHOW_HOME | ActionBar.DISPLAY_HOME_AS_UP);  
           *                                       커스텀글자 ,아이콘,뒤로가기 */
    
          //커스텀Actionbar 추가하는 방법
          LayoutParams layout = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT); 
          ViewGroup actionBarLayout = (ViewGroup) getLayoutInflater().inflate(R.layout.custom_actionbar, null);
          
          //font바꾸는 방법
          TextView textView1 = (TextView) actionBarLayout.findViewById(R.id.textViewTitle);
          Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/HoonPinkpungchaR.ttf");
          textView1.setTypeface(typeface);
          
          actionBar.setCustomView(actionBarLayout, layout);
    }

    @Override
	public void onBackPressed() {
		
		new AlertDialog.Builder(mainHome.this)
		.setTitle("한방을 종료 하시겠습니까?")
		.setNegativeButton("아니요", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int whichButton) {
				//do nothing
			}
		})
		.setPositiveButton("예", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int whichButton) {
				finish();
				overridePendingTransition(0,R.anim.zoom_exit);
			}
		})
		.show();		
	}
	
}
