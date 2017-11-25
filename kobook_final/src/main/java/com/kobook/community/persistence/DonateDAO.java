package com.kobook.community.persistence;

import java.util.List;

import com.kobook.book.domain.SearchCriteria;
import com.kobook.community.domain.DonateFileVO;
import com.kobook.community.domain.DonateVO;

public interface DonateDAO {
	//donateInsert
	public void donateInsert(DonateVO vo) throws Exception;
	//donateAddAttach
	public void donateAddAttach(DonateFileVO fileVO) throws Exception;
	//donateMaxNum
	public int donateMaxNum() throws Exception;
	//donateList
	public List<DonateVO> donateList(SearchCriteria cri) throws Exception; 
	//donateCount
	public int donateCount(SearchCriteria cri) throws Exception;
	//donateGetAttach
	public List<String> donateGetAttach(Integer donate_id) throws Exception;
	//donateDeleteAttach
	public void donateDeleteAttach(Integer donate_id) throws Exception;
	//donateReplaceAttach
	public void donateReplaceAttach(DonateFileVO fileVO) throws Exception;
}