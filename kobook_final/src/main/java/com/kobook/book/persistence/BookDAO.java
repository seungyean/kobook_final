package com.kobook.book.persistence;

import java.util.List;

import com.kobook.book.domain.PickVO;
import com.kobook.book.domain.ReviewVO;
import com.kobook.book.domain.BookVO;
import com.kobook.book.domain.PersonDTO;
import com.kobook.book.domain.SearchCriteria;

public interface BookDAO {

	public void create(BookVO vo)throws Exception;

	public List<BookVO> listCriteria(SearchCriteria cri) throws Exception;
	
	public List<BookVO> directListCriteria(SearchCriteria cri) throws Exception;
	
	public List<BookVO> safeListCriteria(SearchCriteria cri) throws Exception;
	
	public List<BookVO> sellPersonList(int person_id) throws Exception;
	
	//판매자정보
	public PersonDTO readSellPerson(int person_id) throws Exception;
	
	
	
	public int countPaging(SearchCriteria cri)throws Exception;
	
	public BookVO read(Integer book_id) throws Exception;
	
	public void update(BookVO vo) throws Exception;
	
	public void pick(PickVO pick) throws Exception;
	
	public int getPersonIdByBookId(int book_id) throws Exception;

	public void reviewCreate(ReviewVO review)throws Exception;
	
	//평점을 위한 리뷰갯수
	public int countReview(int person_id)throws Exception;
	
	//평점을 위한 총별점
	public int countStar(int person_id)throws Exception;
	
	
}