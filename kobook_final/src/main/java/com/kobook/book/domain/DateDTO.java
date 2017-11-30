package com.kobook.book.domain;

import java.sql.Timestamp;

public class DateDTO {

	private Timestamp  startday;
	private Timestamp endday;
	
	public DateDTO(){}

	public DateDTO(Timestamp startday, Timestamp endday) {
		super();
		this.startday = startday;
		this.endday = endday;
	}

	public Timestamp getStartday() {
		return startday;
	}

	public void setStartday(Timestamp startday) {
		this.startday = startday;
	}

	public Timestamp getEndday() {
		return endday;
	}

	public void setEndday(Timestamp endday) {
		this.endday = endday;
	}

	@Override
	public String toString() {
		return "DateDTO [startday=" + startday + ", endday=" + endday + "]";
	};
	
	
}
