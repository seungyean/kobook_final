package com.kobook.admin.domain;

import java.sql.Timestamp;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class VisitVO  {

	private Integer visit_id;
	private Timestamp visit_date;
	
	public VisitVO(Integer visit_id, Timestamp visit_date) {
		super();
		this.visit_id = visit_id;
		this.visit_date = visit_date;
	}

	public Integer getVisit_id() {
		return visit_id;
	}

	public void setVisit_id(Integer visit_id) {
		this.visit_id = visit_id;
	}

	public Timestamp getVisit_date() {
		return visit_date;
	}

	public void setVisit_date(Timestamp visit_date) {
		this.visit_date = visit_date;
	}

	@Override
	public String toString() {
		return "VisitVO [visit_id=" + visit_id + ", visit_date=" + visit_date + "]";
	}
	
}
