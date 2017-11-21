package com.kobook.domain.book;

public class FileVO {

	private String fullName;
	private int bno;
	
	public FileVO(){}

	public FileVO(String fullName, int bno) {
		super();
		this.fullName = fullName;
		this.bno = bno;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}
	
	
	
}
