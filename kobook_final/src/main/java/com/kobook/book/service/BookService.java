package com.kobook.book.service;

import java.util.List;

import com.kobook.book.domain.BookVO;
import com.kobook.book.domain.SearchCriteria;

public interface BookService {

	public void regist(BookVO book)throws Exception;
	
	public BookVO read(Integer book_id) throws Exception;
	
	public List<BookVO> listCriteria(SearchCriteria cri)throws Exception;
	
	public int countPaging(SearchCriteria cri)throws Exception;
	
	public void modify(BookVO book)throws Exception;
	
	
	
}
