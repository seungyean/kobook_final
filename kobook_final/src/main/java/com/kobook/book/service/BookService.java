package com.kobook.book.service;

import java.util.List;

import com.kobook.book.domain.PickVO;
import com.kobook.book.domain.ReviewVO;
import com.kobook.book.domain.BookVO;
import com.kobook.book.domain.PersonDTO;
import com.kobook.book.domain.SearchCriteria;

public interface BookService {

	public void regist(BookVO book)throws Exception;
	
	public BookVO read(Integer book_id) throws Exception;
	
	public List<BookVO> listCriteria(SearchCriteria cri)throws Exception;
	
	public List<BookVO> directListCriteria(SearchCriteria cri)throws Exception;
	
	public List<BookVO> safeListCriteria(SearchCriteria cri)throws Exception;
	
	public List<BookVO> sellPersonList(int person_id) throws Exception;
	
	public PersonDTO readSellPerson(int person_id) throws Exception;

	public int countPaging(SearchCriteria cri)throws Exception;
	
	public void reviewregist(ReviewVO review)throws Exception;
	
	public void modify(BookVO book)throws Exception;
	
	public void pick(PickVO pick)throws Exception;
	
	public int getPersonIdByBookId(int book_id) throws Exception;
	
	//public int getPayId()throws Exception;
	
}