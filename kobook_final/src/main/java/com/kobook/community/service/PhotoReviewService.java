package com.kobook.community.service;

import java.util.List;

import com.kobook.book.domain.SearchCriteria;
import com.kobook.community.domain.PhotoHeartVO;
import com.kobook.community.domain.PhotoVO;

public interface PhotoReviewService {
	public void photoRegist(PhotoVO vo) throws Exception;
	public List<PhotoVO> photoList(SearchCriteria cri) throws Exception;
	public int photoCount(SearchCriteria cri) throws Exception;
	public String photoWriter(Integer photo_id) throws Exception;
	public List<String> photoGetAttach(Integer photo_id) throws Exception;
	public PhotoVO photoReviewRead(Integer photo_id, boolean bool) throws Exception;
	public void photoReviewModify(PhotoVO vo) throws Exception;
	public void photoReviewRemove(Integer photo_id) throws Exception;
	public void heartInsert(PhotoHeartVO heartVO) throws Exception;
	public void heartDelete(Integer heart_id) throws Exception;
	public int getHeartId(int person_id, int photo_id) throws Exception;
}
