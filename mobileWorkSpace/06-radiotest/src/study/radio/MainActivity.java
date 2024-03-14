package study.radio;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity implements OnClickListener,OnCheckedChangeListener {

	
	RadioGroup radioGroup1;
	TextView textView2;
	Button button1;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		radioGroup1 =(RadioGroup)findViewById(R.id.radioGroup1);
		textView2 = (TextView)findViewById(R.id.textView2);
		button1 = (Button)findViewById(R.id.button1);
		
		
		radioGroup1.check(R.id.radio1);
		
		radioGroup1.setOnCheckedChangeListener(this);
		button1.setOnClickListener(this);
		
	}

	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		switch (group.getId()) {
		case R.id.radio1:
			 RadioButton radio =(RadioButton) findViewById(checkedId);
			 
			 textView2.setText(radio.getText().toString());
			break;
		}
		
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.radio1:
			 int checkedId = radioGroup1.getCheckedRadioButtonId();
			 
			 RadioButton radio = (RadioButton) findViewById(checkedId);
			 
			 Toast.makeText(this, radio.getText().toString(), Toast.LENGTH_SHORT).show();
			break;
		}
		
		
		
	}
}
