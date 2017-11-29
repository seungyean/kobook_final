package com.kobook.book.persistence;

import java.util.HashMap;
import java.util.List;

import com.kobook.book.domain.PickVO;
import com.kobook.book.domain.ReviewVO;
import com.kobook.book.domain.BookVO;

import com.kobook.book.domain.PersonDTO;
import com.kobook.book.domain.SearchCriteria;
import com.kobook.mypage.domain.DeliveryVO;
import com.kobook.person.domain.PersonVO;

public interface BookDAO {

	public void create(BookVO vo)throws Exception;

	public List<BookVO> listCriteria(SearchCriteria cri) throws Exception;
	
	public List<BookVO> directListCriteria(SearchCriteria cri) throws Exception;
	
	public List<BookVO> safeListCriteria(SearchCriteria cri) throws Exception;
	
	//판매자의 다른상품 리스트
	public List<BookVO> sellPersonList(int person_id) throws Exception;
	
	//판매자 후기 리스트
	public List<ReviewVO> reviewList(int person_id,SearchCriteria cri)throws Exception;
	
	
	//판매자정보
	public PersonDTO readSellPerson(int person_id) throws Exception;
	
	
	
	public int countPaging(SearchCriteria cri)throws Exception;
	
	public BookVO read(Integer book_id) throws Exception;
	
	public void update(BookVO vo) throws Exception;
	
	public void pick(PickVO pick) throws Exception;
	
	public int getPersonIdByBookId(int book_id) throws Exception;
	
	//리뷰 작성자
	public String writeName(int person_id)throws Exception;

	public void reviewCreate(ReviewVO review)throws Exception;
	
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
	
	//안심거래 배송리스트
	public List<HashMap<String, String>> deliveryList(SearchCriteria cri);
	
	//배송리스트 카운팅
	public int countdelList()throws Exception;
	
	//배송상태 업데이트
	public void delstateUpdate(DeliveryVO delivery);
	
}