package com.kobook.mypage.domain;

import java.sql.Timestamp;
import java.util.Arrays;

public class BuyListVO {
	
	private String book_img;
	private String book_name;
	private String pay_amount;
	private Timestamp order_date;
	public String getBook_img() {
		return book_img;
	}
	public void setBook_img(String book_img) {
		this.book_img = book_img;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public String getPay_amount() {
		return pay_amount;
	}
	public void setPay_amount(String pay_amount) {
		this.pay_amount = pay_amount;
	}
	public Timestamp getOrder_date() {
		return order_date;
	}
	public void setOrder_date(Timestamp order_date) {
		this.order_date = order_date;
	}
	@Override
	public String toString() {
		return "BuyListVO [book_img=" + book_img + ", book_name=" + book_name + ", pay_amount=" + pay_amount
				+ ", order_date=" + order_date + "]";
	}
	
	
	

	
	
	
	

}
