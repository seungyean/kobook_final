package com.kobook.controller;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kobook.domain.book.BookVO;
import com.kobook.persistence.book.BookDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class BookDAOTest {

	@Inject
	private BookDAO dao;
	
	@Test
	public void test() throws Exception {
		BookVO vo=new BookVO();
		
	vo.setBookName("aa");
	vo.setBookOPrice(2000);
	vo.setBookMPrice(1000);
	vo.setBookKind("공학계열");
	vo.setBookEdition(1);
	vo.setBookPublish("한림");
	vo.setBookHash("#공돌이");
	vo.setBookSafeYn("Y");
	vo.setBookSellState("I");
	vo.setBookStatus("A");
	vo.setBookContent("연락주세요");
	vo.setPersonId(1);
	
	dao.create(vo);
	System.out.println(vo);
	
	
	}

}
