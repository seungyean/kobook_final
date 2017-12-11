package com.kobook.community.persistence;

import java.util.List;

import com.kobook.book.domain.SearchCriteria;
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
	//blackList
	public List<BlackVO> blackList(SearchCriteria cri) throws Exception;
	//blackCount
	public int blackCount(SearchCriteria cri) throws Exception;
	//blackSelect
	public BlackVO blackSelect(Integer black_id) throws Exception;
	//blackUpdate
	public void blackUpdate(BlackVO vo) throws Exception;
	//blackDelete
	public void blackDelete(Integer black_id) throws Exception;
	//blackWriter
	public String blackWriter(Integer black_id) throws Exception;
	//blackPreviewContent
	public String blackPreviewContent(Integer black_id) throws Exception;
	
}
