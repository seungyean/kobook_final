package com.kobook.admin.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kobook.admin.domain.MonthPayVO;


@Repository
public class PayDAOImpl implements PayDAO{

	@Inject
	private SqlSession session;
	
	private static String namespace="com.kobook.mappers.visitMapper";
	
	
	@Override
	public Integer paySum(String pay_date)throws Exception {
		return session.selectOne(namespace+".paySum", pay_date);
	}
	
	@Override
	public Integer payDaySum(String pay_date)throws Exception {
		return session.selectOne(namespace+".payDaySum", pay_date);
	}
}
