package com.kobook.community.domain;

import java.io.Serializable;
import java.sql.Timestamp;

public class ReplyVO implements Serializable  {
	private Integer reply_id;
	private String reply_content;
	private Timestamp reply_date;
	private int donate_id;
	private int person_id;
	private int reply_ref;
	private int reply_step;
	private int reply_level;
	private String secret_yn;
	
	public ReplyVO() {}

	public ReplyVO(Integer reply_id, String reply_content, Timestamp reply_date, int donate_id, int person_id,
			int reply_ref, int reply_step, int reply_level, String secret_yn) {
		super();
		this.reply_id = reply_id;
		this.reply_content = reply_content;
		this.reply_date = reply_date;
		this.donate_id = donate_id;
		this.person_id = person_id;
		this.reply_ref = reply_ref;
		this.reply_step = reply_step;
		this.reply_level = reply_level;
		this.secret_yn = secret_yn;
	}

	public Integer getReply_id() {
		return reply_id;
	}

	public void setReply_id(Integer reply_id) {
		this.reply_id = reply_id;
	}

	public String getReply_content() {
		return reply_content;
	}

	public void setReply_content(String reply_content) {
		this.reply_content = reply_content;
	}

	public Timestamp getReply_date() {
		return reply_date;
	}

	public void setReply_date(Timestamp reply_date) {
		this.reply_date = reply_date;
	}

	public int getDonate_id() {
		return donate_id;
	}

	public void setDonate_id(int donate_id) {
		this.donate_id = donate_id;
	}

	public int getPerson_id() {
		return person_id;
	}

	public void setPerson_id(int person_id) {
		this.person_id = person_id;
	}

	public int getReply_ref() {
		return reply_ref;
	}

	public void setReply_ref(int reply_ref) {
		this.reply_ref = reply_ref;
	}

	public int getReply_step() {
		return reply_step;
	}

	public void setReply_step(int reply_step) {
		this.reply_step = reply_step;
	}

	public int getReply_level() {
		return reply_level;
	}

	public void setReply_level(int reply_level) {
		this.reply_level = reply_level;
	}

	public String getSecret_yn() {
		return secret_yn;
	}

	public void setSecret_yn(String secret_yn) {
		this.secret_yn = secret_yn;
	}

	@Override
	public String toString() {
		return "ReplyVO [reply_id=" + reply_id + ", reply_content=" + reply_content + ", reply_date=" + reply_date
				+ ", donate_id=" + donate_id + ", person_id=" + person_id + ", reply_ref=" + reply_ref + ", reply_step="
				+ reply_step + ", reply_level=" + reply_level + ", secret_yn=" + secret_yn + "]";
	}
	
	
	
}
