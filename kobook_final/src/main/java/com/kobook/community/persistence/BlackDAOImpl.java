package com.kobook.community.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kobook.community.domain.BlackFileVO;
import com.kobook.community.domain.BlackVO;

@Repository
public class BlackDAOImpl implements BlackDAO {

	@Inject
	private SqlSession session;
	
	private static String namespace = "com.kobook.mappers.blackMapper";

	@Override
	public void blackInsert(BlackVO vo) throws Exception {
		session.insert(namespace+".blackInsert", vo);		
	}

	@Override
	public void blackAddAttach(BlackFileVO fileVO) throws Exception {
		session.insert(namespace+".blackAddAttach", fileVO);
		
	}
}
