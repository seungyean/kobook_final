package com.kobook.book.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kobook.book.domain.PickVO;
import com.kobook.book.domain.ReviewVO;
import com.kobook.book.domain.BookVO;
import com.kobook.book.domain.PersonDTO;
import com.kobook.book.domain.SearchCriteria;
import com.kobook.book.persistence.BookDAO;

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
	public int countReview(int person_id) throws Exception {
		return dao.countReview(person_id);
	}




	@Override
	public int countStar(int person_id) throws Exception {
		int b=dao.countStar(person_id);
		System.out.println("service"+b);
		return b;
	}



	

	
	
	

}