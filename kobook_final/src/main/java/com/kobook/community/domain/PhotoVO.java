package com.kobook.community.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Arrays;

import org.hibernate.validator.constraints.NotEmpty;

public class PhotoVO implements Serializable {
	private int photo_id;
	
	@NotEmpty(message="제목을 입력하셔야 합니다.")
	private String photo_title;
	private Timestamp photo_date;
	private int photo_hit;
	
	@NotEmpty(message="내용을 입력하셔야 합니다.")
	private String photo_content;
	private int photo_heart;
	private String photo_thumbnail;
	private int person_id;
	
	private String[] files;
	
	public PhotoVO() {}

	public PhotoVO(int photo_id, String photo_title, Timestamp photo_date, int photo_hit, String photo_content,
			int photo_heart, String photo_thumbnail, int person_id, String[] files) {
		this.photo_id = photo_id;
		this.photo_title = photo_title;
		this.photo_date = photo_date;
		this.photo_hit = photo_hit;
		this.photo_content = photo_content;
		this.photo_heart = photo_heart;
		this.photo_thumbnail = photo_thumbnail;
		this.person_id = person_id;
		this.files = files;
	}

	public int getPhoto_id() {
		return photo_id;
	}

	public void setPhoto_id(int photo_id) {
		this.photo_id = photo_id;
	}

	public String getPhoto_title() {
		return photo_title;
	}

	public void setPhoto_title(String photo_title) {
		this.photo_title = photo_title;
	}

	public Timestamp getPhoto_date() {
		return photo_date;
	}

	public void setPhoto_date(Timestamp photo_date) {
		this.photo_date = photo_date;
	}

	public int getPhoto_hit() {
		return photo_hit;
	}

	public void setPhoto_hit(int photo_hit) {
		this.photo_hit = photo_hit;
	}

	public String getPhoto_content() {
		return photo_content;
	}

	public void setPhoto_content(String photo_content) {
		this.photo_content = photo_content;
	}

	public int getPhoto_heart() {
		return photo_heart;
	}

	public void setPhoto_heart(int photo_heart) {
		this.photo_heart = photo_heart;
	}

	public String getPhoto_thumbnail() {
		return photo_thumbnail;
	}

	public void setPhoto_thumbnail(String photo_thumbnail) {
		this.photo_thumbnail = photo_thumbnail;
	}

	public int getPerson_id() {
		return person_id;
	}

	public void setPerson_id(int person_id) {
		this.person_id = person_id;
	}

	public String[] getFiles() {
		return files;
	}

	public void setFiles(String[] files) {
		this.files = files;
	}

	@Override
	public String toString() {
		return "PhotoVO [photo_id=" + photo_id + ", photo_title=" + photo_title + ", photo_date=" + photo_date
				+ ", photo_hit=" + photo_hit + ", photo_content=" + photo_content + ", photo_heart=" + photo_heart
				+ ", photo_thumbnail=" + photo_thumbnail + ", person_id=" + person_id + ", files="
				+ Arrays.toString(files) + "]";
	}
	
	

}
