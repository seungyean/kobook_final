package com.kobook.community.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kobook.book.domain.SearchCriteria;
import com.kobook.community.domain.PhotoFileVO;
import com.kobook.community.domain.PhotoHeartVO;
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
				, new RowBounds(cri.getPageStart(), cri.getPerPageNum()));
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

	@Override
	public PhotoVO photoSelect(Integer photo_id) throws Exception {
		return session.selectOne(namespace+".photoSelect", photo_id);
	}

	@Override
	public int photoHitCount(Integer photo_id) throws Exception {
		return session.update(namespace+".photoHitCount", photo_id);
	}

	@Override
	public void photoUpdate(PhotoVO vo) throws Exception {
		session.update(namespace+".photoUpdate", vo);
	}

	@Override
	public void photoDelete(Integer photo_id) throws Exception {
		session.delete(namespace+".photoDelete", photo_id);
	}

	@Override
	public void photoHeartUp(Integer photo_id) throws Exception {
		session.update(namespace+".photoHeartUp", photo_id);
	}

	@Override
	public void photoHeartDown(Integer photo_id) throws Exception {
		session.update(namespace+".photoHeartDown", photo_id);
	}

	@Override
	public void heartInsert(PhotoHeartVO heartVO) throws Exception {
		session.insert(namespace+".heartInsert", heartVO);
	}

	@Override
	public void heartDelete(Integer heart_id) throws Exception {
		session.delete(namespace+".heartDelete", heart_id);
	}

	@Override
	public int getPhotoId(Integer heart_id) throws Exception {
		return session.selectOne(namespace+".getPhotoId", heart_id);
	}

	@Override
	public int getHeartId(int person_id, int photo_id) throws Exception {
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		paramMap.put("person_id", person_id);
		paramMap.put("photo_id", photo_id);
		
		return session.selectOne(namespace+".getHeartId", paramMap);
	}
}
