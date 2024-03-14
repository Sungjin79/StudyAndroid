package com.example.daumimage;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import android.support.v7.app.ActionBarActivity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class MainActivity extends ActionBarActivity implements OnItemClickListener,OnClickListener,OnScrollListener{

	private final String URL="https://apis.daum.net/search/image?"
			+ "q=%s"
			+ "&apikey=0ae59b4a30123e08b8e6c0809b330ff0"
			+ "&output=json"
			+ "&result=20"
			+ "&pageno=%d";
	
	//현재페이지
	public int page = 1;
	//화면에 리스트 마지막 아이템이 보여지는지 체크
	boolean lastItemvisibleFlag = false;
	
	
	EditText editText1;
	Button button1;
	ListView listView1;
	DisplayImageOptions options;
	ImageAdapter adapter;
	
	//footer
	View footerView = null;
	LinearLayout footer = null;
	
	//검색어
	String Keyword =null;
	
	//통신객체
	AsyncHttpClient client;
	ImageResponse response;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		client = new AsyncHttpClient();
		response = new ImageResponse();
		
		options=Imghelper.getInstance().getDisplayImageOptions(this);
		listView1= (ListView)findViewById(R.id.listView1);
		editText1=(EditText)findViewById(R.id.editText1);
		button1 = (Button)findViewById(R.id.button1);
		
		adapter = new ImageAdapter(this, R.layout.list_item, new ArrayList<Image>());
		listView1.setAdapter(adapter);
		
		button1.setOnClickListener(this);
		listView1.setOnItemClickListener(this);
		listView1.setOnScrollListener(this);
		
		//footer처리
		LayoutInflater inflater = getLayoutInflater();
		footerView = inflater.inflate(R.layout.list_footer, null);
		footer = (LinearLayout) footerView.findViewById(R.id.llFooterContainer);
		listView1.addFooterView(footerView);
		footer.setVisibility(View.GONE);

	}

	private class ImageAdapter extends ArrayAdapter<Image> {
		int resource;
		public ImageAdapter(Context context, int resource, List<Image> objects) {
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
			
			 Image item = getItem(position);
			 
			 if(item != null){
				 ImageView imageView1 = (ImageView) itemView.findViewById(R.id.imageView1);
				 TextView textView1 = (TextView) itemView.findViewById(R.id.textView1);
				 TextView textView2 = (TextView) itemView.findViewById(R.id.textView2);
				
				 textView1.setText(item.getTitle());
				 textView2.setText(item.getWidth()+" X "+item.getHeight());
				 
				 ImageLoader.getInstance().displayImage(item.getThumbnail(), imageView1, options);
			 }
			return itemView;
		}
		
		
	}
	
	
	
	//통신처리부분
	public class ImageResponse extends JsonHttpResponseHandler{
		
		ProgressDialog dialog;
		
		@Override
		public void onStart(){
			footer.setVisibility(View.VISIBLE);
			listView1.setSelectionFromTop(adapter.getCount(), 0);
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
				JSONObject channel = response.getJSONObject("channel");
				JSONArray item = channel.getJSONArray("item");
				
				Image.totalcount = channel.getInt("totalCount");
				Image.pagecount = channel.getInt("pageCount");
				Image.result = channel.getInt("result");
				
				for (int i = 0; i < item.length(); i++) {
					JSONObject temp = item.getJSONObject(i);
					
					String title = temp.getString("title");
					String link = temp.getString("link");
					String thumbnail = temp.getString("thumbnail");
					int width  = temp.getInt("width");
					int height  = temp.getInt("height");
					
					adapter.add(new Image(title, link, thumbnail, width, height));
				}
				
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		@Override
		public void onFinish(){
			footer.setVisibility(View.GONE);
		}
		
	}



	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		Keyword = editText1.getText().toString().trim();
		if(Keyword.equals("")){
			Toast.makeText(this, "검색어를 입력해 주세요", Toast.LENGTH_SHORT).show();
		}
		
		page=1;
		
		String searchUrl = String.format(URL, Keyword, page);
	
		adapter.clear();
		client.get(searchUrl, response);
		
	}



	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
		Image item= adapter.getItem(position);
		
		Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse(item.getLink()));
		startActivity(intent);
	}


	@Override
	public void onScroll(AbsListView view, int firstVisibleItem,
			int visibleItemCount, int totalItemCount) {
		// TODO Auto-generated method stub
		lastItemvisibleFlag = (totalItemCount>0)&&(firstVisibleItem+visibleItemCount >= totalItemCount);
	}


	
	@Override
	public void onScrollStateChanged(AbsListView view, int scrollState) {
		// TODO Auto-generated method stub
		
		if(scrollState ==OnScrollListener.SCROLL_STATE_IDLE && lastItemvisibleFlag){
			if(page<Image.pagecount){
				page++;
				String searchUrl=String.format(URL, Keyword, page);
				client.get(searchUrl, response);
			}
		}
		
	}



	
	
	
}
