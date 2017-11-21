package com.kobook.persistence.book;

import java.util.List;

import com.kobook.domain.book.BookVO;
import com.kobook.domain.book.FileVO;

public interface BookDAO {

	public void create(BookVO vo)throws Exception;
	
	public int getBno() throws Exception;
	
	public void addAttach(FileVO fileVO)throws Exception;
	
	  //public List<BookVO> listBook()throws Exception;
	
	
}
