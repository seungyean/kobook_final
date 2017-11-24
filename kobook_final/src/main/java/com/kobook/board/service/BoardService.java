package com.kobook.board.service;

import java.util.List;


import com.kobook.board.domain.BoardVO;
import com.kobook.book.domain.SearchCriteria;

public interface BoardService {
	
	public void boardRegist(BoardVO vo) throws Exception;
	
	public List<BoardVO> boardListCri(SearchCriteria cri) throws Exception;
	
	public BoardVO boardRead(Integer board_id) throws Exception;

	public int getBno() throws Exception;
	
	public int boardcountPaging(SearchCriteria cri) throws Exception;
	
	public void boardRemove(Integer board_id) throws Exception;
	
	public void boardModify(BoardVO vo) throws Exception;
}
