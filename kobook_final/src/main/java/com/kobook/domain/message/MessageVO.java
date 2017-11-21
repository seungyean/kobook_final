package com.kobook.domain.message;

import java.sql.Timestamp;

public class MessageVO {

	private Integer message_id;
	private Timestamp message_date;
	private String message_content;
	private int person_id;
	private int message_hit;
	private int receiver_id;
	
	public Integer getMessage_id() {
		return message_id;
	}
	public void setMessage_id(Integer message_id) {
		this.message_id = message_id;
	}
	public Timestamp getMessage_date() {
		return message_date;
	}
	public void setMessage_date(Timestamp message_date) {
		this.message_date = message_date;
	}
	public String getMessage_content() {
		return message_content;
	}
	public void setMessage_content(String message_content) {
		this.message_content = message_content;
	}
	public int getPerson_id() {
		return person_id;
	}
	public void setPerson_id(int person_id) {
		this.person_id = person_id;
	}
	public int getMessage_hit() {
		return message_hit;
	}
	public void setMessage_hit(int message_hit) {
		this.message_hit = message_hit;
	}
	public int getReceiver_id() {
		return receiver_id;
	}
	public void setReceiver_id(int receiver_id) {
		this.receiver_id = receiver_id;
	}
	
	@Override
	public String toString() {
		return "MessageVO [message_id=" + message_id + ", message_date=" + message_date + ", message_content="
				+ message_content + ", person_id=" + person_id + ", message_hit=" + message_hit + ", receiver_id="
				+ receiver_id + "]";
	}
	
}
