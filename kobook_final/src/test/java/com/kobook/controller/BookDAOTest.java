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
		
	vo.setBook_name("aa");
	vo.setBook_o_price(2000);
	vo.setBook_m_price(1000);
	vo.setBook_kind("공학계열");
	vo.setBook_edition(1);
	vo.setBook_publish("한림");
	vo.setBook_hash("#공돌이");
	vo.setBook_safe_yn("Y");
	vo.setBook_sell_state("I");
	vo.setBook_status("A");
	vo.setBook_content("연락주세요");
	vo.setPerson_id(1);
	
	dao.create(vo);
	System.out.println(vo);
	
	
	}

}
