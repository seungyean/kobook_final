package com.kobook.community.service;

import java.util.List;

import com.kobook.book.domain.SearchCriteria;
import com.kobook.community.domain.DonateVO;
import com.kobook.community.domain.ReplyVO;

public interface DonateService {
	public void donateRegist(DonateVO vo) throws Exception;
	public List<DonateVO> donateList(SearchCriteria cri) throws Exception;
	public int donateCount(SearchCriteria cri) throws Exception;
	public List<String> donateGetAttach(Integer donate_id) throws Exception;
	public DonateVO donateRead(Integer donate_id, boolean bool) throws Exception;
	public void donateModify(DonateVO vo) throws Exception;
	public void donateRemove(Integer donate_id) throws Exception;
	public String donateWriter(Integer donate_id) throws Exception;
	public void donateReplyRegist(ReplyVO vo) throws Exception;
	public List<ReplyVO> donateReplyList(Integer donate_id) throws Exception;
	public String selectPersonName(Integer person_id, Integer donate_id) throws Exception;
	public void replyModify(ReplyVO vo) throws Exception;
	public void replyRemove(Integer reply_id) throws Exception;
	public void replyRemoveAll(Integer donate_id) throws Exception;
	public Integer getPersonId(Integer donate_id) throws Exception;
	public String getPersonName(Integer person_id) throws Exception;
	public String getDonateTitle(Integer donate_id) throws Exception;
}
