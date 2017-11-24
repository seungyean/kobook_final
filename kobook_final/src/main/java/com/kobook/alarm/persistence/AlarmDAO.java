package com.kobook.alarm.persistence;

import java.util.List;

import com.kobook.alarm.domain.AlarmVO;

public interface AlarmDAO {
	public List<AlarmVO> alarmListDAO(int person_id);
	public void alarmUpdate(int person_id);
	public int alarmCount(int person_id);
	
	//알람 리스트 ROW 내용
	public void alarmMessage(AlarmVO alarmVO);
}
