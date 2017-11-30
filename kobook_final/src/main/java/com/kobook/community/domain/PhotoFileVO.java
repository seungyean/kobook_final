package com.kobook.community.domain;

public class PhotoFileVO {
	
	private String photo_file_name;
	private int photo_id;
	
	public PhotoFileVO() {}

	public PhotoFileVO(String photo_file_name, int photo_id) {
		super();
		this.photo_file_name = photo_file_name;
		this.photo_id = photo_id;
	}

	public String getPhoto_file_name() {
		return photo_file_name;
	}

	public void setPhoto_file_name(String photo_file_name) {
		this.photo_file_name = photo_file_name;
	}

	public int getPhoto_id() {
		return photo_id;
	}

	public void setPhoto_id(int photo_id) {
		this.photo_id = photo_id;
	}
	
		
}
