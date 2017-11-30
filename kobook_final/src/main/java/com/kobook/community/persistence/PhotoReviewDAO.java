package com.kobook.community.persistence;

import com.kobook.community.domain.PhotoFileVO;
import com.kobook.community.domain.PhotoVO;

public interface PhotoReviewDAO {
	//photoInsert
	public void photoInsert(PhotoVO vo) throws Exception;
	//photoAddAttach
	public void photoAddAttach(PhotoFileVO fileVO) throws Exception;
	//photoMaxNum
	public int photoMaxNum() throws Exception;
}
