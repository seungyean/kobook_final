package com.kobook.book.service;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kobook.book.domain.BookVO;
import com.kobook.book.domain.DateDTO;
import com.kobook.book.domain.DeliveryDTO;
import com.kobook.book.domain.SearchCriteria;
import com.kobook.book.persistence.BookDAO;
import com.kobook.book.persistence.DeliveryDAO;

@Service
public class DelvieryServiceImpl implements DeliveryService {

	@Inject
	private DeliveryDAO dao;

	@Override
	public List<HashMap<String, String>> deliveryList(SearchCriteria cri) throws Exception {
		return dao.deliveryList(cri);
	}

	@Override
	public List<DeliveryDTO> selectDateList(DateDTO dto) throws Exception {
		return dao.selectDateList(dto);
	}

	@Override
	public int countdelList() throws Exception {
		return dao.countdelList();
	}

	@Override
	public void delstateUpdate(DeliveryDTO dto)throws Exception {
		dao.delstateUpdate(dto);
	}
	
	@Override
	public int wpercent() throws Exception {
		return dao.wpercent();
	}


	@Override
	public int ipercent() throws Exception {
		return dao.ipercent();
	}


	@Override
	public int cpercent() throws Exception {
		return dao.cpercent();
	}


	@Override
	public int month(int m) throws Exception {
		return dao.month(m);
	}


	@Override
	public int todayMoney() throws Exception {
		return dao.todayMoney();
	}
}
