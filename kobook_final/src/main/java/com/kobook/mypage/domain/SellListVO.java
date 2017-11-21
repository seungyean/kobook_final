package com.kobook.mypage.domain;

import java.util.List;

import com.kobook.book.domain.BookVO;


public class SellListVO {
	
	private List<BookVO> sellList;

	public List<BookVO> getSellList() {
		return sellList;
	}

	public void setSellList(List<BookVO> sellList) {
		this.sellList = sellList;
	}

	@Override
	public String toString() {
		return "MyPageVO [sellList=" + sellList + "]";
	}
	
	
}
