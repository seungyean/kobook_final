package com.kobook.controller;

import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;

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
		
		
	//	List<HashMap<String, String>> list= new HashMap(m)
	
/*		List<HashMap<String, String>> list = null;
		HashMap<String, String> map = new HashMap<>();
		//list = service.deliveryList(cri);
		
	String  now  = "2009-03-20"; // 형식을 지켜야 함
	java.sql.Date d = java.sql.Date.valueOf(now);
		
		
		DateDTO dto=new DateDTO();
		dto.setStartday(d);
		dao.selectDate(dto);*/
		
		List<HashMap<String, String>> list = null;
		HashMap<String, String> map = new HashMap<>();
		 Timestamp.valueOf("2017-11-29");
		 
		 DateDTO dto=new DateDTO();
		 dto.setStartday(Timestamp.valueOf("2017-11-29"));
		 dto.setEndday(Timestamp.valueOf("2017-11-30"));
		 
		// dao.selectDate(dto);
		 
		 System.out.println(dto.toString());
		
	}

}
