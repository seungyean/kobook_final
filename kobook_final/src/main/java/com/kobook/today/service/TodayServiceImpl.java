package com.kobook.today.service;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kobook.community.domain.DonateVO;
import com.kobook.today.domain.TodayVO;
import com.kobook.today.persistence.TodayDAO;

@Service
public class TodayServiceImpl implements TodayService {
	
	@Inject
	private TodayDAO dao;

	@Override
	public void todayRegist(TodayVO vo) throws Exception {
		dao.todayInsert(vo);
	}

	@Override
	public List<HashMap<String, Object>> todayDonateViewList(int person_id) throws Exception {
		return dao.todayDonateViewList(person_id);
	}

	@Override
	public int checkPersonIdByDonateID(int donate_id, int person_id) throws Exception {
		return dao.checkPersonIdByDonateID(donate_id, person_id);
	}
}
