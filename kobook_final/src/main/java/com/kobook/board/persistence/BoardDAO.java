package com.kobook.board.persistence;

import java.util.List;


import com.kobook.board.domain.BoardVO;
import com.kobook.book.domain.SearchCriteria;


public interface BoardDAO {

	//�������� �Է�(������)
	public int boardInsert(BoardVO vo)throws Exception;

	//�������� ���
	public List<BoardVO> boardListCri(SearchCriteria cri)throws Exception;
	
	//�������� ������
	public BoardVO boardRead(Integer board_id) throws Exception;	
	
	//�������� ���ù�ȣ
	public int getBno() throws Exception;
	
	//�������� ����¡ī����
	public int boardcountPaging(SearchCriteria cri)throws Exception;
	
	//�������� ��ȸ��
	public void boardUpdateView(Integer board_id)throws Exception;
	
	//�������� ����
	public void boardRemove(Integer board_id)throws Exception;
}
