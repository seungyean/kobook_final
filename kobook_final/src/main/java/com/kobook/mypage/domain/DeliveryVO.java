package com.kobook.mypage.domain;

public class DeliveryVO {
	
	private int delivery_id;
	private int order_id;
	private char delivery_state;
	private String delivery_msg;
	private String delivery_address;
	public int getDelivery_id() {
		return delivery_id;
	}
	public void setDelivery_id(int delivery_id) {
		this.delivery_id = delivery_id;
	}
	
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public char getDelivery_state() {
		return delivery_state;
	}
	public void setDelivery_state(char delivery_state) {
		this.delivery_state = delivery_state;
	}
	public String getDelivery_msg() {
		return delivery_msg;
	}
	public void setDelivery_msg(String delivery_msg) {
		this.delivery_msg = delivery_msg;
	}
	public String getDelivery_address() {
		return delivery_address;
	}
	public void setDelivery_address(String delivery_address) {
		this.delivery_address = delivery_address;
	}
	@Override
	public String toString() {
		return "DeliveryVO [delivery_id=" + delivery_id + ", order_id=" + order_id + ", delivery_state="
				+ delivery_state + ", delivery_msg=" + delivery_msg + ", delivery_address=" + delivery_address + "]";
	}
	

	
	
}
