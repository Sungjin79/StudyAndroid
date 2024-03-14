package com.example.imagelist;

import android.content.Context;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

public class Imghelper {

//	-----------싱글톤 객체 생성 시작----------------
	private  static Imghelper current =null;
	
	public static Imghelper getInstance(){
		if(current==null){
			current=new Imghelper();
		}	
	return current;
	}
	
	public static void  freeInstance(){
		current=null;
	}
	private Imghelper(){
		super();
	}
//	-----------싱글톤 객체 생성 끝----------------
	
	
	public DisplayImageOptions getDisplayImageOptions(Context context){
		
	ImageLoader imageLoader = ImageLoader.getInstance();
		if(!imageLoader.isInited()){
			ImageLoaderConfiguration config = ImageLoaderConfiguration.createDefault(context);
			imageLoader.init(config);
		}
		//이미지 표시 옵션 설정(현재  프로젝트에  대한 R 클래스 import)
		
		DisplayImageOptions options = new DisplayImageOptions.Builder()
		    .showImageOnLoading(R.drawable.ic_stub)
		    .showImageForEmptyUri(R.drawable.ic_empty)
		    .showImageOnFail(R.drawable.ic_error)
		    .cacheInMemory(true).cacheOnDisk(true)
		    .considerExifParams(true)
		    .build();
		return options;
	}
	
}
