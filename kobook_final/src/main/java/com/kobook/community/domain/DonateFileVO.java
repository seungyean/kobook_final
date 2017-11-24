package com.kobook.community.domain;

public class DonateFileVO {

	private String donate_file_name;
	private int donate_id;
	
	public DonateFileVO() {}

	public DonateFileVO(String donate_file_name, int donate_id) {
		super();
		this.donate_file_name = donate_file_name;
		this.donate_id = donate_id;
	}

	public String getDonate_file_name() {
		return donate_file_name;
	}

	public void setDonate_file_name(String donate_file_name) {
		this.donate_file_name = donate_file_name;
	}

	public int getDonate_id() {
		return donate_id;
	}

	public void setDonate_id(int donate_id) {
		this.donate_id = donate_id;
	}
	
	
	
}
