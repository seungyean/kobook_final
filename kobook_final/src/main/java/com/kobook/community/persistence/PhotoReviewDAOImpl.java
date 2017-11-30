package com.kobook.community.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kobook.community.domain.PhotoFileVO;
import com.kobook.community.domain.PhotoVO;

@Repository
public class PhotoReviewDAOImpl implements PhotoReviewDAO {
	
	@Inject
	private SqlSession session;
	
	private static String namespace="com.kobook.mappers.photoMapper";

	@Override
	public void photoInsert(PhotoVO vo) throws Exception {
		session.insert(namespace+".photoInsert", vo);
	}

	@Override
	public void photoAddAttach(PhotoFileVO fileVO) throws Exception {
		session.insert(namespace+".photoAddAttach", fileVO);
	}

	@Override
	public int photoMaxNum() throws Exception {
		return session.selectOne(namespace+".photoMaxNum");
	}
}
