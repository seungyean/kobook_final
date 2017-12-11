package com.kobook.community.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kobook.book.domain.SearchCriteria;
import com.kobook.community.domain.DonateFileVO;
import com.kobook.community.domain.DonateVO;
import com.kobook.community.domain.ReplyVO;
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

	@Transactional
	@Override
	public DonateVO donateRead(Integer donate_id, boolean bool) throws Exception {
		if(bool) {
			dao.donateHitCount(donate_id);
		}
		return dao.donateSelect(donate_id);
	}

	@Transactional
	@Override
	public void donateModify(DonateVO vo) throws Exception {
		dao.donateUpdate(vo);
		
		Integer donate_id = vo.getDonate_id();
		dao.donateDeleteAttach(donate_id);
		
		DonateFileVO fileVO = new DonateFileVO();
		
		fileVO.setDonate_id(donate_id);
		
		String[] files = vo.getFiles();
		
		if(files == null){return;}
		
		for(String donate_file_name : files) {
			fileVO.setDonate_file_name(donate_file_name);
			dao.donateReplaceAttach(fileVO);
		}
	}

	@Transactional
	@Override
	public void donateRemove(Integer donate_id) throws Exception {		
		int replyCnt = dao.replyCount(donate_id);
		
		if(replyCnt > 0) {
			dao.replyDeleteAll(donate_id);
		}

		dao.donateDeleteAttach(donate_id);
		dao.donateDelete(donate_id);
	}

	@Override
	public String donateWriter(Integer donate_id) throws Exception {
		return dao.donateWriter(donate_id);
	}

	@Transactional
	@Override
	public void donateReplyRegist(ReplyVO vo) throws Exception {
		dao.donateReplyInsert(vo);
		dao.updateReplyCount(1, vo.getDonate_id());
	}

	@Override
	public List<ReplyVO> donateReplyList(Integer donate_id) throws Exception {
		return dao.donateReplyList(donate_id);
	}

	@Override
	public String selectPersonName(Integer person_id, Integer donate_id) throws Exception {
		return dao.selectPersonName(person_id, donate_id);
	}

	@Override
	public void replyModify(ReplyVO vo) throws Exception {
		dao.replyUpdate(vo);
	}

	@Transactional
	@Override
	public void replyRemove(Integer reply_id) throws Exception {
		Integer donate_id = dao.getDonateId(reply_id);
		dao.replyDelete(reply_id);
		dao.updateReplyCount(-1, donate_id);
	}

	@Override
	public void replyRemoveAll(Integer donate_id) throws Exception {
		dao.replyDeleteAll(donate_id);
	}

	@Override
	public Integer getPersonId(Integer donate_id) throws Exception {
		return dao.getPersonId(donate_id);
	}

	@Override
	public String getPersonName(Integer person_id) throws Exception {
		return dao.getPersonName(person_id);
	}

	@Override
	public String getDonateTitle(Integer donate_id) throws Exception {
		return dao.getDonateTitle(donate_id);
	}

	@Override
	public String donatePreviewContent(Integer donate_id) throws Exception {
		return dao.donatePreviewContent(donate_id);
	}

	@Override
	public Integer donatePrev(Integer donate_id) throws Exception {
		return dao.donatePrev(donate_id);
	}

	@Override
	public Integer donateNext(Integer donate_id) throws Exception {
		return dao.donateNext(donate_id);
	}

}
