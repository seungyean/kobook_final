package com.kobook.mypage.service;

import java.util.HashMap;
import java.util.List;

import com.kobook.book.domain.BookVO;
import com.kobook.mypage.domain.DeliveryVO;
import com.kobook.mypage.domain.MileageVO;
import com.kobook.mypage.domain.OrderVO;
import com.kobook.mypage.domain.PayVO;
import com.kobook.person.domain.PersonVO;


public interface MyPageService {
	
	/* 판매내역 */
	public List<BookVO> sellList(int person_id);
	/* 판매 상태 변경 */
	public void sellStateModify(BookVO vo);
	/* 구매내역 */
	public List<HashMap<String, String>> buyList(int person_id);
	/* 찜 내역 */
	public List<HashMap<String, String>> pickList(int person_id);
	/* 찜 상태 변경 */
	public void pickModify(int pick_id);
	/* 마일리지 내역 */
	public  List<HashMap<String, String>> mileageList(int person_id);
	/* 주문자 */
	public PersonVO orderPerson(int person_id);
	/* 주문 등록 */
	public void orderRegist(OrderVO orderVO, PayVO payVO, DeliveryVO deliveryVO);

	/* 선택한 책 */
	public BookVO oneBook(int book_id);
	/* 마일리지 등록 */
	public int mileageRegist(MileageVO vo);
	/* 회원의 마일리지 수정(적립) */
	public void mileageModify(int person_id, int mileage_point);
}
