package com.kobook.book.persistence;

import java.util.List;

import com.kobook.book.domain.PickVO;
import com.kobook.book.domain.BookVO;
import com.kobook.book.domain.SearchCriteria;

public interface BookDAO {

	public void create(BookVO vo)throws Exception;

	public List<BookVO> listCriteria(SearchCriteria cri)throws Exception;
	
	public List<BookVO> locationCriteria(SearchCriteria cri)throws Exception;
	
	public int countPaging(SearchCriteria cri)throws Exception;
	
	public BookVO read(Integer book_id) throws Exception;
	
	public void update(BookVO vo)throws Exception;
	
	public void pick(PickVO pick)throws Exception;
	
	
	
	
	
	
}