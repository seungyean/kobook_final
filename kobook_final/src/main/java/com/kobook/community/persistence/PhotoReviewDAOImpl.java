package com.kobook.community.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kobook.book.domain.SearchCriteria;
import com.kobook.community.domain.PhotoFileVO;
import com.kobook.community.domain.PhotoVO;

@Repository
public class PhotoReviewDAOImpl implements PhotoReviewDAO {
	
	@Inject
	private SqlSession session;
	
	private static String namespace="com.kobook.mappers.photoMapper";

	@Override
	public void photoInsert(PhotoVO vo) throws Exception {
		session.insert(namespace+".photoInsert", vo);
	}

	@Override
	public void photoAddAttach(PhotoFileVO fileVO) throws Exception {
		session.insert(namespace+".photoAddAttach", fileVO);
	}

	@Override
	public int photoMaxNum() throws Exception {
		return session.selectOne(namespace+".photoMaxNum");
	}

	@Override
	public List<PhotoVO> photoList(SearchCriteria cri) throws Exception {
		return session.selectList(namespace+".photoList", cri
				, new RowBounds(cri.getPage(), cri.getPerPageNum()));
	}

	@Override
	public int photoCount(SearchCriteria cri) throws Exception {
		return session.selectOne(namespace+".photoCount", cri);
	}

	@Override
	public String photoWriter(Integer photo_id) throws Exception {
		return session.selectOne(namespace+".photoWriter", photo_id);
	}

	@Override
	public List<String> photoGetAttach(Integer photo_id) throws Exception {
		return session.selectList(namespace+".photoGetAttach", photo_id);
	}

	@Override
	public void photoDeleteAttach(Integer photo_id) throws Exception {
		session.delete(namespace+".photoDeleteAttach", photo_id);
	}

	@Override
	public void photoReplaceAttach(PhotoFileVO fileVO) throws Exception {
		session.insert(namespace+".photoReplaceAttach", fileVO);
	}
}
