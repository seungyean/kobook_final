package com.kobook.community.persistence;

import java.util.List;

import com.kobook.book.domain.SearchCriteria;
import com.kobook.community.domain.PhotoFileVO;
import com.kobook.community.domain.PhotoHeartVO;
import com.kobook.community.domain.PhotoVO;

public interface PhotoReviewDAO {
	//photoInsert
	public void photoInsert(PhotoVO vo) throws Exception;
	//photoAddAttach
	public void photoAddAttach(PhotoFileVO fileVO) throws Exception;
	//photoMaxNum
	public int photoMaxNum() throws Exception;
	//photoList
	public List<PhotoVO> photoList(SearchCriteria cri) throws Exception;
	//photoCount
	public int photoCount(SearchCriteria cri) throws Exception;
	//photoWriter
	public String photoWriter(Integer photo_id) throws Exception;
	//photoGetAttach
	public List<String> photoGetAttach(Integer photo_id) throws Exception;
	//photoDeleteAttach
	public void photoDeleteAttach(Integer photo_id) throws Exception;
	//photoReplaceAttach
	public void photoReplaceAttach(PhotoFileVO fileVO) throws Exception;
	//photoSelect
	public PhotoVO photoSelect(Integer photo_id) throws Exception;
	//photoHitCount
	public int photoHitCount(Integer photo_id) throws Exception;
	//photoUpdate
	public void photoUpdate(PhotoVO vo) throws Exception;
	//photoDelete
	public void photoDelete(Integer photo_id) throws Exception;
	//photoHeartUp
	public void photoHeartUp(Integer photo_id) throws Exception;
	//photoHeartDown
	public void photoHeartDown(Integer photo_id) throws Exception;
	//heartInsert
	public void heartInsert(PhotoHeartVO heartVO) throws Exception;
	//heartDelete
	public void heartDelete(Integer heart_id) throws Exception;
	//getPhotoId
	public int getPhotoId(Integer heart_id) throws Exception;
	//getHeartId
	public int getHeartId(int person_id, int photo_id) throws Exception;
	//photoPrev
	public Integer photoPrev(Integer photo_id) throws Exception;
	//photoNext
	public Integer photoNext(Integer photo_id) throws Exception;
}
