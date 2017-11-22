package com.kobook.book.domain;


import java.util.Arrays;
import java.util.Date;

public class BookVO {
	private Integer book_id;
	private String book_name;
	private int book_o_price;
	private int book_m_price;
	private String book_kind;
	private int book_edition;
	private String book_publish;
	private String book_hash;
	private String book_safe_yn;
	private String book_sell_state;
	private String book_content;
	private Date book_date;
	private String book_status;
	private String book_img;
	private int person_id;

	public BookVO(){}

	public BookVO(Integer book_id, String book_name, int book_o_price, int book_m_price, String book_kind,
			int book_edition, String book_publish, String book_hash, String book_safe_yn, String book_sell_state,
			String book_content, Date book_date, String book_status, String book_img, int person_id) {
		super();
		this.book_id = book_id;
		this.book_name = book_name;
		this.book_o_price = book_o_price;
		this.book_m_price = book_m_price;
		this.book_kind = book_kind;
		this.book_edition = book_edition;
		this.book_publish = book_publish;
		this.book_hash = book_hash;
		this.book_safe_yn = book_safe_yn;
		this.book_sell_state = book_sell_state;
		this.book_content = book_content;
		this.book_date = book_date;
		this.book_status = book_status;
		this.book_img = book_img;
		this.person_id = person_id;
	}

	public Integer getBook_id() {
		return book_id;
	}

	public void setBook_id(Integer book_id) {
		this.book_id = book_id;
	}

	public String getBook_name() {
		return book_name;
	}

	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}

	public int getBook_o_price() {
		return book_o_price;
	}

	public void setBook_o_price(int book_o_price) {
		this.book_o_price = book_o_price;
	}

	public int getBook_m_price() {
		return book_m_price;
	}

	public void setBook_m_price(int book_m_price) {
		this.book_m_price = book_m_price;
	}

	public String getBook_kind() {
		return book_kind;
	}

	public void setBook_kind(String book_kind) {
		this.book_kind = book_kind;
	}

	public int getBook_edition() {
		return book_edition;
	}

	public void setBook_edition(int book_edition) {
		this.book_edition = book_edition;
	}

	public String getBook_publish() {
		return book_publish;
	}

	public void setBook_publish(String book_publish) {
		this.book_publish = book_publish;
	}

	public String getBook_hash() {
		return book_hash;
	}

	public void setBook_hash(String book_hash) {
		this.book_hash = book_hash;
	}

	public String getBook_safe_yn() {
		return book_safe_yn;
	}

	public void setBook_safe_yn(String book_safe_yn) {
		this.book_safe_yn = book_safe_yn;
	}

	public String getBook_sell_state() {
		return book_sell_state;
	}

	public void setBook_sell_state(String book_sell_state) {
		this.book_sell_state = book_sell_state;
	}

	public String getBook_content() {
		return book_content;
	}

	public void setBook_content(String book_content) {
		this.book_content = book_content;
	}

	public Date getBook_date() {
		return book_date;
	}

	public void setBook_date(Date book_date) {
		this.book_date = book_date;
	}

	public String getBook_status() {
		return book_status;
	}

	public void setBook_status(String book_status) {
		this.book_status = book_status;
	}

	public String getBook_img() {
		return book_img;
	}

	public void setBook_img(String book_img) {
		this.book_img = book_img;
	}

	public int getPerson_id() {
		return person_id;
	}

	public void setPerson_id(int person_id) {
		this.person_id = person_id;
	}

	@Override
	public String toString() {
		return "BookVO [book_id=" + book_id + ", book_name=" + book_name + ", book_o_price=" + book_o_price
				+ ", book_m_price=" + book_m_price + ", book_kind=" + book_kind + ", book_edition=" + book_edition
				+ ", book_publish=" + book_publish + ", book_hash=" + book_hash + ", book_safe_yn=" + book_safe_yn
				+ ", book_sell_state=" + book_sell_state + ", book_content=" + book_content + ", book_date=" + book_date
				+ ", book_status=" + book_status + ", book_img=" + book_img + ", person_id=" + person_id + "]";
	}

	

}