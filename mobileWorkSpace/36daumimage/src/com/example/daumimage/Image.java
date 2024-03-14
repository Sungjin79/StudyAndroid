package com.example.daumimage;

public class Image {

	public static int  totalcount;
	public static int  pagecount;
	public static int  result;
	
	private String title;
	private String link;
	private String thumbnail;
	private int width;
	private int height;
	public Image(String title, String link, String thumbnail, int width,
			int height) {
		super();
		this.title = title;
		this.link = link;
		this.thumbnail = thumbnail;
		this.width = width;
		this.height = height;
	}
	public static int getTotalcount() {
		return totalcount;
	}
	public static void setTotalcount(int totalcount) {
		Image.totalcount = totalcount;
	}
	public static int getPagecount() {
		return pagecount;
	}
	public static void setPagecount(int pagecount) {
		Image.pagecount = pagecount;
	}
	public static int getResult() {
		return result;
	}
	public static void setResult(int result) {
		Image.result = result;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	
	
	
}
