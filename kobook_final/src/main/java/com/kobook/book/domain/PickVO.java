package com.kobook.book.domain;

public class PickVO {

	private int pick_id;
	private int person_id;
	private int book_id;
	private String pick_state;
	
	public PickVO(){}

	

	public PickVO(int pick_id, int person_id, int book_id, String pick_state) {
		super();
		this.pick_id = pick_id;
		this.person_id = person_id;
		this.book_id = book_id;
		this.pick_state = pick_state;
	}



	public String getPick_state() {
		return pick_state;
	}



	public void setPick_state(String pick_state) {
		this.pick_state = pick_state;
	}



	public int getPick_id() {
		return pick_id;
	}

	public void setPick_id(int pick_id) {
		this.pick_id = pick_id;
	}

	public int getPerson_id() {
		return person_id;
	}

	public void setPerson_id(int person_id) {
		this.person_id = person_id;
	}

	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	};
	
	
}
