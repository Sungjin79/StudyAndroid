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
import android.widget.TextView;

public class MainActivity extends ActionBarActivity implements OnClickListener {
	TextView textview1;
	Button button1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		textview1 = (TextView)findViewById(R.id.textView1);
		button1 = (Button)findViewById(R.id.button1);
		
		button1.setOnClickListener(this);
		
		
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		String memo =  textview1.getText().toString().trim();
		Intent intent = new Intent(this,SecondActivity.class);
		intent.putExtra("memo", memo);
		
		//수정한 후 결과값을 되돌려받음
		startActivityForResult(intent, 583);		
	}
	
	@Override
	public void onActivityResult(int requestcode,int resultCode,Intent data) {
		switch (requestcode) {
		case 583:
			if(resultCode==Activity.RESULT_OK){
				String edit = data.getStringExtra("edit");
				textview1.setText(edit);
			}
			break;

		}
		
	}
	
}
