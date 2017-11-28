package com.kobook.board.service;

import java.util.List;


import com.kobook.board.domain.BoardVO;
import com.kobook.book.domain.SearchCriteria;
import com.kobook.person.domain.PersonVO;

public interface BoardService {
	
	//@@@@@@@@@@@@@@@@@@@@@@@@  공지사항   @@@@@@@@@@@@@@@@@@@@@@@@
	
	public void boardRegist(BoardVO vo) throws Exception;
	
	public List<BoardVO> boardListCri(SearchCriteria cri) throws Exception;
	
	public BoardVO boardRead(Integer board_id) throws Exception;

	public int getBno() throws Exception;
	
	public int boardCountPaging(SearchCriteria cri) throws Exception;
	
	public void boardRemove(Integer board_id) throws Exception;
	
	public void boardModify(BoardVO vo) throws Exception;
	
	//@@@@@@@@@@@@@@@@@@@@@@@@  관리자용  (회원)  @@@@@@@@@@@@@@@@@@@@@@@@
	
	public List<PersonVO> personList(SearchCriteria cri) throws Exception;
	
	public int personCountPage(SearchCriteria cri)throws Exception; 
	
	public PersonVO personRead(Integer person_id)throws Exception;
	
	public void personModify(PersonVO vo) throws Exception;
	
	public void personRemove(Integer person_id) throws Exception;
	
}
