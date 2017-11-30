package com.kobook.community.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kobook.book.domain.SearchCriteria;
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
}
