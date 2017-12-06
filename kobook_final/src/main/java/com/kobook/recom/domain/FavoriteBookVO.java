package com.kobook.recom.domain;

public class FavoriteBookVO {

	private String book_name;
	private int book_id;
	private String favorite_name;
	private int person_id;
	private String favorite_major;
	private double favorite_rank;
	private String book_img;
	
	public FavoriteBookVO(){}

	public FavoriteBookVO(String book_name, int book_id, String favorite_name, int person_id, String favorite_major,
			double favorite_rank, String book_img) {
		super();
		this.book_name = book_name;
		this.book_id = book_id;
		this.favorite_name = favorite_name;
		this.person_id = person_id;
		this.favorite_major = favorite_major;
		this.favorite_rank = favorite_rank;
		this.book_img = book_img;
	}

	public String getBook_name() {
		return book_name;
	}

	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}

	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
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

	public double getFavorite_rank() {
		return favorite_rank;
	}

	public void setFavorite_rank(double favorite_rank) {
		this.favorite_rank = favorite_rank;
	}

	public String getBook_img() {
		return book_img;
	}

	public void setBook_img(String book_img) {
		this.book_img = book_img;
	}
	
}
