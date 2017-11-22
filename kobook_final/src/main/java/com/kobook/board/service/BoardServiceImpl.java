package com.kobook.board.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kobook.board.domain.BoardVO;
import com.kobook.board.persistence.BoardDAO;
import com.kobook.book.domain.SearchCriteria;

@Service
public class BoardServiceImpl implements BoardService {

	@Inject
	private BoardDAO dao;
	
	@Override
	public void regist(BoardVO vo) throws Exception {
		dao.insertBoard(vo);
		Integer board_id=dao.getBno();
	}
	
/*	@Override
	public List<BoardVO> list(SearchCriteria cri) throws Exception {
		return dao.listCriteria(cri);
	}*/
	
/*	@Override
	public int countPaging(SearchCriteria cri)throws Exception {
		return dao.countPaging(cri);
	}*/

	@Override
	public BoardVO read(Integer board_id) throws Exception {
		return dao.read(board_id);
	}
	
	@Override
	public int getBno() throws Exception {
		return dao.getBno();
	}
	
	
}
