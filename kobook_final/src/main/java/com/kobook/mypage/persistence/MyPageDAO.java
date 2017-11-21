package com.kobook.mypage.persistence;

import java.util.HashMap;
import java.util.List;

import com.kobook.book.domain.BookVO;


public interface MyPageDAO {
	
	public List<BookVO> sellList(int bno);
	public void sellStateUpdate(BookVO vo);
	public List<HashMap<String, String>> buyList(int bno);

}
