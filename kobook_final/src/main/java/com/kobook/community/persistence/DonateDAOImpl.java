package com.kobook.community.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kobook.book.domain.SearchCriteria;
import com.kobook.community.domain.DonateFileVO;
import com.kobook.community.domain.DonateVO;
import com.kobook.community.domain.ReplyVO;

@Repository
public class DonateDAOImpl implements DonateDAO {
	
	@Inject
	private SqlSession session;
	
	private static String namespace="com.kobook.mappers.donateMapper";

	@Override
	public void donateInsert(DonateVO vo) throws Exception {
		session.insert(namespace+".donateInsert", vo);
	}

	@Override
	public void donateAddAttach(DonateFileVO fileVO) throws Exception {
		session.insert(namespace+".donateAddAttach", fileVO);
	}

	@Override
	public int donateMaxNum() throws Exception {
		return session.selectOne(namespace+".donateMaxNum");
	}

	@Override
	public List<DonateVO> donateList(SearchCriteria cri) throws Exception {
		return session.selectList(namespace+".donateList", cri,
				new RowBounds(cri.getPageStart(), cri.getPerPageNum()));
	}

	@Override
	public int donateCount(SearchCriteria cri) throws Exception {
		return session.selectOne(namespace+".donateCount", cri);
	}

	@Override
	public List<String> donateGetAttach(Integer donate_id) throws Exception {
		return session.selectList(namespace+".donateGetAttach", donate_id);
	}

	@Override
	public void donateDeleteAttach(Integer donate_id) throws Exception {
		session.delete(namespace+".donateDeleteAttach", donate_id);
	}

	@Override
	public void donateReplaceAttach(DonateFileVO fileVO) throws Exception {
		session.insert(namespace+".donateReplaceAttach", fileVO);
	}

	@Override
	public DonateVO donateSelect(Integer donate_id) throws Exception {
		return session.selectOne(namespace+".donateSelect", donate_id);
	}

	@Override
	public void donateUpdate(DonateVO vo) throws Exception {
		session.update(namespace+".donateUpdate", vo);
	}

	@Override
	public void donateDelete(Integer donate_id) throws Exception {
		session.delete(namespace+".donateDelete", donate_id);
	}

	@Override
	public int donateHitCount(Integer donate_id) throws Exception {
		return session.update(namespace+".donateHitCount", donate_id);
	}

	@Override
	public String donateWriter(Integer donate_id) throws Exception {
		return session.selectOne(namespace+".donateWriter", donate_id);
	}

	@Override
	public void donateReplyInsert(ReplyVO vo) throws Exception {
		session.insert(namespace+".donateReplyInsert", vo);
	}

	@Override
	public List<ReplyVO> donateReplyList(Integer donate_id) throws Exception {
		return session.selectList(namespace+".donateReplyList", donate_id);
	}

	@Override
	public String selectPersonName(Integer person_id, Integer donate_id) throws Exception {
		Map<String, Integer> paramMap = new HashMap<String, Integer>();
		paramMap.put("person_id", person_id);
		paramMap.put("donate_id", donate_id);
		return session.selectOne(namespace+".selectPersonName", paramMap);
	}

	@Override
	public void updateReplyCount(int amount, Integer donate_id) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("amount", amount);
		paramMap.put("donate_id", donate_id);
		
		session.update(namespace+".updateReplyCount", paramMap);
	}

	@Override
	public void replyUpdate(ReplyVO vo) throws Exception {
		session.update(namespace+".replyUpdate", vo);
	}

	@Override
	public void replyDelete(Integer reply_id) throws Exception {
		session.delete(namespace+".replyDelete", reply_id);
	}

	@Override
	public void replyDeleteAll(Integer donate_id) throws Exception {
		session.delete(namespace+".replyDeleteAll", donate_id);
	}

	@Override
	public Integer getDonateId(Integer reply_id) throws Exception {
		return session.selectOne(namespace+".getDonateId", reply_id);
	}

	@Override
	public int replyCount(Integer donate_id) throws Exception {
		return session.selectOne(namespace+".replyCount", donate_id);
	}

	@Override
	public Integer getPersonId(Integer donate_id) throws Exception {
		return session.selectOne(namespace+".getPersonId", donate_id);
	}

	@Override
	public String getPersonName(Integer person_id) throws Exception {
		return session.selectOne(namespace+".getPersonName", person_id);
	}

	@Override
	public String getDonateTitle(Integer donate_id) throws Exception {
		return session.selectOne(namespace+".getDonateTitle", donate_id);
	}

	@Override
	public String donatePreviewContent(Integer donate_id) throws Exception {
		return session.selectOne(namespace+".donatePreviewContent", donate_id);
	}

	@Override
	public Integer donatePrev(Integer donate_id) throws Exception {
		return session.selectOne(namespace+".donatePrev", donate_id);
	}

	@Override
	public Integer donateNext(Integer donate_id) throws Exception {
		return session.selectOne(namespace+".donateNext", donate_id);
	}

}
