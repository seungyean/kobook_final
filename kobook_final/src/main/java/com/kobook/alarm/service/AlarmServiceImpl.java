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
		List<AlarmVO> alarmList = dao.alarmListDAO(person_id);
		System.out.println("service - list");
		return alarmList;
	}

	@Transactional
	@Override
	public void alarmUpdateService(AlarmVO alarmVO) throws Exception {
		System.out.println("service - update");
		dao.alarmUpdate(alarmVO);
	}
	
}
