package com.kobook.controller;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kobook.mypage.persistence.MyPageDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class MyPageTest {
	
	@Inject
	private MyPageDAO dao;
	
	/*@Test
	public void sellListTest(){
		System.out.println(dao.sellList(2).toString());
	}*/
	
/*	@Test
	public void sellStateUpdate(){
		BookVO vo = new BookVO();
		vo.setBook_sell_state("C");
		vo.setBook_id(1);
		dao.sellStateUpdate(vo);
		
		System.out.println("책 상태 변경: " + vo);
	}*/

	@Test
	public void buyList(){
		System.out.println(dao.buyList(7).toString());
	}
}