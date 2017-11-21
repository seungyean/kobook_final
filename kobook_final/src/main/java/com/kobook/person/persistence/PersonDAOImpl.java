package com.kobook.person.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;

public class PersonDAOImpl implements PersonDAO {

	@Inject
	private SqlSession session;
	
	private static String namespace = "com.kobook.mappers.personMapper";
	
	
	@Override
	public int findPersonId(String person_email) throws Exception {
		return session.selectOne(namespace+".findId", person_email);
	}

}
