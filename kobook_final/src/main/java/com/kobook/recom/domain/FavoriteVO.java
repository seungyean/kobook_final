package com.kobook.recom.domain;


//메인에 추천도서 출력하기 위한 VO객체.
public class FavoriteVO {

	private int favorite_id;
	private String favorite_name;
	private int person_id;
	private String favorite_major;
	private int book_id;
	private double favorite_rank;
	
	public FavoriteVO(){}

	public FavoriteVO(int favorite_id, String favorite_name, int person_id, String favorite_major, int book_id,
			double favorite_rank) {
		super();
		this.favorite_id = favorite_id;
		this.favorite_name = favorite_name;
		this.person_id = person_id;
		this.favorite_major = favorite_major;
		this.book_id = book_id;
		this.favorite_rank = favorite_rank;
	}

	public int getFavorite_id() {
		return favorite_id;
	}

	public void setFavorite_id(int favorite_id) {
		this.favorite_id = favorite_id;
	}

	public String getFavorite_name() {
		return favorite_name;
	}

	public void setFavorite_name(String favorite_name) {
		this.favorite_name = favorite_name;
	}

	public int getPerson_id() {
		return person_id;
	}

	public void setPerson_id(int person_id) {
		this.person_id = person_id;
	}

	public String getFavorite_major() {
		return favorite_major;
	}

	public void setFavorite_major(String favorite_major) {
		this.favorite_major = favorite_major;
	}

	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}

	public double getFavorite_rank() {
		return favorite_rank;
	}

	public void setFavorite_rank(double favorite_rank) {
		this.favorite_rank = favorite_rank;
	}
	
	
}
