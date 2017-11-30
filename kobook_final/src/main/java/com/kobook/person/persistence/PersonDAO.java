package com.kobook.person.persistence;

import com.kobook.login.DTO.LoginDTO;
import com.kobook.person.domain.PersonVO;

public interface PersonDAO {
	
	public int findPersonId(String person_email) throws Exception;
	public String findPersonEmail(int person_id) throws Exception;
	public String findPersonName(int person_id) throws Exception;
	
	public PersonVO login(LoginDTO dto) throws Exception;
	public PersonVO loginCheck(String person_email);

}
