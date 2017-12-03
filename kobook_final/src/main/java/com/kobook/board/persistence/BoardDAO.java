package com.kobook.board.persistence;

import java.util.List;


import com.kobook.board.domain.BoardVO;
import com.kobook.book.domain.SearchCriteria;
import com.kobook.community.domain.BlackVO;
import com.kobook.person.domain.PersonVO;
import com.kobook.person.persistence.PersonDAO;


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
	public int boardCountPaging(SearchCriteria cri)throws Exception;
	
	//공지사항 조회수
	public void boardUpdateView(Integer board_id)throws Exception;
	
	//공지사항 삭제
	public void boardRemove(Integer board_id)throws Exception;
	
	//공시사항 수정
	public void boardUpdate(BoardVO vo) throws Exception;
	
	
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@    관리자용(회원)       @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@	
	
	//회원 리스트
	public List<PersonVO> personList(SearchCriteria cri) throws Exception;
	
	//회원 페이징카운터
	public int personCount(SearchCriteria cri)throws Exception;
	
	//회원 디테일
	public PersonVO personRead(Integer person_id) throws Exception;
	
	//회원정보 수정
	public void personModify(PersonVO vo) throws Exception;
	
	//회원 삭제
	public void personRemove(Integer person_id) throws Exception;
}
