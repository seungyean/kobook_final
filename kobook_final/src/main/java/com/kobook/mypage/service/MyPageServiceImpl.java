package com.kobook.mypage.service;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kobook.book.domain.BookVO;
import com.kobook.mypage.persistence.MyPageDAO;

@Service
public class MyPageServiceImpl implements MyPageService {
	
	@Inject
	private MyPageDAO dao;

	@Override
	public List<BookVO> sellList(int person_id) {
		return dao.sellList(person_id);
	}

	@Override
	public void sellStateUpdate(BookVO vo) {
		dao.sellStateUpdate(vo);
		
	}

	@Override
	public List<HashMap<String, String>> buyList(int person_id) {
		return dao.buyList(person_id);
	}

}
