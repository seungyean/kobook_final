package com.kobook.board.persistence;

import java.util.List;


import com.kobook.board.domain.BoardVO;
import com.kobook.book.domain.BookVO;
import com.kobook.book.domain.Criteria;
import com.kobook.book.domain.SearchCriteria;


public interface BoardDAO {

	public int BoardInsert(BoardVO vo)throws Exception;

	public List<BoardVO> BoardListCri(SearchCriteria cri)throws Exception;
	
	public BoardVO BoardRead(Integer board_id) throws Exception;	
	
	public int getBno() throws Exception;
	
	public int BoardcountPaging(SearchCriteria cri)throws Exception;
	
	
	public void update(BookVO vo)throws Exception;
	
	
}
