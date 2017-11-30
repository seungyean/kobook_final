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
		System.out.println("dao - list");
		return session.selectList(namespace + ".alarmList", person_id);
	}

	@Override
	public void alarmUpdate(int person_id) {
		session.update(namespace + ".alarmUpdate", person_id);
		System.out.println("dao - update");
	}
	
	@Override
	public void alarmUpdateByMessage(int person_id) {
		session.update(namespace + ".alarmUpdateByMessage", person_id);	
	}

	@Override
	public void alarmMessage(AlarmVO alarmVO) {
		System.out.println("dao - alarmMsg");
		session.insert(namespace + ".alarmMessage", alarmVO);
	}

	@Override
	public int alarmCount(int person_id) {
		System.out.println("dao - alarmCount");
		int a = session.selectOne(namespace + ".alarmCount", person_id);
		System.out.println("dao a : "+a);
		System.out.println(person_id);
		return a;
	}

}
