package com.example.ActivityMove;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends ActionBarActivity implements OnClickListener {

	EditText editText1;
	Button button1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		editText1=(EditText)findViewById(R.id.editText1);
		button1=(Button)findViewById(R.id.button1);
		
		button1.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		String name = editText1.getText().toString().trim();
		
		Intent intent = new Intent(this,SecondActivity.class);
		intent.putExtra("name", name);
		startActivity(intent);
		
	}

}
