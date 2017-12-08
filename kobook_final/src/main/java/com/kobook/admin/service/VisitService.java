package com.kobook.admin.service;

import java.util.List;

import com.kobook.admin.domain.VisitVO;

public interface VisitService {
	
	public int visitCount() throws Exception;

	public void visitRegist(int person_id) throws Exception;
}
