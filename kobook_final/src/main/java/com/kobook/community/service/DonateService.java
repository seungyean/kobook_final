package com.kobook.community.service;

import java.util.List;

import com.kobook.book.domain.SearchCriteria;
import com.kobook.community.domain.DonateVO;

public interface DonateService {
	public void donateRegist(DonateVO vo) throws Exception;
	public List<DonateVO> donateList(SearchCriteria cri) throws Exception;
	public int donateCount(SearchCriteria cri) throws Exception;
	public List<String> donateGetAttach(Integer donate_id) throws Exception;
	public DonateVO donateRead(Integer donate_id) throws Exception;
}
