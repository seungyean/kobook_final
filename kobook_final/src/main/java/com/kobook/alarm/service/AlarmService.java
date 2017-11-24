package com.kobook.alarm.service;

import java.util.List;

import com.kobook.alarm.domain.AlarmVO;

public interface AlarmService {
	public List<AlarmVO> alarmListService(int person_id) throws Exception;
	public void alarmUpdateService(int person_id) throws Exception;
	public int alarmCount(int person_id);

	//알람 리스트 ROW
	public void alarmMessage(AlarmVO alarmVO) throws Exception;
}
