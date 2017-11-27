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
	
	public List<ReviewVO> reviewList(int person_id,SearchCriteria cri)throws Exception;
	
	public PersonDTO readSellPerson(int person_id) throws Exception;

	public int countPaging(SearchCriteria cri)throws Exception;
	
	
	
	public void modify(BookVO book)throws Exception;
	
	public void pick(PickVO pick)throws Exception;
	
	public int getPersonIdByBookId(int book_id) throws Exception;
	
	//리뷰 작성자
	public int writeId(int person_id) throws Exception;
	
	public void reviewregist(ReviewVO review)throws Exception;
	
	//평점을 위한 리뷰갯수
	public int countReview(int person_id)throws Exception;
	
	//평점을 위한 총별점
	public int countStar(int person_id)throws Exception;
	
	//5점,4,3,2,1,
	public int fivestar(int person_id)throws Exception;
	public int fourstar(int person_id)throws Exception;
	public int threestar(int person_id)throws Exception;
	public int twostar(int person_id)throws Exception;
	public int onestar(int person_id)throws Exception;
	
}