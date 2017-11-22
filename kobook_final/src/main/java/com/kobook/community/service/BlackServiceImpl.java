package com.kobook.community.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
		
	}
	
	

}
