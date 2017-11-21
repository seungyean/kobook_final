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
	public List<BookVO> sellList(int bno) {
		return dao.sellList(bno);
	}

	@Override
	public void sellStateUpdate(BookVO vo) {
		dao.sellStateUpdate(vo);
		
	}

	@Override
	public List<HashMap<String, String>> buyList(int bno) {
		return dao.buyList(bno);
	}

}
