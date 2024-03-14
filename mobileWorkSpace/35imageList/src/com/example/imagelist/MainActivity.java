package com.example.imagelist;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;

import com.example.imagelist.Imghelper;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;


public class MainActivity extends ActionBarActivity {
	
	final String URL_JSON = "http://itpaper.co.kr/demo/android/json/column.json";
	
	AsyncHttpClient client;
	ColumnResponse response;
	
	DisplayImageOptions options;

	ColumnAdapter adapter;
	ListView listView1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		client = new AsyncHttpClient();
		response = new ColumnResponse();
		
		options = Imghelper.getInstance().getDisplayImageOptions(this);
		
		adapter = new ColumnAdapter(this, R.layout.list_item, new ArrayList<Column>());
		listView1 = (ListView) findViewById(R.id.listView1);
		listView1.setAdapter(adapter);
		
	}
	
	@Override
	public void onResume(){
		super.onResume();
		adapter.clear();
		client.get(URL_JSON, response);
	}

	private class ColumnAdapter extends ArrayAdapter<Column> {
		int resource;
		public ColumnAdapter(Context context, int resource, List<Column> objects) {
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
			
			 Column item = getItem(position);
			 
			 if(item != null){
				 ImageView imageView1 = (ImageView) itemView.findViewById(R.id.imageView1);
				 TextView textView1 = (TextView) itemView.findViewById(R.id.textView1);
				 TextView textView2 = (TextView) itemView.findViewById(R.id.textView2);
				
				 textView1.setText(item.getSubject());
				 textView2.setText(item.getContent());
				 
				 ImageLoader.getInstance().displayImage(item.getImg(), imageView1, options);
			 }
			return itemView;
		}
		
		
	}

/*	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		Device item = adapter.getItem(position);
		Toast.makeText(this, item.getName(), Toast.LENGTH_SHORT).show();
	}
	*/
	
	public class ColumnResponse extends JsonHttpResponseHandler{
		
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
				JSONObject column = response.getJSONObject("column");
				JSONArray item = column.getJSONArray("item");
				for (int i = 0; i < item.length(); i++) {
					JSONObject temp = item.getJSONObject(i);
					
					int num  = temp.getInt("num");
					String img = temp.getString("img");
					String subject = temp.getString("subject");
					String content = temp.getString("content");
					
					adapter.add(new Column(num, img, subject, content));
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
