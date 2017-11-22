package com.kobook.community.persistence;

import java.util.List;

import com.kobook.community.domain.BlackFileVO;
import com.kobook.community.domain.BlackVO;

public interface BlackDAO {
	//blackInsert
	public void blackInsert(BlackVO vo) throws Exception;
	//blackAddAttach
	public void blackAddAttach(BlackFileVO fileVO) throws Exception;
	//blackMaxNum
	public int blackMaxNum() throws Exception;
	//blackGetAttach
	public List<String> blackGetAttach(Integer black_id) throws Exception;
	//blackDeleteAttach
	public void blackDeleteAttach(Integer black_id) throws Exception;
	//blackReplaceAttach
	public void blackReplaceAttach(BlackFileVO fileVO);
	
	
}
