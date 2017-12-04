package com.kobook.alarm.service;

import java.util.List;

import javax.inject.Inject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kobook.alarm.domain.AlarmVO;
import com.kobook.alarm.persistence.AlarmDAO;

@Service
public class AlarmServiceImpl implements AlarmService{

	@Inject
	private AlarmDAO dao;
	
	@Override
	public List<AlarmVO> alarmListService(int person_id) throws Exception {
		return dao.alarmListDAO(person_id);
	}

	@Transactional
	@Override
	public void alarmUpdateService(int person_id) throws Exception {
		dao.alarmUpdate(person_id);
	}

	@Override
	public void alarmMessage(AlarmVO alarmVO) throws Exception {
		
		dao.alarmMessage(alarmVO);
	}

	@Override
	public int alarmCount(int person_id) {
		return dao.alarmCount(person_id);
	}
	
}
