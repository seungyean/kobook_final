package com.kobook.community.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kobook.book.domain.SearchCriteria;
import com.kobook.community.domain.BlackFileVO;
import com.kobook.community.domain.BlackVO;
import com.kobook.community.persistence.BlackDAO;

@Service
public class BlackServiceImpl implements BlackService {
	
	@Inject
	private BlackDAO dao;

	@Transactional
	@Override
	public void blackRegist(BlackVO vo) throws Exception {
		dao.blackInsert(vo);
		String[] files = vo.getFiles();
		int black_id = dao.blackMaxNum();
		
		BlackFileVO fileVO = new BlackFileVO();
		fileVO.setBlack_id(black_id);
		if(files == null){
			return;
		}
		for(String black_file_name : files) {
			fileVO.setBlack_file_name(black_file_name);
			dao.blackAddAttach(fileVO);
		}
	}

	@Override
	public List<String> blackGetAttach(Integer black_id) throws Exception {
		return dao.blackGetAttach(black_id);
	}

	@Override
	public List<BlackVO> blackList(SearchCriteria cri) throws Exception {
		return dao.blackList(cri);
	}

	@Override
	public int blackCount(SearchCriteria cri) throws Exception {
		return dao.blackCount(cri);
	}

	@Override
	public BlackVO blackRead(Integer black_id) throws Exception {
		return dao.blackSelect(black_id);
	}

	@Transactional
	@Override
	public void blackModify(BlackVO vo) throws Exception {
		dao.blackUpdate(vo);
		
		Integer black_id = vo.getBlack_id();
		dao.blackDeleteAttach(black_id);
		
		BlackFileVO fileVO = new BlackFileVO();
		fileVO.setBlack_id(black_id);
		
		String[] files = vo.getFiles();
		
		if(files == null) {
			return;
		}
		
		for(String black_file_name : files) {
			fileVO.setBlack_file_name(black_file_name);
			dao.blackReplaceAttach(fileVO);
		}
		
	}

	@Transactional
	@Override
	public void blackRemove(Integer black_id) throws Exception {
		dao.blackDeleteAttach(black_id);
		dao.blackDelete(black_id);
	}

	@Override
	public String blackWriter(Integer black_id) throws Exception {
		return dao.blackWriter(black_id);
	}

	@Override
	public String blackPreviewContent(Integer black_id) throws Exception {
		return dao.blackPreviewContent(black_id);
	}
	
	

}
