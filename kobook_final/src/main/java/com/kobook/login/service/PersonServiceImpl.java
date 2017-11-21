package com.kobook.login.service;

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

}
