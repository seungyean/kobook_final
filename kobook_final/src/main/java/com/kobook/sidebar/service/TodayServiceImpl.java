package com.kobook.sidebar.service;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kobook.sidebar.domain.TodayVO;
import com.kobook.sidebar.persistence.TodayDAO;

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

	@Override
	public int checkPersonIdByBookID(int book_id, int person_id) throws Exception {
		return dao.checkPersonIdByBookID(book_id, person_id);
	}

	@Override
	public List<HashMap<String, Object>> todayBookViewList(int person_id) throws Exception {
		return dao.todayBookViewList(person_id);
	}

	@Override
	public void todayRemove(int today_id) throws Exception {
		dao.todayDelete(today_id);
	}

	@Override
	public void todayAllRemoveByPersonId(int person_id) throws Exception {
		dao.todayAllDeleteByPersonId(person_id);
	}

	@Override
	public void todayAllRemoveByDonateId(int donate_id) throws Exception {
		dao.todayAllDeleteByDonateId(donate_id);
	}

	@Override
	public int todayCountByDonateId(int donate_id) throws Exception {
		return dao.todayCountByDonateId(donate_id);
	}

	@Override
	public int bookTotalCount() throws Exception {
		return dao.bookTotalCount();
	}

	@Override
	public int bookDirectCount() throws Exception {
		return dao.bookDirectCount();
	}

	@Override
	public int bookSafeCount() throws Exception {
		return dao.bookSafeCount();
	}

	@Override
	public int donateTotalCount() throws Exception {
		return dao.donateTotalCount();
	}
	
}
