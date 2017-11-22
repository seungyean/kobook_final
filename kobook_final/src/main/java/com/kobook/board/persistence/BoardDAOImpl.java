package com.kobook.board.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kobook.board.domain.BoardVO;
import com.kobook.board.domain.ListModelVO;
import com.kobook.board.domain.SearchVO;
import com.kobook.book.domain.SearchCriteria;

@Repository
public class BoardDAOImpl implements BoardDAO {
	
	@Inject
	private SqlSession session;
	
	private static String namespace="com.kobook.mappers.boardMapper";

	@Override
	public int insertBoard(BoardVO vo) throws Exception {
		return session.insert(namespace + ".insertBoard", vo);
	}
	
/*	@Override
	public List<BoardVO> listCriteria(SearchCriteria cri)throws Exception {
		return session.selectList(namespace+".listCriteria",cri,new RowBounds(cri.getPageStart(),cri.getPerPageNum()));
	}*/

/*	@Override
	public int countPaging(SearchCriteria cri) throws Exception {
		return session.selectOne(namespace+".countPaging",cri);
	}*/
	
	@Override
	public BoardVO read(Integer board_id) throws Exception {
		return session.selectOne(namespace +".read", board_id);
	}
	
	@Override
	public int getBno() throws Exception {
		return session.selectOne(namespace+".maxNum");
	}
}
