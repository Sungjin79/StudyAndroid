package com.test.intent;

import android.support.v7.app.ActionBarActivity;
import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class MainActivity extends ActionBarActivity implements OnItemClickListener {

	ListView listview1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		listview1 = (ListView)findViewById(R.id.listView1);
		listview1.setOnItemClickListener(this);
		
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		switch (position) {
		case 0://전화다이얼러 호출
			Intent intent1 = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:01012345678"));
			startActivity(intent1);
			break;
		case 1://전화걸기
			Intent intent2 = new Intent(Intent.ACTION_CALL,Uri.parse("tel:01012345678"));
			startActivity(intent2);
			
			break;
		case 2://문자보내기
			Intent intent3 = new Intent(Intent.ACTION_SENDTO,Uri.parse("smsto:01047175344"));
			intent3.putExtra("sms_body", "SMSTEST입니다.");
			startActivity(intent3);
			
			break;
		case 3://메일발송호출
			Intent intent4 = new Intent(Intent.ACTION_SENDTO,Uri.parse("mailto:reconk2@naver.com"));
			intent4.putExtra(Intent.EXTRA_SUBJECT, "mail test 입니다.");
			intent4.putExtra(Intent.EXTRA_TEXT, "메일입니다.");
			startActivity(intent4);
			
			break;
		case 4://웹브라우져호출
			Intent intent5 = new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.naver.com"));
			startActivity(intent5);
			
			break;
		case 5://구글 웹검색
			Intent intent6 = new Intent(Intent.ACTION_WEB_SEARCH);
			intent6.putExtra(SearchManager.QUERY, "강아지");
			startActivity(intent6);
			
			break;
		case 6://특정앱에대한 구글플레이 조회
			Intent intent7 = new Intent(Intent.ACTION_VIEW,Uri.parse("market://details?id=deakyo.libro"));
			startActivity(intent7);
			
			break;
		case 7://동영상재생
			String videoPath = Environment.getExternalStorageDirectory().getAbsolutePath()+"/결로.mp4";
			Intent intent8 = new Intent(Intent.ACTION_VIEW,Uri.parse("market://details?id=deakyo.libro"));
			intent8.setDataAndType(Uri.parse("file://"+videoPath), "video/*");
			startActivity(intent8);
			break;
			
		case 8://mp3
			String audioPath = Environment.getExternalStorageDirectory().getAbsolutePath()+"/결로.mp3";
			Intent intent9 = new Intent(Intent.ACTION_VIEW,Uri.parse("market://details?id=deakyo.libro"));
			intent9.setDataAndType(Uri.parse("file://"+audioPath), "audio/*");
			startActivity(intent9);
			break;
		}
		
		
	}
}
