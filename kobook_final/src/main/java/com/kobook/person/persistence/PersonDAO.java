package com.kobook.person.persistence;

public interface PersonDAO {
	
	public int findPersonId(String person_email) throws Exception;

}
