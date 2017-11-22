package com.kobook.alarm.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kobook.alarm.domain.AlarmVO;

@Repository
public class AlarmDAOImpl implements AlarmDAO {

	@Inject
	private SqlSession session;
	
	private static String namespace = "com.kobook.mappers.alarmMapper";
	
	@Override
	public List<AlarmVO> alarmListDAO(int person_id) {
		return session.selectList(namespace + ".alarmList");
	}

	@Override
	public void alarmUpdate(AlarmVO alarmVO) {
		session.update(namespace + ".alarmUpdate", alarmVO);
		System.out.println("dao - update");
	}

}
