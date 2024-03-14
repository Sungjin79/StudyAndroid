package com.villmanager.model;

public class house {

	private int houseImg;
	private String houseId;
	private String houseName;
	public house(int houseImg, String houseId, String houseName) {
		super();
		this.houseImg = houseImg;
		this.houseId = houseId;
		this.houseName = houseName;
	}
	public int getHouseImg() {
		return houseImg;
	}
	public void setHouseImg(int houseImg) {
		this.houseImg = houseImg;
	}
	public String getHouseId() {
		return houseId;
	}
	public void setHouseId(String houseId) {
		this.houseId = houseId;
	}
	public String getHouseName() {
		return houseName;
	}
	public void setHouseName(String houseName) {
		this.houseName = houseName;
	}
	@Override
	public String toString() {
		return "house [houseImg=" + houseImg + ", houseId=" + houseId
				+ ", houseName=" + houseName + "]";
	}
	
	
	
}
