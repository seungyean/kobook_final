package com.kobook.community.persistence;

import com.kobook.community.domain.BlackFileVO;
import com.kobook.community.domain.BlackVO;

public interface BlackDAO {
	//blackInsert
	public void blackInsert(BlackVO vo) throws Exception;
	//blackAddAttach
	public void blackAddAttach(BlackFileVO fileVO) throws Exception;
	
	
}
