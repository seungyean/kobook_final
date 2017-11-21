package com.kobook.mypage.service;

import java.util.List;

import com.kobook.domain.book.BookVO;

public interface MyPageService {
	
	public List<BookVO> sellList(int bno);

}
