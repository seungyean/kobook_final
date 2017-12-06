package com.kobook.mypage.service;

import java.util.HashMap;
import java.util.List;

import com.kobook.book.domain.BookVO;
import com.kobook.message.DTO.MessageDTO;
import com.kobook.message.domain.MessageVO;
import com.kobook.mypage.domain.DeliveryVO;
import com.kobook.mypage.domain.MileageVO;
import com.kobook.mypage.domain.MyPageCriteria;
import com.kobook.mypage.domain.OrderVO;
import com.kobook.mypage.domain.PayVO;
import com.kobook.mypage.domain.SearchDateCriteria;
import com.kobook.person.domain.PersonVO;


public interface MyPageService {
	
	/* 판매내역 */
	public List<BookVO> sellList(SearchDateCriteria cri)throws Exception;
	/* 판매 상태 변경 */
	public void sellStateModify(BookVO vo)throws Exception;
	/* 구매내역 */
	public List<HashMap<String, String>> buyList(SearchDateCriteria cri)throws Exception;
	/* 구매내역 리스트 카운팅 */
	public Integer countPaging(SearchDateCriteria cri)throws Exception;
	/* 찜리스트 카운팅 */
	public Integer countPagingPick(MyPageCriteria cri)throws Exception;
	/* 판매내역 카운팅 */
	public Integer sellCountPaging(MyPageCriteria cri)throws Exception;
	/* 찜 내역 */
	public List<HashMap<String, String>> pickList(MyPageCriteria cri)throws Exception;
	/* 찜 상태 변경 */
	public void pickModify(int pick_id)throws Exception;
	/* 마일리지 내역 */
	public  List<HashMap<String, String>> mileageList(int person_id)throws Exception;
	/* 주문자 */
	public PersonVO orderPerson(int person_id)throws Exception;
	/* 주문 등록 */
	public void orderRegist(OrderVO orderVO, PayVO payVO, DeliveryVO deliveryVO, MileageVO mileageVO,BookVO bookVO)throws Exception;
	/* 선택한 책 */
	public BookVO oneBook(int book_id)throws Exception;
	/* 회원의 총 마일리지  조회*/
	public Integer mileageTotal(Integer person_id)throws Exception;
	/* 회원의 사용가능 마일리지  조회*/
	public Integer mileageUse(Integer person_id)throws Exception;
	/* 회원이 받은 쪽지 조회 */
	public List<HashMap<String, String>> receivedMsgTotal (int receiver_id)throws Exception;
	/* 받은쪽지 읽기 */
	public void msgModify(int message_id)throws Exception;
	/* 쪽지 삭제 */ 
	public void msgDelete(int message_id)throws Exception;
	
}
