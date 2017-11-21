package com.kobook.mypage.persistence;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kobook.book.domain.BookVO;


@Repository
public class MyPageDAOImpl implements MyPageDAO {
	
	@Inject
	private SqlSession session;
	
	private static String namespace = "com.kobook.mappers.myPageMapper";

	@Override
	public List<BookVO> sellList(int bno) {
		return session.selectList(namespace + ".sellList", bno);
	}

	@Override
	public void sellStateUpdate(BookVO vo) {
		session.update(namespace + ".sellStateUpdate", vo);
	
	}

	@Override
	public List<HashMap<String, String>> buyList(int bno) {
		return session.selectList(namespace + ".buyList", bno);
	}



}