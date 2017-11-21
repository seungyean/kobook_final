package com.kobook.mypage.domain;

import java.sql.Timestamp;
import java.util.Arrays;

public class BuyListVO {
	
	private Timestamp order_date;
	private String book_name;
	private String book_m_price;
//	private String[] files;
	
	public Timestamp getOrder_date() {
		return order_date;
	}
	public void setOrder_date(Timestamp order_date) {
		this.order_date = order_date;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public String getBook_m_price() {
		return book_m_price;
	}
	public void setBook_m_price(String book_m_price) {
		this.book_m_price = book_m_price;
	}
	
	@Override
	public String toString() {
		return "BuyListVO [order_date=" + order_date + ", book_name=" + book_name + ", book_m_price=" + book_m_price
				+ "]";
	}
	
//	public String[] getFiles() {
//		return files;
//	}
//	public void setFiles(String[] files) {
//		this.files = files;
//	}
	
	
	
	
	

}
