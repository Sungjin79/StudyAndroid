package com.example.activitymodify;

import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends ActionBarActivity implements OnClickListener {
	EditText edittext1;
	Button button1;
	Button button2;
	String memo;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
	
		Intent fromIntent = getIntent();
		memo = fromIntent.getStringExtra("memo");
		
		edittext1 = (EditText)findViewById(R.id.editText1);
		button1 = (Button)findViewById(R.id.button1);
		button2 = (Button)findViewById(R.id.button2);
		
		button1.setOnClickListener(this);
		button2.setOnClickListener(this);
		
		edittext1.setText(memo);
		
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.button1:
			
			String edittext = edittext1.getText().toString().trim();
			
			//되돌려줄 수정내용을 작성
			Intent intent = new Intent();
			intent.putExtra("edit", edittext);
			
			//결과값출력
			setResult(Activity.RESULT_OK,intent);
			finish();
			
			break;

		case R.id.button2:
			//결과값출력
			setResult(Activity.RESULT_CANCELED);
			break;
		}
		
		
	}

}
