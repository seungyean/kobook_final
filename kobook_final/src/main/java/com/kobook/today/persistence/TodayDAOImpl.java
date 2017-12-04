package com.kobook.today.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kobook.today.domain.TodayVO;

@Repository
public class TodayDAOImpl implements TodayDAO {
	
	@Inject
	private SqlSession session;
	
	private static String namespace = "com.kobook.mappers.todayMapper";

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

}
