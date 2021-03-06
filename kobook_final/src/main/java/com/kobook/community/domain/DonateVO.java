package com.kobook.community.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Arrays;

import org.hibernate.validator.constraints.NotEmpty;

public class DonateVO implements Serializable {
	private int rn;
	private int donate_id;
	@NotEmpty(message="제목을 입력하셔야 합니다.")
	private String donate_title;
	private Timestamp donate_date;
	private int donate_hit;
	@NotEmpty(message="내용을 입력하셔야 합니다.")
	private String donate_content;
	private int person_id;
	private String donate_thumbnail;
	private int reply_count;
	
	private String[] files;

	public DonateVO() {}

	public DonateVO(int rn,int donate_id, String donate_title, Timestamp donate_date, int donate_hit, String donate_content,
			int person_id, String donate_thumbnail, int reply_count, String[] files) {
		super();
		this.rn = rn;
		this.donate_id = donate_id;
		this.donate_title = donate_title;
		this.donate_date = donate_date;
		this.donate_hit = donate_hit;
		this.donate_content = donate_content;
		this.person_id = person_id;
		this.donate_thumbnail = donate_thumbnail;
		this.reply_count = reply_count;
		this.files = files;
	}

	public int getDonate_id() {
		return donate_id;
	}

	public void setDonate_id(int donate_id) {
		this.donate_id = donate_id;
	}

	public String getDonate_title() {
		return donate_title;
	}

	public void setDonate_title(String donate_title) {
		this.donate_title = donate_title;
	}

	public Timestamp getDonate_date() {
		return donate_date;
	}

	public void setDonate_date(Timestamp donate_date) {
		this.donate_date = donate_date;
	}

	public int getDonate_hit() {
		return donate_hit;
	}

	public void setDonate_hit(int donate_hit) {
		this.donate_hit = donate_hit;
	}

	public String getDonate_content() {
		return donate_content;
	}

	public void setDonate_content(String donate_content) {
		this.donate_content = donate_content;
	}

	public int getPerson_id() {
		return person_id;
	}

	public void setPerson_id(int person_id) {
		this.person_id = person_id;
	}

	public String getDonate_thumbnail() {
		return donate_thumbnail;
	}

	public void setDonate_thumbnail(String donate_thumbnail) {
		this.donate_thumbnail = donate_thumbnail;
	}

	public int getReply_count() {
		return reply_count;
	}

	public void setReply_count(int reply_count) {
		this.reply_count = reply_count;
	}

	public String[] getFiles() {
		return files;
	}

	public void setFiles(String[] files) {
		this.files = files;
	}

	public int getRn() {
		return rn;
	}

	public void setRn(int rn) {
		this.rn = rn;
	}

	@Override
	public String toString() {
		return "DonateVO [rn= "+rn+", donate_id= " + donate_id + ", donate_title=" + donate_title + ", donate_date=" + donate_date
				+ ", donate_hit=" + donate_hit + ", donate_content=" + donate_content + ", person_id=" + person_id
				+ ", donate_thumbnail=" + donate_thumbnail + ", reply_count=" + reply_count + ", files="
				+ Arrays.toString(files) + "]";
	}

	
	
}
