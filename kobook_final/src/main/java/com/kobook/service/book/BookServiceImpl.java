package com.kobook.service.book;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kobook.domain.book.BookVO;
import com.kobook.domain.book.FileVO;
import com.kobook.persistence.book.BookDAO;

@Service
public class BookServiceImpl implements BookService {

	@Inject
	private BookDAO dao;
	
	@Override
	public void regist(BookVO book) throws Exception {
		dao.create(book);
		String[] files=book.getFiles();
		int bno=dao.getBno();
		FileVO fileVO=new FileVO();
		fileVO.setBno(bno);
		
		if(files==null){
			return;
		}
		
		for(String fileName:files){
			fileVO.setFullName(fileName);
			dao.addAttach(fileVO);
		}	
	}

	

	

}
