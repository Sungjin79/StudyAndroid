package com.test.listvew;

public class food {
	private String name;
	private String memo;
	private int img;
	
	public food(String name, String memo, int img) {
		super();
		this.name = name;
		this.memo = memo;
		this.img = img;
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

	@Override
	public String toString() {
		return "food [name=" + name + ", memo=" + memo + ", img=" + img + "]";
	}

	
	
	
}
