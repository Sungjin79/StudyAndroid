package com.example.jsonnone;

import org.apache.http.Header;
import org.json.JSONException;
import org.json.JSONObject;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import android.support.v7.app.ActionBarActivity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity implements OnClickListener {
	
	private final String URL="http://itpaper.co.kr/demo/android/json/simple.json";
	
	TextView textView1;
	Button button1;
	
	//통신객체선언
		AsyncHttpClient client;
		HttpResponse response;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)  {
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
	
		/*Json형태
		 * 
		 * {
		    "device": {
		        "name": "안드로이드",
		        "type": "스마트폰"
		    }
		}
		
		*/
		
		client.get(URL, response);
		
	}
	
	
	
	
	
	public class HttpResponse extends JsonHttpResponseHandler{
			
			ProgressDialog dialog;
			
			@Override
			public void onStart(){
				dialog = new ProgressDialog(MainActivity.this);
				dialog.setMessage("잠시만 기다려주십시요");
				dialog.setCancelable(false);
				dialog.show();
			}
			
			//통신 접속실패시 호출됨
			@Override
			public void onFailure(int StateCode, Header[] headers,Throwable error,
					JSONObject errorResponse) {
				String errMessage ="StateCode1 : "+StateCode +"\n";
				errMessage += "Error Message : "+error.getMessage();
				textView1.setText(errMessage);
				
			}
			
			//통신은 이루어졌으나 서버에러
			
			@Override
			public void onFailure(int StateCode, Header[] headers,String responsString,Throwable error
					) {
				String errMessage ="StateCode2 : "+StateCode +"\n";
				errMessage += "Error Message : "+error.getMessage();
				textView1.setText(errMessage);
				
			}
	
			@Override
			public void onSuccess(int StateCode, Header[] Header, JSONObject response) {
				//String resultMessage ="StateCode : "+StateCode +"\n";
				try {
					JSONObject device = response.getJSONObject("device");
					String name = device.getString("name");
					String type = device.getString("type");
					
					textView1.setText(StateCode+"/"+name+"/"+type);
					
				} catch (JSONException e) {
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
