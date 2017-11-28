package com.kobook.mypage.domain;

import java.sql.Timestamp;

public class PayVO {
	
	private int pay_id;
	private int pay_amount;
	private Timestamp pay_date;
	private int order_id;
	public int getPay_id() {
		return pay_id;
	}
	public void setPay_id(int pay_id) {
		this.pay_id = pay_id;
	}
	public int getPay_amount() {
		return pay_amount;
	}
	public void setPay_amount(int pay_amount) {
		this.pay_amount = pay_amount;
	}
	public Timestamp getPay_date() {
		return pay_date;
	}
	public void setPay_date(Timestamp pay_date) {
		this.pay_date = pay_date;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	@Override
	public String toString() {
		return "PayVO [pay_id=" + pay_id + ", pay_amount=" + pay_amount + ", pay_date=" + pay_date + ", order_id="
				+ order_id + "]";
	}
	
	

}
