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
		System.out.println("service - list");
		List<AlarmVO> alarmList = dao.alarmListDAO(person_id);
		return alarmList;
	}

	@Transactional
	@Override
	public void alarmUpdateService(int person_id) throws Exception {
		System.out.println("service - update");
		dao.alarmUpdate(person_id);
	}
	
}
