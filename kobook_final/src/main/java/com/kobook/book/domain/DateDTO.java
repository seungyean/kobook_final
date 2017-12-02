package com.kobook.book.domain;

public class DateDTO {

	private String  startday;
	private String endday;
	
	public DateDTO(){}

	public DateDTO(String startday, String endday) {
		super();
		this.startday = startday;
		this.endday = endday;
	}

	public String getStartday() {
		return startday;
	}

	public void setStartday(String startday) {
		this.startday = startday;
	}

	public String getEndday() {
		return endday;
	}

	public void setEndday(String endday) {
		this.endday = endday;
	}

	@Override
	public String toString() {
		return "DateDTO [startday=" + startday + ", endday=" + endday + "]";
	};
	
	
}
