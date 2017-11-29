package com.kobook.book.service;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kobook.book.domain.PickVO;
import com.kobook.book.domain.ReviewVO;
import com.kobook.book.domain.BookVO;

import com.kobook.book.domain.PersonDTO;
import com.kobook.book.domain.SearchCriteria;
import com.kobook.book.persistence.BookDAO;
import com.kobook.mypage.domain.DeliveryVO;
import com.kobook.person.domain.PersonVO;

@Service
public class BookServiceImpl implements BookService {

	@Inject
	private BookDAO dao;
	

	@Override
	public void regist(BookVO book) throws Exception {
		//book.setPerson_id(3);
		dao.create(book);
		System.out.println(book.toString());
		
	}

	
	
	
	@Override
	public BookVO read(Integer book_id) throws Exception {
		return dao.read(book_id);
	}


	


	@Override
	public List<BookVO> listCriteria(SearchCriteria cri) throws Exception {
		return dao.listCriteria(cri);
	}

	

	@Override
	public List<BookVO> directListCriteria(SearchCriteria cri) throws Exception {
		return dao.directListCriteria(cri);
	}


	@Override
	public List<BookVO> safeListCriteria(SearchCriteria cri) throws Exception {
		return dao.safeListCriteria(cri);
	}

	


	@Override
	public PersonDTO readSellPerson(int person_id) throws Exception {
		return dao.readSellPerson(person_id);
	}




	@Override
	public List<BookVO> sellPersonList(int person_id) throws Exception {
		return dao.sellPersonList(person_id);
	}

	

	
	
	

	@Override
	public List<ReviewVO> reviewList(int person_id,SearchCriteria cri) throws Exception {
		return dao.reviewList(person_id,cri);
	}




	@Override
	public int countPaging(SearchCriteria cri) throws Exception {
		return dao.countPaging(cri);
	}


	



	@Override
	public void reviewregist(ReviewVO review) throws Exception {
		dao.reviewCreate(review);
		System.out.println(review.toString());
		
	}




	@Override
	public void modify(BookVO book) throws Exception {
		dao.update(book);
	}




	@Override
	public void pick(PickVO pick) throws Exception {
		dao.pick(pick);
		
	}




	@Override
	public int getPersonIdByBookId(int book_id) throws Exception {
		return dao.getPersonIdByBookId(book_id);
	}


	
	


	@Override
	public String writeName(int person_id) throws Exception {
		return dao.writeName(person_id);
	}




	@Override
	public int countReview(int person_id) throws Exception {
		return dao.countReview(person_id);
	}




	@Override
	public int countStar(int person_id) throws Exception {
		int b=dao.countStar(person_id);
		System.out.println("service"+b);
		return b;
	}




	@Override
	public int fivestar(int person_id) throws Exception {
		return dao.fivestar(person_id);
	}




	@Override
	public int fourstar(int person_id) throws Exception {
		return dao.fourstar(person_id);
	}




	@Override
	public int threestar(int person_id) throws Exception {
		return dao.threestar(person_id);
	}




	@Override
	public int twostar(int person_id) throws Exception {
		return dao.twostar(person_id);
	}




	@Override
	public int onestar(int person_id) throws Exception {
		return dao.onestar(person_id);
	}




	@Override
	public List<HashMap<String, String>> deliveryList(SearchCriteria cri) throws Exception {
		return dao.deliveryList(cri);
	}




	@Override
	public int countdelList() throws Exception {
		return dao.countdelList();
	}




	@Override
	public void delstateUpdate(DeliveryVO delivery) {
		dao.delstateUpdate(delivery);
		
	}


	
	
	

	

	
	
	

}