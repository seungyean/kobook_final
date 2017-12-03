package com.kobook.admin.domain;


public class MonthPayVO {

	private Integer pay_id;
	private int pay_amount;
	private String pay_date;
	
	public MonthPayVO(Integer pay_id, int pay_amount, String pay_date) {
		super();
		this.pay_id = pay_id;
		this.pay_amount = pay_amount;
		this.pay_date = pay_date;
	}

	public Integer getPay_id() {
		return pay_id;
	}

	public void setPay_id(Integer pay_id) {
		this.pay_id = pay_id;
	}

	public int getPay_amount() {
		return pay_amount;
	}

	public void setPay_amount(int pay_amount) {
		this.pay_amount = pay_amount;
	}

	public String getPay_date() {
		return pay_date;
	}

	public void setPay_date(String pay_date) {
		this.pay_date = pay_date;
	}

	@Override
	public String toString() {
		return "PayVO [pay_id=" + pay_id + ", pay_amount=" + pay_amount + ", pay_date=" + pay_date + "]";
	}
	
}
