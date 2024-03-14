package com.example.paramsend;

import java.io.UnsupportedEncodingException;
import org.apache.http.Header;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import android.support.v7.app.ActionBarActivity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity implements OnClickListener {

	private final String URLGET="http://itpaper.co.kr/demo/android/txt/send_get.php";
	private final String URLPOST="http://itpaper.co.kr/demo/android/txt/send_post.php";
	
	EditText editText1,editText2;
	Button button1,button2;
	TextView textView1;
	
	//통신객체선언
		AsyncHttpClient client;
		HttpResponse response;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//통신객체할당 
		client = new AsyncHttpClient();
		response = new HttpResponse();
		
		editText1 = (EditText)findViewById(R.id.editText1);
		editText2 = (EditText)findViewById(R.id.editText2);
		button1=(Button)findViewById(R.id.button1);
		button2=(Button)findViewById(R.id.button2);
		textView1=(TextView)findViewById(R.id.textView1);
		
		button1.setOnClickListener(this);
		button2.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		RequestParams params = new RequestParams();
		
		params.put("user_id",editText1.getText().toString().trim());
		params.put("user_pw",editText2.getText().toString().trim());
		
		
		
		switch (v.getId()) {
		case R.id.button1:
				client.get(URLGET, params,response);
			break;

		case R.id.button2:
			client.post(URLPOST, params,response);
		break;
		}
	}
	
	
	
	public class HttpResponse extends AsyncHttpResponseHandler{
		
		ProgressDialog dialog;
		
		@Override
		public void onStart(){
			dialog = new ProgressDialog(MainActivity.this);
			dialog.setMessage("잠시만 기다려주십시요");
			dialog.setCancelable(false);
			dialog.show();
		}
		
		@Override
		public void onFailure(int StateCode, Header[] Header, byte[] body,
				Throwable error) {
			String errMessage ="StateCode : "+StateCode +"\n";
			errMessage += "Error Message : "+error.getMessage();
			textView1.setText(errMessage);
			
		}

		@Override
		public void onSuccess(int StateCode, Header[] Header, byte[] body) {
			// TODO Auto-generated method stub
			//String resultMessage ="StateCode : "+StateCode +"\n";
			try {
				
				String result = new String(body,"utf-8");
				if(result.equals("OK")){
					textView1.setText("로그인 성공");
				}else{
					textView1.setText("로그인 실패");
				}				
				
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		@Override
		public void onFinish(){
			dialog.dismiss();
			dialog = null;
		}
		
		
	}

}
