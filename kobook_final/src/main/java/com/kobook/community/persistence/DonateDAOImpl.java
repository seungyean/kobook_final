package com.kobook.community.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kobook.community.domain.DonateFileVO;
import com.kobook.community.domain.DonateVO;

@Repository
public class DonateDAOImpl implements DonateDAO {
	
	@Inject
	private SqlSession session;
	
	private static String namespace="com.kobook.mappers.donateMapper";

	@Override
	public void donateInsert(DonateVO vo) throws Exception {
		session.insert(namespace+".donateInsert", vo);
	}

	@Override
	public void donateAddAttach(DonateFileVO fileVO) throws Exception {
		session.insert(namespace+".donateAddAttach", fileVO);
	}

	@Override
	public int donateMaxNum() throws Exception {
		return session.selectOne(namespace+".donateMaxNum");
	}

}
