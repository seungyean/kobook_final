package com.kobook.controller;

import java.text.SimpleDateFormat;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kobook.mypage.domain.OrderVO;
import com.kobook.mypage.domain.PayVO;
import com.kobook.mypage.persistence.MyPageDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class MyPageTest {
	
	@Inject
	private MyPageDAO dao;
	
/*	@Test
	public void sellListTest(){
		System.out.println("판매내역: " + dao.sellList(2).toString());
	}*/
	
/*	@Test
	public void sellStateUpdate(){
		BookVO vo = new BookVO();
		vo.setBook_sell_state("C");
		vo.setBook_id(1);
		dao.sellStateUpdate(vo);
		
		System.out.println("책 상태 변경: " + vo);
	}*/

	/*@Test
	public void buyList(){
		System.out.println("구매내역 : " + dao.buyList(7).toString());
	}*/
	
	/*@Test
	public void buyList(){
		System.out.println("찜리스트 : " + dao.pickList(7).toString());
	}*/
	
	/*@Test
	public void mileageList(){
		System.out.println("마일리지 내역 : " + dao.mileageList(7).toString());
	}
	*/
	/*@Test
	public void orderList(){
		System.out.println("주문내역 : " + dao.orderList(7).toString());
	}
	*/
//	@Test
//	public void Test(){
////		System.out.println("주문자 정보: " + dao.orderPerson(7));
////		System.out.println("주문자 정보: " + dao.orderList(7));
//	}
	
	
//	 주문 인서트
	@Test
	public void Test(){
		dao.receivedMsgTotal(7);
		System.out.println(dao.receivedMsgTotal(7));
	}
}
