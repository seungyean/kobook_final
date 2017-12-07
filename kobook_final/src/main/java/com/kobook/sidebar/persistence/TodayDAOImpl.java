package com.kobook.sidebar.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kobook.sidebar.domain.TodayVO;

@Repository
public class TodayDAOImpl implements TodayDAO {
	
	@Inject
	private SqlSession session;
	
	private static String namespace = "com.kobook.mappers.sidebarMapper";

	@Override
	public void todayInsert(TodayVO vo) throws Exception {
		session.insert(namespace+".todayInsert", vo);
	}

	@Override
	public List<HashMap<String, Object>> todayDonateViewList(int person_id) throws Exception {
		return session.selectList(namespace+".todayDonateViewList", person_id);
	}

	@Override
	public int checkPersonIdByDonateID(int donate_id, int person_id) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		paramMap.put("donate_id", donate_id);
		paramMap.put("person_id", person_id);
		
		return session.selectOne(namespace+".checkPersonIdByDonateID", paramMap);
	}

	@Override
	public int checkPersonIdByBookID(int book_id, int person_id) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		paramMap.put("book_id", book_id);
		paramMap.put("person_id", person_id);
		
		return session.selectOne(namespace+".checkPersonIdByBookID", paramMap);
	}

	@Override
	public List<HashMap<String, Object>> todayBookViewList(int person_id) throws Exception {
		return session.selectList(namespace+".todayBookViewList", person_id);
	}

	@Override
	public void todayDelete(int today_id) throws Exception {
		session.delete(namespace+".todayDelete", today_id);
	}

	@Override
	public void todayAllDeleteByPersonId(int person_id) throws Exception {
		session.delete(namespace+".todayAllDeleteByPersonId", person_id);
	}

	@Override
	public void todayAllDeleteByDonateId(int donate_id) throws Exception {
		session.delete(namespace+".todayAllDeleteByDonateId", donate_id);
	}

	@Override
	public int todayCountByDonateId(int donate_id) throws Exception {
		return session.selectOne(namespace+".todayCountByDonateId", donate_id);
	}

}
