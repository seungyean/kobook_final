package com.kobook.book.domain;

public class FileVO {

	private String file_name;
	private int book_id;
	
	public FileVO(){}

	public FileVO(String file_name, int book_id) {
		super();
		this.file_name = file_name;
		this.book_id = book_id;
	}

	public String getFile_name() {
		return file_name;
	}

	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}

	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}


	
	
	
}