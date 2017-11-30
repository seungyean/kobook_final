package com.kobook.community.service;

import java.util.List;

import com.kobook.book.domain.SearchCriteria;
import com.kobook.community.domain.PhotoVO;

public interface PhotoReviewService {
	public void photoRegist(PhotoVO vo) throws Exception;
	public List<PhotoVO> photoList(SearchCriteria cri) throws Exception;
	public int photoCount(SearchCriteria cri) throws Exception;
	public String photoWriter(Integer photo_id) throws Exception;
	public List<String> photoGetAttach(Integer photo_id) throws Exception;
}
