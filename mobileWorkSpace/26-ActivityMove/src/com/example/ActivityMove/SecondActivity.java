package com.example.ActivityMove;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends ActionBarActivity implements OnClickListener{
	TextView textView1;
	Button button1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);

		Intent fromIntent = getIntent();
		String name = fromIntent.getStringExtra("name");
		
		textView1=(TextView)findViewById(R.id.textView1);
		button1=(Button)findViewById(R.id.button1);
		button1.setOnClickListener(this);

		textView1.setText(name);
	
		
	}

	@Override
	public void onClick(View v) {
			finish();			
	}
}
