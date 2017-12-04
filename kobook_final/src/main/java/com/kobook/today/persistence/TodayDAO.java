package com.kobook.today.persistence;

import java.util.HashMap;
import java.util.List;

import com.kobook.today.domain.TodayVO;

public interface TodayDAO {
	//todayInsert
	public void todayInsert(TodayVO vo) throws Exception;
	public List<HashMap<String, Object>> todayDonateViewList(int person_id) throws Exception;
	public int checkPersonIdByDonateID(int donate_id, int person_id) throws Exception;
}
