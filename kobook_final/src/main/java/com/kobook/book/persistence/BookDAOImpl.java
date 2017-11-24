package com.kobook.book.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kobook.book.domain.PickVO;
import com.kobook.book.domain.ReviewVO;
import com.kobook.book.domain.BookVO;
import com.kobook.book.domain.PersonDTO;
import com.kobook.book.domain.SearchCriteria;

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
	public List<BookVO> listCriteria(SearchCriteria cri) throws Exception {
		return session.selectList(namespace+".listCriteria",cri,new RowBounds(cri.getPageStart(),cri.getPerPageNum()));
	}

	
	
	@Override
	public List<BookVO> directListCriteria(SearchCriteria cri) throws Exception {
		return session.selectList(namespace+".directListCriteria",cri,new RowBounds(cri.getPageStart(),cri.getPerPageNum()));
	}




	@Override
	public List<BookVO> safeListCriteria(SearchCriteria cri) throws Exception {
		return session.selectList(namespace+".safeListCriteria",cri,new RowBounds(cri.getPageStart(),cri.getPerPageNum()));
	}

	

	@Override
	public PersonDTO readSellPerson(int person_id) throws Exception {
		return session.selectOne(namespace+".readSellPerson",person_id);
	}




	@Override
	public List<BookVO> sellPersonList(int person_id) throws Exception {
		return session.selectList(namespace+".sellPersonList", person_id);
	}

	@Override
	public int countPaging(SearchCriteria cri) throws Exception {
		return session.selectOne(namespace+".countPaging",cri);
	}

	@Override
	public BookVO read(Integer book_id) throws Exception {
		return session.selectOne(namespace+".read",book_id);
	}

	@Override
	public void update(BookVO vo) throws Exception {
		session.update(namespace+".update",vo);
		
	}

	@Override
	public void pick(PickVO pick) throws Exception {
		session.insert(namespace+".pickcreate",pick);
	}




	@Override
	public int getPersonIdByBookId(int book_id) throws Exception {
		return session.selectOne(namespace +".getPersonIdByBookId", book_id);
	}




	@Override
	public void reviewCreate(ReviewVO review) throws Exception {
		session.insert(namespace+".reviewCreate");
		
	}





	
	
	
	

}