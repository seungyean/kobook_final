package com.kobook.community.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kobook.book.domain.SearchCriteria;
import com.kobook.community.domain.PhotoFileVO;
import com.kobook.community.domain.PhotoHeartVO;
import com.kobook.community.domain.PhotoVO;
import com.kobook.community.persistence.PhotoReviewDAO;

@Service
public class PhotoReviewServiceImpl implements PhotoReviewService {
	
	@Inject
	private PhotoReviewDAO dao;

	@Transactional
	@Override
	public void photoRegist(PhotoVO vo) throws Exception {
		dao.photoInsert(vo);
		
		String[] files = vo.getFiles();
		int photo_id = dao.photoMaxNum();
		
		PhotoFileVO fileVO = new PhotoFileVO();
		fileVO.setPhoto_id(photo_id);
		
		if(files == null){return;}
		
		for(String photo_file_name : files) {
			fileVO.setPhoto_file_name(photo_file_name);
			dao.photoAddAttach(fileVO);
		}
	}

	@Override
	public List<PhotoVO> photoList(SearchCriteria cri) throws Exception {
		return dao.photoList(cri);
	}

	@Override
	public int photoCount(SearchCriteria cri) throws Exception {
		return dao.photoCount(cri);
	}

	@Override
	public String photoWriter(Integer photo_id) throws Exception {
		return dao.photoWriter(photo_id);
	}

	@Override
	public List<String> photoGetAttach(Integer photo_id) throws Exception {
		return dao.photoGetAttach(photo_id);
	}

	@Transactional
	@Override
	public PhotoVO photoReviewRead(Integer photo_id, boolean bool) throws Exception {
		if(bool){
			dao.photoHitCount(photo_id);
		}
		return dao.photoSelect(photo_id);
	}

	@Transactional
	@Override
	public void photoReviewModify(PhotoVO vo) throws Exception {
		dao.photoUpdate(vo);
		
		Integer photo_id = vo.getPhoto_id();
		dao.photoDeleteAttach(photo_id);
		
		PhotoFileVO fileVO = new PhotoFileVO();
		
		fileVO.setPhoto_id(photo_id);
		
		String[] files = vo.getFiles();
		
		for(String photo_file_name : files) {
			fileVO.setPhoto_file_name(photo_file_name);
			dao.photoReplaceAttach(fileVO);
		}
		
	}

	@Transactional
	@Override
	public void photoReviewRemove(Integer photo_id) throws Exception {
		dao.photoDeleteAttach(photo_id);
		dao.photoDelete(photo_id);
	}

	@Transactional
	@Override
	public void heartInsert(PhotoHeartVO heartVO) throws Exception {
		dao.heartInsert(heartVO);
		dao.photoHeartUp(heartVO.getPhoto_id());
	}

	@Transactional
	@Override
	public void heartDelete(Integer heart_id) throws Exception {
		Integer photo_id = dao.getPhotoId(heart_id);
		dao.heartDelete(heart_id);
		dao.photoHeartDown(photo_id);
	}

	@Override
	public int getHeartId(int person_id, int photo_id) throws Exception {
		return dao.getHeartId(person_id, photo_id);
	}

	@Override
	public Integer photoPrev(Integer photo_id) throws Exception {
		return dao.photoPrev(photo_id);
	}

	@Override
	public Integer photoNext(Integer photo_id) throws Exception {
		return dao.photoNext(photo_id);
	}
}
