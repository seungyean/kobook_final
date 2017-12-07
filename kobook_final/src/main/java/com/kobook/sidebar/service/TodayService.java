package com.kobook.sidebar.service;

import java.util.HashMap;
import java.util.List;

import com.kobook.sidebar.domain.TodayVO;

public interface TodayService {
	public void todayRegist(TodayVO vo) throws Exception;
	public List<HashMap<String, Object>> todayDonateViewList(int person_id) throws Exception;
	public int checkPersonIdByDonateID(int donate_id, int person_id) throws Exception;
	public int checkPersonIdByBookID(int book_id, int person_id) throws Exception;
	public List<HashMap<String, Object>> todayBookViewList(int person_id) throws Exception;
	public void todayRemove(int today_id) throws Exception;
	public void todayAllRemoveByPersonId(int person_id) throws Exception;
	public void todayAllRemoveByDonateId(int donate_id) throws Exception;
	public int todayCountByDonateId(int donate_id) throws Exception;
}
