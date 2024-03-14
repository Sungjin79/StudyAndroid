package com.example.simplehttp;

import java.io.UnsupportedEncodingException;
import org.apache.http.Header;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity implements OnClickListener {
	
	private final String URL="http://itpaper.co.kr/demo/android/txt/simple_text.txt";
//	private final String URL="http://www.naver.com";
	
	TextView textView1;
	Button button1;
	
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
		
	
		button1=(Button)findViewById(R.id.button1);
		textView1= (TextView)findViewById(R.id.textView1);
		
		button1.setOnClickListener(this);
		
		
	
	}

	@Override
	public void onClick(View v) {
		client.get(URL, response);
		
		
	}
	
	//통신처리클래스
	public class HttpResponse extends AsyncHttpResponseHandler{

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
			String resultMessage ="StateCode : "+StateCode +"\n";
			try {
				resultMessage += new String(body, "utf-8");
				textView1.setText(resultMessage);
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	

}
