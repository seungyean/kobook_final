package com.kobook.mypage.persistence;

import java.util.HashMap;
import java.util.List;

import com.kobook.book.domain.BookVO;
import com.kobook.message.domain.MessageVO;
import com.kobook.mypage.domain.DeliveryVO;
import com.kobook.mypage.domain.MileageVO;
import com.kobook.mypage.domain.MyPageCriteria;
import com.kobook.mypage.domain.OrderVO;
import com.kobook.mypage.domain.PayVO;
import com.kobook.person.domain.PersonVO;


public interface MyPageDAO {
	
	/* 판매내역 */
	public List<BookVO> sellList(int person_id) throws Exception;
	/* 판매 상태 변경 */
	public void sellStateUpdate(BookVO vo) throws Exception;
	/* 구매내역 */
	public List<HashMap<String, String>> buyList(MyPageCriteria cri) throws Exception;
	/* 구매내역 날짜별 조회 */
	public List<HashMap<String, String>> buyListDate(MyPageCriteria cri) throws Exception;
	/* 구매내역 리스트 카운팅 */
	public Integer countPaging(MyPageCriteria cri)throws Exception;
	public Integer countPagingPick(MyPageCriteria cri)throws Exception;
	/* 찜 내역 */
	public List<HashMap<String, String>> pickList(MyPageCriteria cri) throws Exception;
	/* 찜 상태 변경 */
	public void pickUpdate(int pick_id) throws Exception;
	/* 마일리지 내역 */
	public  List<HashMap<String, String>> mileageList(int person_id) throws Exception;
	/* 주문자 */
	public PersonVO orderPerson(int person_id) throws Exception;
	/* 주문 등록 */
	public void orderInsert(OrderVO vo) throws Exception;
	/* max order_id */
	public int maxOrderID(int order_id) throws Exception;
	/* max pay_id */
	public int maxPayID(int pay_id) throws Exception;
	/* 배달 등록 */
	public void deliveryInsert(DeliveryVO vo) throws Exception;
	/* 결제 등록 */
	public void payInsert(PayVO vo) throws Exception;
	/* 선택한 책 */
	public BookVO oneBook(int book_id) throws Exception;
	/* 마일리지 등록(적립) */
	public int mileageInsert(MileageVO vo) throws Exception;
	/* 회원의 총 마일리지  조회*/
	public Integer mileageTotal(Integer person_id) throws Exception;
	/* 회원의 사용 마일리지  조회*/
	public Integer mileageUse(Integer person_id) throws Exception;
	/* 회원의 마일리지 수정(차감) */
	public void mileageMinus(MileageVO vo) throws Exception;
	/* 회원이 받은 쪽지 조회 */
	public List<HashMap<String, String>> receivedMsgTotal (int receiver_id) throws Exception;
	/* 받은쪽지 읽기 */
	public void msgUpdate(int message_id) throws Exception;
	
}
