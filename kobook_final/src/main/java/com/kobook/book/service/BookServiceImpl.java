package com.kobook.book.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kobook.book.domain.BookVO;
import com.kobook.book.domain.FileVO;
import com.kobook.book.domain.SearchCriteria;
import com.kobook.book.persistence.BookDAO;

@Service
public class BookServiceImpl implements BookService {

	@Inject
	private BookDAO dao;
	
	@Transactional
	@Override
	public void regist(BookVO book) throws Exception {
		book.setPerson_id(3);
		dao.create(book);
		String[] files=book.getFiles();
		Integer book_id=dao.getBno();
		
		FileVO fileVO=new FileVO();
		fileVO.setBook_id(book_id);
		System.out.println(book.toString());
		if(files==null){
			return;
		}
		
		for(String file_name:files){
			fileVO.setFile_name(file_name);
			dao.addAttach(fileVO);
		}	
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
	public int countPaging(SearchCriteria cri) throws Exception {
		return dao.countPaging(cri);
	}




	@Transactional
	@Override
	public void modify(BookVO book) throws Exception {
		dao.update(book);
		Integer book_id=dao.getBno();
		dao.deleteAttach(book_id);
		
		FileVO fileVO=new FileVO();
		fileVO.setBook_id(book_id);
		
		String files[]=book.getFiles();
		if(files==null){
			return;
		}
		
		for(String file_name:files){
			dao.replaceAttach(file_name, book_id);
		}	
		
	}


}