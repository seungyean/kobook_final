package com.kobook.admin.persistence;

import com.kobook.admin.domain.VisitVO;

public interface VisitDAO {

	public int visitCount(VisitVO vo) throws Exception;
}
