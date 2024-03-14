package com.example.jsonarraylist;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import android.support.v7.app.ActionBarActivity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity implements OnItemClickListener {

	private final String URL="http://itpaper.co.kr/demo/android/json/list.json";
	
	DeviceAdapter adapter;
	ListView listView1;
	
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
		
		adapter = new DeviceAdapter(this, R.layout.list_item, new ArrayList<Device>());
		listView1 = (ListView)findViewById(R.id.listView1);
		listView1.setAdapter(adapter);
		listView1.setOnItemClickListener(this);
		
		
	}
	@Override
	public void onResume(){
		super.onResume();
		adapter.clear();
		client.get(URL,response);
	}

	private class DeviceAdapter extends ArrayAdapter<Device> {
		int resource;
		public DeviceAdapter(Context context, int resource, List<Device> objects) {
			super(context, resource, objects);
			this.resource=resource;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent){
			View itemView = convertView;
			
			
			 if(itemView==null){
				 LayoutInflater li = getLayoutInflater();
				 itemView = li.inflate(this.resource, null);
			 }
			
			 Device item = getItem(position);
			 
			 if(item != null){
				 TextView textView1 = (TextView) itemView.findViewById(R.id.textView1);
				 TextView textView2 = (TextView) itemView.findViewById(R.id.textView2);
				
				 textView1.setText(item.getName());
				 textView2.setText(item.getType());
				 
			 }
			return itemView;
		}
		
		
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		Device item = adapter.getItem(position);
		Toast.makeText(this, item.getName(), Toast.LENGTH_SHORT).show();
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
			String errMessage ="StateCode : "+StateCode +"\n";
			errMessage += "Error Message : "+error.getMessage();
			Toast.makeText(MainActivity.this, errMessage, Toast.LENGTH_SHORT).show();
		}
		
		//통신은 이루어졌으나 서버에러
		
		@Override
		public void onFailure(int StateCode, Header[] headers,String responsString,Throwable error
				) {
			String errMessage ="StateCode : "+StateCode +"\n";
			errMessage += "Error Message : "+error.getMessage();
			Toast.makeText(MainActivity.this, errMessage, Toast.LENGTH_SHORT).show();
			
		}

		@Override
		public void onSuccess(int StateCode, Header[] Header, JSONObject response) {
			//String resultMessage ="StateCode : "+StateCode +"\n";
			try {
				JSONArray device = response.getJSONArray("device");
				for (int i = 0; i < device.length(); i++) {
					JSONObject temp = device.getJSONObject(i);
					
					String name = temp.getString("name");
					String type = temp.getString("type");
					
					adapter.add(new Device(name, type));
				}
				
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
