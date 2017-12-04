package com.kobook.alarm.domain;

public class AlarmVO {

	private int alarm_id;
	private String alarm_kind;
	private String alarm_content;
	private int person_id;
	private String alarm_hit_yn;
	
	public AlarmVO(){}

	public AlarmVO(int alarm_id, String alarm_kind, String alarm_content, int person_id, String alarm_hit_yn) {
		super();
		this.alarm_id = alarm_id;
		this.alarm_kind = alarm_kind;
		this.alarm_content = alarm_content;
		this.person_id = person_id;
		this.alarm_hit_yn = alarm_hit_yn;
	}

	public int getAlarm_id() {
		return alarm_id;
	}

	public void setAlarm_id(int alarm_id) {
		this.alarm_id = alarm_id;
	}

	public String getAlarm_kind() {
		return alarm_kind;
	}

	public void setAlarm_kind(String alarm_kind) {
		this.alarm_kind = alarm_kind;
	}

	public String getAlarm_content() {
		return alarm_content;
	}

	public void setAlarm_content(String alarm_content) {
		this.alarm_content = alarm_content;
	}

	public int getPerson_id() {
		return person_id;
	}

	public void setPerson_id(int person_id) {
		this.person_id = person_id;
	}

	public String getHit_yn() {
		return alarm_hit_yn;
	}

	public void setHit_yn(String alarm_hit_yn) {
		this.alarm_hit_yn = alarm_hit_yn;
	}
	
	
}
