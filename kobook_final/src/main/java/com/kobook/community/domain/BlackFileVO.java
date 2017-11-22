package com.kobook.community.domain;

public class BlackFileVO {

	private String black_file_name;
	private int black_id;
	
	public BlackFileVO() {}

	public BlackFileVO(String black_file_name, int black_id) {
		super();
		this.black_file_name = black_file_name;
		this.black_id = black_id;
	}

	public String getBlack_file_name() {
		return black_file_name;
	}

	public void setBlack_file_name(String black_file_name) {
		this.black_file_name = black_file_name;
	}

	public int getBlack_id() {
		return black_id;
	}

	public void setBlack_id(int black_id) {
		this.black_id = black_id;
	}
	
}
