package com.kobook.community.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

}
