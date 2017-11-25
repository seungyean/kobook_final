package com.kobook.chatbot.domain;

import java.sql.Timestamp;

public class ChatlogVO {
	
	private Integer chatlog_id;
	private int person_id;
	private String chatlog_content;
	private Timestamp chatlog_date;
	private String chatlog_speaker;
	
	
	public Integer getChatlog_id() {
		return chatlog_id;
	}
	public void setChatlog_id(Integer chatlog_id) {
		this.chatlog_id = chatlog_id;
	}
	public int getPerson_id() {
		return person_id;
	}
	public void setPerson_id(int person_id) {
		this.person_id = person_id;
	}
	public String getChatlog_content() {
		return chatlog_content;
	}
	public void setChatlog_content(String chatlog_content) {
		this.chatlog_content = chatlog_content;
	}
	public Timestamp getChatlog_date() {
		return chatlog_date;
	}
	public void setChatlog_date(Timestamp chatlog_date) {
		this.chatlog_date = chatlog_date;
	}
	public String getChatlog_speaker() {
		return chatlog_speaker;
	}
	public void setChatlog_speaker(String chatlog_speaker) {
		this.chatlog_speaker = chatlog_speaker;
	}
	
	@Override
	public String toString() {
		return "ChatlogVO [chatlog_id=" + chatlog_id + ", person_id=" + person_id + ", chatlog_content="
				+ chatlog_content + ", chatlog_date=" + chatlog_date + ", chatlog_speaker=" + chatlog_speaker + "]";
	}
	
}
