package com.kobook.board.persistence;

import java.util.List;


import com.kobook.board.domain.BoardVO;
import com.kobook.book.domain.SearchCriteria;


public interface BoardDAO {

	//공지사항 입력(관리자)
	public int boardInsert(BoardVO vo)throws Exception;

	//공지사항 출력
	public List<BoardVO> boardListCri(SearchCriteria cri)throws Exception;
	
	//공지사항 디테일
	public BoardVO boardRead(Integer board_id) throws Exception;	
	
	//공지사항 선택번호
	public int getBno() throws Exception;
	
	//공지사항 페이징카운터
	public int boardcountPaging(SearchCriteria cri)throws Exception;
	
	//공지사항 조회수
	public void boardUpdateView(Integer board_id)throws Exception;
	
	//공지사항 삭제
	public void boardRemove(Integer board_id)throws Exception;
}
