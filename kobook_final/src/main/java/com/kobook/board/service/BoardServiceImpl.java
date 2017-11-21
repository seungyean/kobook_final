package com.kobook.board.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kobook.board.domain.BoardVO;
import com.kobook.board.persistence.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService {

	@Inject
	private BoardDAO dao;
	
	@Override
	public void regist(BoardVO vo) throws Exception {
		dao.insertBoard(vo);
	}

}
