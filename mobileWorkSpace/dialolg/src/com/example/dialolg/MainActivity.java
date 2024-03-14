package com.example.dialolg;

import android.support.v7.app.ActionBarActivity;
import android.app.AlertDialog.Builder;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends ActionBarActivity implements OnClickListener {
	
	Button button1,button2,button3;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		button1=(Button)findViewById(R.id.button1);
		button2=(Button)findViewById(R.id.button2);
		button3=(Button)findViewById(R.id.button3);
		
		button1.setOnClickListener(this);
		button2.setOnClickListener(this);
		button3.setOnClickListener(this);
		
	}


	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
	switch (v.getId()) {
	case R.id.button1:
		showalert();
		break;
	case R.id.button2:
		showconfirm();
		break;
	case R.id.button3:
		showlist();
		break;
	}
		
	}


	private void showlist() {
		// TODO Auto-generated method stub
		
	}


	private void showconfirm() {
		// TODO Auto-generated method stub
		
	}


	private void showalert() {
		// TODO Auto-generated method stub
		Builder 
		
		
		
	}

}
