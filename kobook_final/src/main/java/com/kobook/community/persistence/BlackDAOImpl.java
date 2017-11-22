package com.kobook.community.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kobook.book.domain.SearchCriteria;
import com.kobook.community.domain.BlackFileVO;
import com.kobook.community.domain.BlackVO;

@Repository
public class BlackDAOImpl implements BlackDAO {

	@Inject
	private SqlSession session;
	
	private static String namespace = "com.kobook.mappers.blackMapper";

	@Override
	public void blackInsert(BlackVO vo) throws Exception {
		session.insert(namespace+".blackInsert", vo);		
	}

	@Override
	public void blackAddAttach(BlackFileVO fileVO) throws Exception {
		session.insert(namespace+".blackAddAttach", fileVO);
		
	}

	@Override
	public int blackMaxNum() throws Exception {
		return session.selectOne(namespace+".blackMaxNum");
	}

	@Override
	public List<String> blackGetAttach(Integer black_id) throws Exception {
		return session.selectList(namespace+".blackGetAttach", black_id);
	}

	@Override
	public void blackDeleteAttach(Integer black_id) throws Exception {
		session.delete(namespace+".blackDeleteAttach", black_id);
	}

	@Override
	public void blackReplaceAttach(BlackFileVO fileVO) {
		session.insert(namespace+".blackReplaceAttach", fileVO);
	}

	@Override
	public List<BlackVO> blackList(SearchCriteria cri) throws Exception {
		return session.selectList(namespace+".blackList", cri,
				new RowBounds(cri.getPageStart(), cri.getPerPageNum()));
	}

	@Override
	public int blackCount(SearchCriteria cri) throws Exception {
		return session.selectOne(namespace+".blackCount", cri);
	}

	@Override
	public BlackVO blackRead(Integer black_id) throws Exception {
		return session.selectOne(namespace+".blackRead", black_id);
	}
	
}
