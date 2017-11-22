package com.kobook.book.persistence;

import java.util.List;

import com.kobook.book.domain.BookVO;
import com.kobook.book.domain.FileVO;
import com.kobook.book.domain.SearchCriteria;

public interface BookDAO {

	public void create(BookVO vo)throws Exception;
	
	public int getBno() throws Exception;

	public List<BookVO> listCriteria(SearchCriteria cri)throws Exception;
	
	public int countPaging(SearchCriteria cri)throws Exception;
	
	public BookVO read(Integer book_id) throws Exception;
	
	public void update(BookVO vo)throws Exception;
	
	public void addAttach(FileVO fileVO)throws Exception;
	
	public void deleteAttach(Integer book_id) throws Exception;
	
	public void replaceAttach(String file_name, Integer book_id)throws Exception;
	
	
	
	
	
	
}