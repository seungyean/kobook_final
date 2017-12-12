package com.kobook.book.persistence;

import java.util.HashMap;
import java.util.List;

import com.kobook.book.domain.DateDTO;
import com.kobook.book.domain.DeliveryDTO;
import com.kobook.book.domain.SearchCriteria;

public interface DeliveryDAO {
	
		public List<HashMap<String, String>> deliveryList(SearchCriteria cri);
		
		public int countdelList()throws Exception;
		
		public void delstateUpdate(DeliveryDTO dto)throws Exception;
		
		public List<DeliveryDTO> selectDateList(DateDTO dto) throws Exception;

		public int wpercent() throws Exception;
		public int ipercent() throws Exception;
		public int cpercent() throws Exception;
		
		public int month(int m) throws Exception;
		
		public int todayMoney()throws Exception;
		
}
