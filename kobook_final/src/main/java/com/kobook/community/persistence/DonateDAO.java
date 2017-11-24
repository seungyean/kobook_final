package com.kobook.community.persistence;

import com.kobook.community.domain.DonateFileVO;
import com.kobook.community.domain.DonateVO;

public interface DonateDAO {
	//donateInsert
	public void donateInsert(DonateVO vo) throws Exception;
	//donateAddAttach
	public void donateAddAttach(DonateFileVO fileVO) throws Exception;
	//donateMaxNum
	public int donateMaxNum() throws Exception;
}
