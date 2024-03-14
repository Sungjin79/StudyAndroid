package com.test.adapter;


import java.util.ArrayList;
import java.util.List;

import android.support.v7.app.ActionBarActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity implements OnItemClickListener,OnClickListener {
	EditText editText1,editText2;
	Button button1;
	ListView listview1;
	ContactAdapter adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		editText1 = (EditText)findViewById(R.id.editText1);
		editText2 = (EditText)findViewById(R.id.editText2);
		button1 = (Button)findViewById(R.id.button1);
		listview1 = (ListView)findViewById(R.id.listView1);
	
		adapter = new  ContactAdapter(this, R.layout.list_item, new ArrayList<contact>());
		listview1.setAdapter(adapter);
		
		button1.setOnClickListener(this);
		listview1.setOnItemClickListener(this);
		
		
	}

	//아답터의 기본형 제일 많이 쓰므로 가져다 쓸껏
	//아답터의 기본형 제일 많이 쓰므로 가져다 쓸껏
	//아답터의 기본형 제일 많이 쓰므로 가져다 쓸껏
	//아답터의 기본형 제일 많이 쓰므로 가져다 쓸껏
	//아답터의 기본형 제일 많이 쓰므로 가져다 쓸껏
	//아답터의 기본형 제일 많이 쓰므로 가져다 쓸껏
	
	private class ContactAdapter extends ArrayAdapter<contact> {
		int resource;
		public ContactAdapter(Context context, int resource, List<contact> objects) {
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
			
			 contact item = getItem(position);
			 
			 if(item != null){
				 TextView textView1 = (TextView) itemView.findViewById(R.id.textView1);
				 TextView textView2 = (TextView) itemView.findViewById(R.id.textView2);
				
				 textView1.setText(item.getName());
				 textView2.setText(item.getPhone());
				 
			 }
			return itemView;
		}
		
		
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		contact item = adapter.getItem(position);
		Toast.makeText(this, item.toString(), Toast.LENGTH_SHORT).show();
		
	}

	@Override
	public void onClick(View v) {
		String name = editText1.getText().toString().trim();
		String phonenumber = editText2.getText().toString().trim();
		
		contact contact = new contact(name, phonenumber);
		adapter.add(contact);
		
		editText1.setText("");
		editText2.setText("");
	}
	
}
