package com.villmanager.model;

public class room {
	private String roomid;
	private String roomName;
	private int img;
	
	public room(String roomid, String roomName, int img) {
		super();
		this.roomid = roomid;
		this.roomName = roomName;
		this.img = img;
	}

	public String getRoomid() {
		return roomid;
	}

	public void setRoomid(String roomid) {
		this.roomid = roomid;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public int getImg() {
		return img;
	}

	public void setImg(int img) {
		this.img = img;
	}

	@Override
	public String toString() {
		return "room [roomid=" + roomid + ", roomName=" + roomName + ", img="
				+ img + "]";
	} 
	
}
