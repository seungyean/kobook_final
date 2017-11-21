package com.kobook.mypage.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kobook.domain.book.BookVO;
import com.kobook.mypage.persistence.MyPageDAO;

@Service
public class MyPageServiceImpl implements MyPageService {
	
	@Inject
	private MyPageDAO dao;

	@Override
	public List<BookVO> sellList(int bno) {
		return dao.sellList(bno);
	}

}
