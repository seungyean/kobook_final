package com.kobook.board.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kobook.board.domain.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO {
	
	@Inject
	private SqlSession session;
	
	private static String namespace="com.kobook.mappers.boardMapper";

	@Override
	public int insertBoard(BoardVO vo) throws Exception {
		return session.insert(namespace + ".insertBoard", vo);
	}

}
