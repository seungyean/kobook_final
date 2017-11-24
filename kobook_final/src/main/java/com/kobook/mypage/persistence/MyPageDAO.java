package com.kobook.mypage.persistence;

import java.util.HashMap;
import java.util.List;

import com.kobook.book.domain.BookVO;
import com.kobook.mypage.domain.OrderVO;
import com.kobook.person.domain.PersonVO;


public interface MyPageDAO {
	
	public List<BookVO> sellList(int person_id);
	public void sellStateUpdate(BookVO vo);
	public List<HashMap<String, String>> buyList(int person_id);
	public List<HashMap<String, String>> pickList(int person_id);
	public void pickUpdate(int pick_id);
	public  List<HashMap<String, String>> mileageList(int person_id);
	public  List<HashMap<String, String>> orderList(int person_id);
	public PersonVO orderPerson(int person_id);
	public void orderInsert(OrderVO vo);
	
	
}
