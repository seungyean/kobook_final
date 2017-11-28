package com.kobook.mypage.service;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kobook.book.domain.BookVO;
import com.kobook.mypage.domain.DeliveryVO;
import com.kobook.mypage.domain.MileageVO;
import com.kobook.mypage.domain.OrderVO;
import com.kobook.mypage.domain.PayVO;
import com.kobook.mypage.persistence.MyPageDAO;
import com.kobook.person.domain.PersonVO;

@Service
public class MyPageServiceImpl implements MyPageService {
	
	@Inject
	private MyPageDAO dao;

	@Override
	public List<BookVO> sellList(int person_id) {
		return dao.sellList(person_id);
	}

	@Override
	public void sellStateModify(BookVO vo) {
		dao.sellStateUpdate(vo);
		
	}

	@Override
	public List<HashMap<String, String>> buyList(int person_id) {
		return dao.buyList(person_id);
	}

	@Override
	public List<HashMap<String, String>> pickList(int person_id) {
		return dao.pickList(person_id);
	}

	@Override
	public void pickModify(int pick_id) {
		 dao.pickUpdate(pick_id);
	}

	@Override
	public List<HashMap<String, String>> mileageList(int person_id) {
		return dao.mileageList(person_id);
	}

	@Override
	public PersonVO orderPerson(int person_id) {
		return dao.orderPerson(person_id);
	}

	@Transactional
	@Override
	public void orderRegist(OrderVO orderVO, PayVO payVO, DeliveryVO deliveryVO) {
		dao.orderInsert(orderVO);
		
		int order_id = dao.maxOrderID(orderVO.getOrder_id());
		payVO.setOrder_id(order_id);
		dao.payInsert(payVO);
		
		deliveryVO.setOrder_id(order_id);
		dao.deliveryInsert(deliveryVO);
		
		
		
	}

	@Override
	public BookVO oneBook(int book_id) {
		return dao.oneBook(book_id);
	}

	@Override
	public int mileageRegist(MileageVO vo) {
		return dao.mileageInsert(vo);
	}

	@Override
	public void mileageModify(int person_id, int mileage_point) {
		dao.mileageUpdate(person_id, mileage_point);
	}

	
	



}
