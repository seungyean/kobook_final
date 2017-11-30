package com.kobook.mypage.service;

import java.util.HashMap;
import java.util.List;

import com.kobook.book.domain.BookVO;
import com.kobook.message.DTO.MessageDTO;
import com.kobook.message.domain.MessageVO;
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
	public void orderRegist(OrderVO orderVO, PayVO payVO, DeliveryVO deliveryVO, MileageVO mileageVO);
	/* 선택한 책 */
	public BookVO oneBook(int book_id);
	/* 회원의 마일리지 수정(차감) */
//	public void mileageMinus(MileageVO vo);
	/* 회원의 총 마일리지  조회*/
	public int mileageTotal(int person_id);
	/* 회원의 사용가능 마일리지  조회*/
	public int mileageUse(int person_id);
	/* 회원이 받은 쪽지 조회 */
	public List<MessageVO> receivedMsgTotal (int receiver_id);
}
