package com.kobook.mypage.persistence;

import java.util.List;

import com.kobook.domain.book.BookVO;

public interface MyPageDAO {
	
	public List<BookVO> sellList(int bno);

}
