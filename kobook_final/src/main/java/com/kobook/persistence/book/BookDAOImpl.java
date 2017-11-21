package com.kobook.persistence.book;

import javax.inject.Inject;


import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kobook.domain.book.BookVO;
import com.kobook.domain.book.FileVO;

@Repository
public class BookDAOImpl implements BookDAO {

	@Inject
	private SqlSession session;
	
	private static String namespace
	="com.kobook.mappers.bookMapper";
	
	@Override
	public void create(BookVO vo) throws Exception {
		session.insert(namespace+".create",vo);
	}
	
	@Override
	public int getBno() throws Exception {
		return session.selectOne(namespace+".maxNum");
	}

	@Override
	public void addAttach(FileVO fileVO) throws Exception {
		session.insert(namespace+".addAttach",fileVO);
	}
	
	
	

}
