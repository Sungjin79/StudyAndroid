package study.android.checkbox;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity implements OnClickListener ,OnCheckedChangeListener {

	//1.컴포넌트 객체선언
	Button button1;
	CheckBox checkBox1,checkBox2,checkBox3;
	TextView textView1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		checkBox1 = (CheckBox)findViewById(R.id.checkBox1);
		checkBox2 = (CheckBox)findViewById(R.id.checkBox2);
		checkBox3 = (CheckBox)findViewById(R.id.checkBox3);
		textView1 = (TextView)findViewById(R.id.textView1);
		button1 = (Button)findViewById(R.id.button1);
		
		checkBox1.setOnCheckedChangeListener(this);
		checkBox2.setOnCheckedChangeListener(this);
		checkBox3.setOnCheckedChangeListener(this);
		button1.setOnClickListener(this);
		
	}
	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		String msg = buttonView.getText().toString();
		if(isChecked){
			msg += "가 체크 되었습니다.";
		}else{
			msg += "가 해제 되었습니다.";
		}
		textView1.setText(msg);
	}
	@Override
	public void onClick(View v) {
		String msg = "";
		if (checkBox1.isChecked()) {
			msg += checkBox1.getText().toString()+",";
		}
		if (checkBox2.isChecked()) {
			msg += checkBox2.getText().toString()+",";
		}
		if (checkBox2.isChecked()) {
			msg += checkBox3.getText().toString()+",";
		}
		msg +="가 선택되었습니다.";
		Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
	}
	
	
}
