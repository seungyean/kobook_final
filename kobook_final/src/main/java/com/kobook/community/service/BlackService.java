package com.kobook.community.service;

import java.util.List;

import com.kobook.book.domain.SearchCriteria;
import com.kobook.community.domain.BlackVO;

public interface BlackService {
	public void blackRegist(BlackVO vo) throws Exception;
	public List<BlackVO> blackList(SearchCriteria cri) throws Exception;
	public int blackCount(SearchCriteria cri) throws Exception;
	public List<String> blackGetAttach(Integer black_id) throws Exception;
	public BlackVO blackRead(Integer black_id) throws Exception;
	public void blackModify(BlackVO vo) throws Exception;
	public void blackRemove(Integer black_id) throws Exception;
	public String blackWriter(Integer black_id) throws Exception;
	public String blackPreviewContent(Integer black_id) throws Exception;
}
