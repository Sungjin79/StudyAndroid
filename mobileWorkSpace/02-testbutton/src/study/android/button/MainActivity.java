package study.android.button;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity implements OnClickListener {

    //1.컴포넌트 객체선언
	TextView textview1;
	Button button1,button2;
	ImageButton imagebutton1,imagebutton2;
	
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //1)layout.activity_main create
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        imagebutton1=(ImageButton)findViewById(R.id.imageButton1);
        imagebutton2=(ImageButton)findViewById(R.id.imageButton2);
        
        //2)객체선언한 것 불러오기
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        imagebutton1.setOnClickListener(this);
        imagebutton2.setOnClickListener(this);        
    }

	@Override
	public void onClick(View arg0) {
		//파라미터id값 추출
		int id = arg0.getId();
		String message = null;
		
		switch (id) {
		case R.id.button1:
			button1.setText("선택하셨습니다.");
			button2.setText("여자");
			message ="당신은 남자입니다.";	
			break;
        case R.id.button2:
        	button1.setText("남자");
        	button2.setText("선택하셨습니다.");
			message ="당신은 여자입니다.";
			break;
        case R.id.imageButton1:
        	imagebutton1.setImageResource(R.drawable.ic_launcher);
        	imagebutton2.setImageResource(R.drawable.btn_girl);
        	message ="당신은 남자입니다.";	
        	break;
        case R.id.imageButton2:
        	imagebutton1.setImageResource(R.drawable.btn_boy);
        	imagebutton2.setImageResource(R.drawable.ic_launcher);
        	message ="당신은 여자입니다.";	
        	break;		
		}
		Toast t = Toast.makeText(this, message, Toast.LENGTH_SHORT);
		t.show();
		
	}

    
    

}