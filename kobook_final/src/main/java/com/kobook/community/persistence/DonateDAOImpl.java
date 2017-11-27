package com.kobook.community.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kobook.book.domain.SearchCriteria;
import com.kobook.community.domain.DonateFileVO;
import com.kobook.community.domain.DonateVO;

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

}
