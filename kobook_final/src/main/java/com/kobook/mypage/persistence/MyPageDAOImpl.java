package com.kobook.mypage.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kobook.domain.book.BookVO;

@Repository
public class MyPageDAOImpl implements MyPageDAO {
	
	@Inject
	private SqlSession session;
	
	private static String namespace = "com.kobook.mappers.myPageMapper";

	@Override
	public List<BookVO> sellList(int bno) {
		return session.selectList(namespace + ".sellList", bno);
	}

}
