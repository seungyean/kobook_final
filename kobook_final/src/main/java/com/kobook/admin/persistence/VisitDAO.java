package com.kobook.admin.persistence;

import java.util.List;

import com.kobook.admin.domain.VisitVO;
import com.kobook.person.domain.PersonVO;

public interface VisitDAO {

	public int visitCount() throws Exception;
	
	public void visitRegist(int person_id) throws Exception;
	
	public List<PersonVO> blackPersonList()throws Exception;
}
