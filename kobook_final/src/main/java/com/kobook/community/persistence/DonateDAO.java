package com.kobook.community.persistence;

import java.util.List;

import com.kobook.book.domain.SearchCriteria;
import com.kobook.community.domain.DonateFileVO;
import com.kobook.community.domain.DonateVO;
import com.kobook.community.domain.ReplyVO;

public interface DonateDAO {
	//donateInsert
	public void donateInsert(DonateVO vo) throws Exception;
	//donateAddAttach
	public void donateAddAttach(DonateFileVO fileVO) throws Exception;
	//donateMaxNum
	public int donateMaxNum() throws Exception;
	//donateList
	public List<DonateVO> donateList(SearchCriteria cri) throws Exception; 
	//donateCount
	public int donateCount(SearchCriteria cri) throws Exception;
	//donateGetAttach
	public List<String> donateGetAttach(Integer donate_id) throws Exception;
	//donateDeleteAttach
	public void donateDeleteAttach(Integer donate_id) throws Exception;
	//donateReplaceAttach
	public void donateReplaceAttach(DonateFileVO fileVO) throws Exception;
	//donateSelect
	public DonateVO donateSelect(Integer donate_id) throws Exception;
	//donateUpdate
	public void donateUpdate(DonateVO vo) throws Exception;
	//donateDelete
	public void donateDelete(Integer donate_id) throws Exception;
	//donateHitCount
	public int donateHitCount(Integer donate_id) throws Exception;
	//donateWriter
	public String donateWriter(Integer donate_id) throws Exception;
	//donateReplyInsert
	public void donateReplyInsert(ReplyVO vo) throws Exception;
	//donateReplyList
	public List<ReplyVO> donateReplyList(Integer donate_id) throws Exception;
	//selectPersonName
	public String selectPersonName(Integer person_id, Integer donate_id) throws Exception;
	//updateReplyCount
	public void updateReplyCount(int amount, Integer donate_id) throws Exception;
	//replyUpdate
	public void replyUpdate(ReplyVO vo) throws Exception;
	//replyDelete
	public void replyDelete(Integer reply_id) throws Exception;
	//replyDeleteAll
	public void replyDeleteAll(Integer donte_id) throws Exception;
	//getDonateId
	public Integer getDonateId(Integer reply_id) throws Exception;
}
