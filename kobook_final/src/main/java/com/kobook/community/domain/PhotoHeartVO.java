package com.kobook.community.domain;

public class PhotoHeartVO {
	private int heart_id;
	private int photo_id;
	private int person_id;
	
	public PhotoHeartVO() {}

	public PhotoHeartVO(int heart_id, int photo_id, int person_id) {
		super();
		this.heart_id = heart_id;
		this.photo_id = photo_id;
		this.person_id = person_id;
	}

	public int getHeart_id() {
		return heart_id;
	}

	public void setHeart_id(int heart_id) {
		this.heart_id = heart_id;
	}

	public int getPhoto_id() {
		return photo_id;
	}

	public void setPhoto_id(int photo_id) {
		this.photo_id = photo_id;
	}

	public int getPerson_id() {
		return person_id;
	}

	public void setPerson_id(int person_id) {
		this.person_id = person_id;
	}

	@Override
	public String toString() {
		return "PhotoHeartVO [heart_id=" + heart_id + ", photo_id=" + photo_id + ", person_id=" + person_id + "]";
	}
	
}
