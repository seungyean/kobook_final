package com.kobook.book.domain;

public class PersonDTO {

	private int person_id;
	private String person_email;
	private String person_sell_grade;
	private double person_avg;
	
	public PersonDTO(){}



	public PersonDTO(int person_id, String person_email, String person_sell_grade, double person_avg) {
		super();
		this.person_id = person_id;
		this.person_email = person_email;
		this.person_sell_grade = person_sell_grade;
		this.person_avg = person_avg;
	}


	

	public int getPerson_id() {
		return person_id;
	}



	public void setPerson_id(int person_id) {
		this.person_id = person_id;
	}



	public String getPerson_email() {
		return person_email;
	}

	public void setPerson_email(String person_email) {
		this.person_email = person_email;
	}

	public String getPerson_sell_grade() {
		return person_sell_grade;
	}

	public void setPerson_sell_grade(String person_sell_grade) {
		this.person_sell_grade = person_sell_grade;
	}

	public double getPerson_avg() {
		return person_avg;
	}

	public void setPerson_avg(double person_avg) {
		this.person_avg = person_avg;
	};
	
	
	
}
