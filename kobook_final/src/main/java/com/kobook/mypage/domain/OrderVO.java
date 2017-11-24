package com.kobook.mypage.domain;

import java.sql.Timestamp;

public class OrderVO {
	
	private int order_id;
	private Timestamp order_date;
	private int book_id;
	private int person_id;
	
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public Timestamp getOrder_date() {
		return order_date;
	}
	public void setOrder_date(Timestamp order_date) {
		this.order_date = order_date;
	}
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public int getPerson_id() {
		return person_id;
	}
	public void setPerson_id(int person_id) {
		this.person_id = person_id;
	}
	@Override
	public String toString() {
		return "OrderSuccess [order_id=" + order_id + ", order_date=" + order_date + ", book_id=" + book_id
				+ ", person_id=" + person_id + "]";
	}
	
	
	
	
}
