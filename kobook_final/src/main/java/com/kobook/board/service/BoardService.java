package com.kobook.board.service;

import java.util.List;


import com.kobook.board.domain.BoardVO;
import com.kobook.book.domain.SearchCriteria;

public interface BoardService {
	
	public void BoardRegist(BoardVO vo)throws Exception;
	
	public List<BoardVO> BoardListCri(SearchCriteria cri)throws Exception;
	
	public BoardVO BoardRead(Integer board_id) throws Exception;

	public int getBno() throws Exception;
	
	public int BoardcountPaging(SearchCriteria cri) throws Exception;
	
}
