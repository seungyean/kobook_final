package com.kobook.sidebar.persistence;

import java.util.HashMap;
import java.util.List;

import com.kobook.sidebar.domain.TodayVO;

public interface TodayDAO {
	//todayInsert
	public void todayInsert(TodayVO vo) throws Exception;
	//todayDonateViewList
	public List<HashMap<String, Object>> todayDonateViewList(int person_id) throws Exception;
	//checkPersonIdByDonateID
	public int checkPersonIdByDonateID(int donate_id, int person_id) throws Exception;
	//checkPersonIdByBookID
	public int checkPersonIdByBookID(int book_id, int person_id) throws Exception;
	//todayBookViewList
	public List<HashMap<String, Object>> todayBookViewList(int person_id) throws Exception;
	//todayDelete
	public void todayDelete(int today_id) throws Exception;
	//todayAllDeleteByPersonId
	public void todayAllDeleteByPersonId(int person_id) throws Exception;
	//todayAllDeleteByDonateId
	public void todayAllDeleteByDonateId(int donate_id) throws Exception;
	//todayCountByDonateId
	public int todayCountByDonateId(int donate_id) throws Exception;
}
