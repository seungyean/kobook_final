package com.kobook.today.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kobook.today.domain.TodayVO;

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
}
