package com.kobook.mypage.persistence;

import java.util.HashMap;
import java.util.List;

import com.kobook.book.domain.BookVO;
import com.kobook.mypage.domain.DeliveryVO;
import com.kobook.mypage.domain.MileageVO;
import com.kobook.mypage.domain.OrderVO;
import com.kobook.mypage.domain.PayVO;
import com.kobook.person.domain.PersonVO;


public interface MyPageDAO {
	
	/* 판매내역 */
	public List<BookVO> sellList(int person_id);
	/* 판매 상태 변경 */
	public void sellStateUpdate(BookVO vo);
	/* 구매내역 */
	public List<HashMap<String, String>> buyList(int person_id);
	/* 찜 내역 */
	public List<HashMap<String, String>> pickList(int person_id);
	/* 찜 상태 변경 */
	public void pickUpdate(int pick_id);
	/* 마일리지 내역 */
	public  List<HashMap<String, String>> mileageList(int person_id);
	/* 주문자 */
	public PersonVO orderPerson(int person_id);
	/* 주문 등록 */
	public void orderInsert(OrderVO vo);
	/* max order_id */
	public int maxOrderID(int order_id);
	/* 배달 등록 */
	public void deliveryInsert(DeliveryVO vo);
	/* 결제 등록 */
	public void payInsert(PayVO vo);
	/* 선택한 책 */
	public BookVO oneBook(int book_id);
	/* 마일리지 등록 */
	public int mileageInsert(MileageVO vo);
	/* 회원의 마일리지 수정(적립) */
	public void mileageUpdate(int person_id, int mileage_point);
	
	
}
