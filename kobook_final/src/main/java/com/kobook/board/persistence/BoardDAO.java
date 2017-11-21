package com.kobook.board.persistence;

import com.kobook.board.domain.BoardVO;

public interface BoardDAO {

	public int insertBoard(BoardVO vo)throws Exception;
	/*	public List<BoardVO> listBoard(RowBounds row);
		public BoardVO selectBoard(Integer board_id);
		public BoardVO detailNoti(Integer board_id);*/
	
}
