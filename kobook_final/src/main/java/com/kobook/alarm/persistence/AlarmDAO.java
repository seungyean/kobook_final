package com.kobook.alarm.persistence;

import java.util.List;

import com.kobook.alarm.domain.AlarmVO;

public interface AlarmDAO {
	public List<AlarmVO> alarmListDAO(int person_id);
	public void alarmUpdate(AlarmVO alarmVO);
}
