package com.kobook.admin.persistence;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kobook.admin.domain.VisitVO;
import com.kobook.person.domain.PersonVO;

@Repository
public class VisitDAOImpl implements VisitDAO{

	@Inject
	private SqlSession session;
	
	private static String namespace="com.kobook.mappers.visitMapper";

	@Override
	public int visitCount() throws Exception {
		return session.selectOne(namespace+".visitCount");
	}

	@Override
	public void visitRegist(int person_id) throws Exception {
		session.insert(namespace+".visitRegist", person_id);
	}
	
	@Override
	public List<PersonVO> blackPersonList () throws Exception {
		return session.selectList(namespace+".blackPersonList");
	}
	
	@Override
	public List<Map<String, String>> visitCountView() throws Exception {
		return session.selectList(namespace+".visitCountView");
	}
}
