package com.kobook.admin.persistence;

import com.kobook.admin.domain.VisitVO;

public interface VisitDAO {

	//�� ������
	public void visitTotal(VisitVO vo) throws Exception;

}
