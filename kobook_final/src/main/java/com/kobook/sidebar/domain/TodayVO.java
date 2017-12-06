package com.kobook.sidebar.domain;

import java.io.Serializable;

public class TodayVO implements Serializable {
	
	private int today_id;
	private int donate_id;
	private int book_id;
	private int person_id;
	
	public TodayVO() {}

	public TodayVO(int today_id, int donate_id, int book_id, int person_id) {
		super();
		this.today_id = today_id;
		this.donate_id = donate_id;
		this.book_id = book_id;
		this.person_id = person_id;
	}

	public int getToday_id() {
		return today_id;
	}

	public void setToday_id(int today_id) {
		this.today_id = today_id;
	}

	public int getDonate_id() {
		return donate_id;
	}

	public void setDonate_id(int donate_id) {
		this.donate_id = donate_id;
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
		return "TodayVO [today_id=" + today_id + ", donate_id=" + donate_id + ", book_id=" + book_id + ", person_id="
				+ person_id + "]";
	}
	
	
}
