package com.kobook.mypage.domain;

import java.sql.Timestamp;

public class MileageVO {
	
	private Timestamp order_date;
	private int mileage_point;
	private char mileage_kind;
	private int pay_id;
	private int person_id;
	
	public Timestamp getOrder_date() {
		return order_date;
	}
	public void setOrder_date(Timestamp order_date) {
		this.order_date = order_date;
	}
	public int getMileage_point() {
		return mileage_point;
	}
	public void setMileage_point(int mileage_point) {
		this.mileage_point = mileage_point;
	}
	public char getMileage_kind() {
		return mileage_kind;
	}
	public void setMileage_kind(char mileage_kind) {
		this.mileage_kind = mileage_kind;
	}
	public int getPay_id() {
		return pay_id;
	}
	public void setPay_id(int pay_id) {
		this.pay_id = pay_id;
	}
	public int getPerson_id() {
		return person_id;
	}
	public void setPerson_id(int person_id) {
		this.person_id = person_id;
	}
	@Override
	public String toString() {
		return "MileageVO [order_date=" + order_date + ", mileage_point=" + mileage_point + ", mileage_kind="
				+ mileage_kind + ", pay_id=" + pay_id + ", person_id=" + person_id + "]";
	}
	
	
	

}
