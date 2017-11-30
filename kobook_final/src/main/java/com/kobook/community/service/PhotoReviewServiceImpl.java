package com.kobook.community.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kobook.community.domain.PhotoFileVO;
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
}
