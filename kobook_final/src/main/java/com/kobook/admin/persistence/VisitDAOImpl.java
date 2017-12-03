package com.kobook.admin.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kobook.admin.domain.VisitVO;

@Repository
public class VisitDAOImpl implements VisitDAO{

	@Inject
	private SqlSession session;
	
	private static String namespace="com.kobook.mappers.visitMapper";
	
	@Override
	public int visitCount() throws Exception {
		return session.selectOne(namespace+".visitCount");
	}
	
	/*@Override
	public List<VisitVO> visitList() throws Exception {
		return session.selectList(namespace+".visitList");
	}*/
}
