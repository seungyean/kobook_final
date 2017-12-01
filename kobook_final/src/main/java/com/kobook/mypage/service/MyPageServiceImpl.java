package com.kobook.mypage.service;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kobook.book.domain.BookVO;
import com.kobook.message.DTO.MessageDTO;
import com.kobook.message.domain.MessageVO;
import com.kobook.mypage.domain.DeliveryVO;
import com.kobook.mypage.domain.MileageVO;
import com.kobook.mypage.domain.MyPageCriteria;
import com.kobook.mypage.domain.OrderVO;
import com.kobook.mypage.domain.PayVO;
import com.kobook.mypage.persistence.MyPageDAO;
import com.kobook.person.domain.PersonVO;

@Service
public class MyPageServiceImpl implements MyPageService {
	
	@Inject
	private MyPageDAO dao;

	@Override
	public List<BookVO> sellList(int person_id)throws Exception {
		return dao.sellList(person_id);
	}

	@Override
	public void sellStateModify(BookVO vo)throws Exception {
		dao.sellStateUpdate(vo);
		
	}

	@Override
	public List<HashMap<String, String>> buyList(MyPageCriteria cri)throws Exception {
		return dao.buyList(cri);
	}

	@Override
	public List<HashMap<String, String>> pickList(int person_id)throws Exception {
		return dao.pickList(person_id);
	}

	@Override
	public void pickModify(int pick_id)throws Exception {
		 dao.pickUpdate(pick_id);
	}

	@Override
	public List<HashMap<String, String>> mileageList(int person_id) throws Exception{
		return dao.mileageList(person_id);
	}

	@Override
	public PersonVO orderPerson(int person_id) throws Exception{
		return dao.orderPerson(person_id);
	}

	@Transactional
	@Override
	public void orderRegist(OrderVO orderVO, PayVO payVO, DeliveryVO deliveryVO, MileageVO mileageVO) throws Exception{
		
		// 주문
		dao.orderInsert(orderVO);
		
		// 주문 후 결제를 하고
		int order_id = dao.maxOrderID(orderVO.getOrder_id());
		payVO.setOrder_id(order_id);
		dao.payInsert(payVO);
		
		// 주문을 하고 결제를 하면 마일리지를 적립해줌 and 마일리지를 사용하면 차감도 해줌
		int pay_id = dao.maxPayID(payVO.getPay_id());
		mileageVO.setPay_id(pay_id);
		dao.mileageInsert(mileageVO);
		
		// 주문 후 결제 후 배달 등록
		deliveryVO.setOrder_id(order_id);
		dao.deliveryInsert(deliveryVO);
	}

	@Override
	public BookVO oneBook(int book_id) throws Exception{
		return dao.oneBook(book_id);
	}

	@Override
	public int mileageTotal(int person_id)throws Exception {
		return dao.mileageTotal(person_id);
	}

	@Override
	public int mileageUse(int person_id)throws Exception {
		return dao.mileageUse(person_id);
	}

	@Override
	public List<MessageVO> receivedMsgTotal(int receiver_id) throws Exception{
		return dao.receivedMsgTotal(receiver_id);
	}

	@Override
	public void msgModify(int message_id)throws Exception {
		dao.msgUpdate(message_id);
		
	}


	
	



}
