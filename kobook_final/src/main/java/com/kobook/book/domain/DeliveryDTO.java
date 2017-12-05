package com.kobook.book.domain;

import java.sql.Date;

public class DeliveryDTO {
	private int delivery_id;
	private String person_name;
	private String delivery_address;
	private int pay_amount;
	private Date pay_date;
	private String book_name;
	private String delivery_state;
	private String delivery_msg;
	
	public DeliveryDTO(){}

	public DeliveryDTO(int delivery_id, String person_name, String delivery_address, int pay_amount, Date pay_date,
			String book_name, String delivery_state, String delivery_msg) {
		super();
		this.delivery_id = delivery_id;
		this.person_name = person_name;
		this.delivery_address = delivery_address;
		this.pay_amount = pay_amount;
		this.pay_date = pay_date;
		this.book_name = book_name;
		this.delivery_state = delivery_state;
		this.delivery_msg = delivery_msg;
	}


	public String getPerson_name() {
		return person_name;
	}

	public void setPerson_name(String person_name) {
		this.person_name = person_name;
	}

	public int getDelivery_id() {
		return delivery_id;
	}

	public void setDelivery_id(int delivery_id) {
		this.delivery_id = delivery_id;
	}

	public String getDelivery_address() {
		return delivery_address;
	}

	public void setDelivery_address(String delivery_address) {
		this.delivery_address = delivery_address;
	}

	public int getPay_amount() {
		return pay_amount;
	}

	public void setPay_amount(int pay_amount) {
		this.pay_amount = pay_amount;
	}

	public Date getPay_date() {
		return pay_date;
	}

	public void setPay_date(Date pay_date) {
		this.pay_date = pay_date;
	}

	public String getBook_name() {
		return book_name;
	}

	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}

	public String getDelivery_state() {
		return delivery_state;
	}

	public void setDelivery_state(String delivery_state) {
		this.delivery_state = delivery_state;
	}

	public String getDelivery_msg() {
		return delivery_msg;
	}

	public void setDelivery_msg(String delivery_msg) {
		this.delivery_msg = delivery_msg;
	}

	@Override
	public String toString() {
		return "DeliveryDTO [delivery_id=" + delivery_id + ", person_name=" + person_name + ", delivery_address="
				+ delivery_address + ", pay_amount=" + pay_amount + ", pay_date=" + pay_date + ", book_name="
				+ book_name + ", delivery_state=" + delivery_state + ", delivery_msg=" + delivery_msg + "]";
	}

	

}
