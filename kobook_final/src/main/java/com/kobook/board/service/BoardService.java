package com.kobook.board.service;

import java.util.List;

import com.kobook.board.domain.BoardVO;
import com.kobook.book.domain.SearchCriteria;

public interface BoardService {
	
	public void regist(BoardVO vo)throws Exception;
	
	/*public List<BoardVO> list(SearchCriteria cri)throws Exception;
	
	public int countPaging(SearchCriteria cri)throws Exception;*/
	
	public BoardVO read(Integer board_id) throws Exception;

	public int getBno() throws Exception;
	
}
