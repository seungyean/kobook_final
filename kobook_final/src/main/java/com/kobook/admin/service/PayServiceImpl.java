package com.kobook.admin.service;

import java.util.List;

import javax.inject.Inject;


import org.springframework.stereotype.Service;

import com.kobook.admin.domain.MonthPayVO;
import com.kobook.admin.persistence.PayDAO;


@Service
public class PayServiceImpl implements PayService {

	@Inject
	private PayDAO dao;

	@Override
	public int paySum(String pay_date) throws Exception {
		if(dao.paySum(pay_date) == null) {
			return 0;
		} else {
			return dao.paySum(pay_date);
		}		
	}
	
	@Override
	public int payDaySum(String pay_date) throws Exception {
		if(dao.payDaySum(pay_date) == null){
			return 0;
		} else {
			return dao.payDaySum(pay_date);
		}
	}
}
