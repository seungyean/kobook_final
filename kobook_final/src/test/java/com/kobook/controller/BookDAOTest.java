package com.kobook.controller;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kobook.book.domain.BookVO;
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
		
		SearchCriteria cri=new SearchCriteria();
		cri.setKeyword("aaa");
	//	dao.registerkeyword(cri.getKeyword());
	
	
	}

}
