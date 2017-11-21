package com.kobook.board.persistence;

import java.util.List;


import com.kobook.board.domain.BoardVO;

import com.kobook.book.domain.SearchCriteria;

public interface BoardDAO {

	public int insertBoard(BoardVO vo)throws Exception;
	
	public List<BoardVO> listCriteria(SearchCriteria cri)throws Exception;
	
	public int countPaging(SearchCriteria cri)throws Exception;
	
	public BoardVO read(Integer board_id) throws Exception;	
	/*	public void update(BoardVO vo)throws Exception;*/
	public int getBno() throws Exception;
}
