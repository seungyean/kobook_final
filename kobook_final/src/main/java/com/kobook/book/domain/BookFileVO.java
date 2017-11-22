package com.kobook.book.domain;

public class BookFileVO {

	private String book_file_name;
	private int book_id;
	
	public BookFileVO(){}

	public BookFileVO(String book_file_name, int book_id) {
		super();
		this.book_file_name = book_file_name;
		this.book_id = book_id;
	}

	public String getBook_file_name() {
		return book_file_name;
	}

	public void setBook_file_name(String book_file_name) {
		this.book_file_name = book_file_name;
	}

	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}

	


	
	
	
}