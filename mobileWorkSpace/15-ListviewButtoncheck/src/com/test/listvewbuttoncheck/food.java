package com.test.listvewbuttoncheck;

public class food {
	private String name;
	private String memo;
	private int img;
	private boolean check;
	public food(String name, String memo, int img, boolean check) {
		super();
		this.name = name;
		this.memo = memo;
		this.img = img;
		this.check = check;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public int getImg() {
		return img;
	}
	public void setImg(int img) {
		this.img = img;
	}
	public boolean isCheck() {
		return check;
	}
	public void setCheck(boolean check) {
		this.check = check;
	}
	@Override
	public String toString() {
		return "food [name=" + name + ", memo=" + memo + ", img=" + img
				+ ", check=" + check + "]";
	}
	
	
	
}
