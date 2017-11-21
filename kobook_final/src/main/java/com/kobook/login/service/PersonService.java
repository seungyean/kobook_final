package com.kobook.login.service;

import com.kobook.login.DTO.LoginDTO;
import com.kobook.person.domain.PersonVO;

public interface PersonService {
	public PersonVO login(LoginDTO dto) throws Exception;
}
