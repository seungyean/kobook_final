package com.kobook.admin.service;

import java.util.List;

import javax.inject.Inject;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.kobook.admin.domain.VisitVO;
import com.kobook.admin.persistence.VisitDAO;
import com.kobook.board.domain.BoardVO;
import com.kobook.board.persistence.BoardDAO;
import com.kobook.book.domain.SearchCriteria;
import com.kobook.person.domain.PersonVO;

@Service
public class VisitServiceImpl implements VisitService {

	@Inject
	private VisitDAO dao;
	
	@Override
	public int visitCount(VisitVO vo) throws Exception {
		return dao.visitCount(vo);
	}
}
