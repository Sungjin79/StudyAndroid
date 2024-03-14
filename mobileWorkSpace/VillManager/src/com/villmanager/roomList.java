package com.villmanager;

import java.util.ArrayList;
import java.util.List;

import com.villmanager.model.room;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class roomList extends ActionBarActivity implements  OnItemSelectedListener,OnItemClickListener{
	private Spinner selecthouse;
	
	private ListView roomnolist;
	private RoomAdapter adapter; 
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.roomlist);
		
		selecthouse=(Spinner)findViewById(R.id.selecthouse);
		roomnolist=(ListView)findViewById(R.id.roomlist);
		adapter= new RoomAdapter(this, R.layout.listrow, new ArrayList<room>());
		
		selecthouse.setSelection(0);
		selecthouse.setOnItemSelectedListener(this);
		
	}
	
	/*집선택 이벤트*/	
	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position,
			long id) {
		
		switch (parent.getId()) {
		case R.id.selecthouse:
			int selectedNo = (Integer)position;
			adapter.clear();// 초기화
			if(selectedNo==0){
				addDatayujin();
				roomnolist.setOnItemClickListener(this);
//				Toast.makeText(this, "유진빌이다...",Toast.LENGTH_SHORT).show();
			}
			if(selectedNo==1){
				addDatauchang();
				roomnolist.setOnItemClickListener(this);
//				Toast.makeText(this, "우창빌이다...",Toast.LENGTH_SHORT).show();
			}
			roomnolist.setAdapter(adapter);
			break;
		}
		
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		room item = adapter.getItem(position);
		Toast.makeText(this, item.toString(),Toast.LENGTH_SHORT).show();
		
	}
	
	private class RoomAdapter extends ArrayAdapter<room> {
		int resource;
		public RoomAdapter(Context context, int resource, List<room> objects) {
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
			
			 room item = getItem(position);
			 
			 if(item != null){
				 TextView textView1 = (TextView) itemView.findViewById(R.id.textView1);
				 TextView textView2 = (TextView) itemView.findViewById(R.id.textView2);
				 ImageView ImageView1= (ImageView) itemView.findViewById(R.id.imageView1);
				 
				 textView1.setText(item.getRoomName());
				 textView2.setText(item.getRoomid());
				 ImageView1.setImageResource(item.getImg());
				 
				 
			 }
			return itemView;
		}
	}
	
		
	 public void addDatauchang() {
		    adapter.add(new room("u101", "우창101호", R.drawable.bang101));
		    adapter.add(new room("u102", "우창102호", R.drawable.bang102));
		    adapter.add(new room("u103", "우창103호", R.drawable.bang103));
		    adapter.add(new room("u201", "우창201호", R.drawable.bang201));
		    adapter.add(new room("u202", "우창202호", R.drawable.bang202));
		    adapter.add(new room("u203", "우창203호", R.drawable.bang203));
		    adapter.add(new room("u204", "우창204호", R.drawable.bang204));
		    adapter.add(new room("u301", "우창301호", R.drawable.bang301));
		    adapter.add(new room("u302", "우창302호", R.drawable.bang302));
		    adapter.add(new room("u303", "우창303호", R.drawable.bang303));
		    adapter.add(new room("u304", "우창304호", R.drawable.bang304));
		    adapter.add(new room("u401", "우창401호", R.drawable.bang401));
		    adapter.add(new room("u402", "우창402호", R.drawable.bang402));
		    adapter.add(new room("u403", "우창403호", R.drawable.bang403));
		    adapter.add(new room("u404", "우창404호", R.drawable.bang404));
		  }	
	 public void addDatayujin() {
		 adapter.add(new room("y101", "1층 상가", R.drawable.bang101));
		 adapter.add(new room("y201", "유진201호", R.drawable.bang201));
		 adapter.add(new room("y202", "유진202호", R.drawable.bang202));
		 adapter.add(new room("y203", "유진203호", R.drawable.bang203));
		 adapter.add(new room("y204", "유진204호", R.drawable.bang204));
		 adapter.add(new room("y301", "유진301호", R.drawable.bang301));
		 adapter.add(new room("y302", "유진302호", R.drawable.bang302));
		 adapter.add(new room("y303", "유진303호", R.drawable.bang303));
		 adapter.add(new room("y304", "유진304호", R.drawable.bang304));
		 adapter.add(new room("y401", "유진401호", R.drawable.bang401));
		 adapter.add(new room("y402", "유진402호", R.drawable.bang402));
		 adapter.add(new room("y403", "유진403호", R.drawable.bang403));
		 adapter.add(new room("y404", "유진404호", R.drawable.bang404));
	 }

	 
	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		// TODO Auto-generated method stub
		
	}	
}
