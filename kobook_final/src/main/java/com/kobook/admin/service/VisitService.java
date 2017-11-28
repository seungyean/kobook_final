package com.kobook.admin.service;

import java.util.List;

import com.kobook.admin.domain.VisitVO;
import com.kobook.board.domain.BoardVO;
import com.kobook.book.domain.SearchCriteria;
import com.kobook.person.domain.PersonVO;

public interface VisitService {
	
	public void visitTotal(VisitVO vo)throws Exception;
	
}
