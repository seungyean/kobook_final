package com.kobook.board.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kobook.board.domain.BoardVO;
import com.kobook.book.domain.SearchCriteria;
import com.kobook.person.domain.PersonVO;


@Repository
public class BoardDAOImpl implements BoardDAO {
	
	@Inject
	private SqlSession session;
	
	private static String namespace="com.kobook.mappers.boardMapper";

	@Override
	public int boardInsert(BoardVO vo) throws Exception {
		return session.insert(namespace + ".insertBoard", vo);
	}

	@Override
	public List<BoardVO> boardListCri(SearchCriteria cri)throws Exception {
		return session.selectList(namespace+".listCriteria", cri, new RowBounds(cri.getPageStart(),cri.getPerPageNum()));
	}

	@Override
	public int boardcountPaging(SearchCriteria cri) throws Exception {
		return session.selectOne(namespace+".countPaging",cri);
	}
	
	@Override
	public BoardVO boardRead(Integer board_id) throws Exception {
		return session.selectOne(namespace +".read", board_id);
	}
	
	@Override
	public int getBno() throws Exception {
		return session.selectOne(namespace+".maxNum");
	}
	
	@Override
	public void boardUpdateView(Integer board_id) throws Exception {
		session.update(namespace +".boardUpdateView", board_id);
	}
	
	@Override
	public void boardRemove(Integer board_id) throws Exception {
		session.delete(namespace +".boardRemove", board_id);
	}
	
	@Override
	public void boardUpdate(BoardVO vo) throws Exception {
		session.update(namespace+".boardUpdate", vo);
	}
	
/*	@Override
	public List<PersonVO> currentPerson(PersonVO vo) throws Exception {
		return session.selectList(namespace+".currentPerson", vo);
	}*/
}
