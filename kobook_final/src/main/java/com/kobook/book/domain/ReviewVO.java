package com.kobook.book.domain;

import java.sql.Timestamp;

public class ReviewVO {
	private int review_id;
	private String review_content;
	private Timestamp review_date;
	private int review_star;
	private int pay_id;
	
	public ReviewVO(){}

	public ReviewVO(int review_id, String review_content, Timestamp review_date, int review_star, int pay_id) {
		super();
		this.review_id = review_id;
		this.review_content = review_content;
		this.review_date = review_date;
		this.review_star = review_star;
		this.pay_id = pay_id;
	}

	public int getReview_id() {
		return review_id;
	}

	public void setReview_id(int review_id) {
		this.review_id = review_id;
	}

	public String getReview_content() {
		return review_content;
	}

	public void setReview_content(String review_content) {
		this.review_content = review_content;
	}

	public Timestamp getReview_date() {
		return review_date;
	}

	public void setReview_date(Timestamp review_date) {
		this.review_date = review_date;
	}

	public int getReview_star() {
		return review_star;
	}

	public void setReview_star(int review_star) {
		this.review_star = review_star;
	}

	public int getPay_id() {
		return pay_id;
	}

	public void setPay_id(int pay_id) {
		this.pay_id = pay_id;
	};
	
	

}
