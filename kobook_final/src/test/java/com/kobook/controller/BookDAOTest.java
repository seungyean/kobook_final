package com.kobook.controller;

import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kobook.book.domain.BookVO;
import com.kobook.book.domain.DateDTO;
import com.kobook.book.domain.PersonDTO;
import com.kobook.book.domain.SearchCriteria;
import com.kobook.book.persistence.BookDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class BookDAOTest {

	@Inject
	private BookDAO dao;
	
	@Test
	public void test() throws Exception {
		
		//System.out.println(dao.rankingList());
		
	/*	SearchCriteria cri=new SearchCriteria();
		cri.setKeyword("aaa");
		dao.registerkeyword(cri);
		System.out.println(cri.getKeyword());
	*/
		

		//날짜관련 selectList 테스트
		//List<Map<String, String>>list=null;
		//HashMap<String, String>map=new HashMap<>();
		DateDTO dto=new DateDTO();
		dto.setStartday("20171201");
		dto.setEndday("20171202");
		dao.selectDateList(dto);
		System.out.println(dao.selectDateList(dto).toString());	
	}
	
	
	

	

}
