package com.kobook.person.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kobook.login.DTO.LoginDTO;
import com.kobook.person.domain.PersonVO;
import com.kobook.person.persistence.PersonDAO;

@Service
public class PersonServiceImpl implements PersonService {

	@Inject
	private PersonDAO dao;
	
	@Override
	public PersonVO login(LoginDTO dto) throws Exception {
		return dao.login(dto);
	}

	@Override
	public int findPersonId(String person_email) throws Exception {
		return dao.findPersonId(person_email);
	}

	@Override
	public PersonVO loginCheck(String person_email) {
		return dao.loginCheck(person_email);
	}
	
}
