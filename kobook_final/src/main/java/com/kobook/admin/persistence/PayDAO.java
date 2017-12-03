package com.kobook.admin.persistence;

import java.util.List;

import com.kobook.admin.domain.MonthPayVO;

public interface PayDAO {

	public Integer paySum(String pay_date)throws Exception;
	
	public Integer payDaySum(String pay_date)throws Exception;
}
