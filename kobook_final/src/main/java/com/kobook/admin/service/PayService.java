package com.kobook.admin.service;

import java.util.List;

import com.kobook.admin.domain.MonthPayVO;

public interface PayService {
	
	public int paySum(String pay_date)throws Exception;
	
	public int payDaySum(String pay_date)throws Exception;
}
