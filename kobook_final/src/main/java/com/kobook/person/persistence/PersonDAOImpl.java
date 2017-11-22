package com.kobook.person.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kobook.login.DTO.LoginDTO;
import com.kobook.person.domain.PersonVO;

@Repository
public class PersonDAOImpl implements PersonDAO {

	@Inject
	private SqlSession session;
	
	private static String namespace = "com.kobook.mappers.personMapper";
	
	@Override
	public int findPersonId(String person_email) throws Exception {
		if(session.selectOne(namespace+".findId", person_email) == null){
			return -1;
		} else {
			return session.selectOne(namespace+".findId", person_email);
		}
	}
	
	@Override
	public PersonVO login(LoginDTO dto) throws Exception {
		
		return session.selectOne(namespace + ".login", dto);
	}

}
