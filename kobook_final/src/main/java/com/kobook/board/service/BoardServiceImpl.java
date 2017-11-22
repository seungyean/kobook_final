package com.kobook.board.service;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import com.kobook.board.domain.BoardVO;
import com.kobook.board.persistence.BoardDAO;
import com.kobook.book.domain.BookVO;
import com.kobook.book.domain.SearchCriteria;

@Service
public class BoardServiceImpl implements BoardService {

	@Inject
	private BoardDAO dao;
	
	@Override
	public void BoardRegist(BoardVO vo) throws Exception {
		dao.BoardInsert(vo);
		Integer board_id=dao.getBno();
	}
	
	@Override
	public List<BoardVO> BoardListCri(SearchCriteria cri) throws Exception {
		return dao.BoardListCri(cri);
	}
	
	@Override
	public int BoardcountPaging(SearchCriteria cri) throws Exception {
		return dao.BoardcountPaging(cri);
	}
	
	@Override
	public BoardVO BoardRead(Integer board_id) throws Exception {
		return dao.BoardRead(board_id);
	}
	
	@Override
	public int getBno() throws Exception {
		return dao.getBno();
	}
	
	
}
