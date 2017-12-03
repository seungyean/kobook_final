package com.kobook.board.service;

import java.util.List;

import javax.inject.Inject;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.kobook.board.domain.BoardVO;
import com.kobook.board.persistence.BoardDAO;
import com.kobook.book.domain.SearchCriteria;
import com.kobook.person.domain.PersonVO;

@Service
public class BoardServiceImpl implements BoardService {

	@Inject
	private BoardDAO dao;
	
	@Override
	public void boardRegist(BoardVO vo) throws Exception {
		dao.boardInsert(vo);
		Integer board_id = dao.getBno();
	}
	
	@Override
	public List<BoardVO> boardListCri(SearchCriteria cri) throws Exception {
		return dao.boardListCri(cri);
	}
	
	@Override
	public int boardCountPaging(SearchCriteria cri) throws Exception {
		return dao.boardCountPaging(cri);
	}
	
	@Transactional(isolation=Isolation.READ_COMMITTED)
	@Override
	public BoardVO boardRead(Integer board_id) throws Exception {
		dao.boardUpdateView(board_id);
		return dao.boardRead(board_id);
	}
	
	@Override
	public int getBno() throws Exception {
		return dao.getBno();
	}

	@Override
	public void boardRemove(Integer board_id)throws Exception {
		dao.boardRemove(board_id);
	}
	
	@Override
	public void boardModify(BoardVO vo) throws Exception {
		dao.boardUpdate(vo);
	}
	
	
	//@@@@@@@@@@@@@@  회원용
	@Override
	public List<PersonVO> personList(SearchCriteria cri) throws Exception {
		return dao.personList(cri);
	}
	
	@Override
	public int personCountPage(SearchCriteria cri) throws Exception {
		return dao.personCount(cri);
	}
	
	@Override
	public PersonVO personRead(Integer person_id)throws Exception {
		return dao.personRead(person_id);
	}
	
	@Override
	public void personModify(PersonVO vo) throws Exception {
		dao.personModify(vo);
	}

	@Override
	public void personRemove(Integer person_id) throws Exception {
		dao.personRemove(person_id);
	}
}
