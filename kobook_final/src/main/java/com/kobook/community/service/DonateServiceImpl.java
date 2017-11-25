package com.kobook.community.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kobook.book.domain.SearchCriteria;
import com.kobook.community.domain.DonateFileVO;
import com.kobook.community.domain.DonateVO;
import com.kobook.community.persistence.DonateDAO;

@Service
public class DonateServiceImpl implements DonateService {
	
	@Inject
	private DonateDAO dao;

	@Transactional
	@Override
	public void donateRegist(DonateVO vo) throws Exception {
		dao.donateInsert(vo);
		
		String[] files = vo.getFiles();
		int donate_id = dao.donateMaxNum();
		
		DonateFileVO fileVO = new DonateFileVO();
		fileVO.setDonate_id(donate_id);
		if(files == null) { return; }
		for(String donate_file_name : files) {
			fileVO.setDonate_file_name(donate_file_name);
			dao.donateAddAttach(fileVO);
		}
		
	}

	@Override
	public List<DonateVO> donateList(SearchCriteria cri) throws Exception {
		return dao.donateList(cri);
	}

	@Override
	public int donateCount(SearchCriteria cri) throws Exception {
		return dao.donateCount(cri);
	}

	@Override
	public List<String> donateGetAttach(Integer donate_id) throws Exception {
		return dao.donateGetAttach(donate_id);
	}

	@Override
	public DonateVO donateRead(Integer donate_id) throws Exception {
		return dao.donateSelect(donate_id);
	}

}
