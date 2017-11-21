package com.kobook.mypage.service;

import java.util.HashMap;
import java.util.List;

import com.kobook.book.domain.BookVO;


public interface MyPageService {
	
	public List<BookVO> sellList(int bno);
	public void sellStateUpdate(BookVO vo);
	public List<HashMap<String, String>> buyList(int bno);

}
