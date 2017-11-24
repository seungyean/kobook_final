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

	@Override
	public void alarmMessage(AlarmVO alarmVO) throws Exception {
		System.out.println("service - alarmMsg");
		dao.alarmMessage(alarmVO);
	}

	@Override
	public int alarmCount(int person_id) {
		System.out.println("service - alarmCount");
		int b = dao.alarmCount(person_id);
		return b;
	}
	
}
