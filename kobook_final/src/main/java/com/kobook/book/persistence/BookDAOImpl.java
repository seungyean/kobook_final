package com.kobook.book.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kobook.book.domain.BookVO;
import com.kobook.book.domain.BookFileVO;
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
	public int getBno() throws Exception {
		return session.selectOne(namespace+".maxNum");
	}

	
	
	@Override
	public List<BookVO> listCriteria(SearchCriteria cri) throws Exception {
		return session.selectList(namespace+".listCriteria",cri,new RowBounds(cri.getPageStart(),cri.getPerPageNum()));
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
	public void addAttach(BookFileVO fileVO) throws Exception {
		session.insert(namespace+".addAttach",fileVO);
	}

	@Override
	public void deleteAttach(Integer book_id) throws Exception {
		session.delete(namespace+".deleteAttach",book_id);
		
	}

	@Override
	public void replaceAttach(String book_file_name, Integer book_id) throws Exception {
	Map<String, Object>paramMap=new HashMap<String, Object>();
	
	paramMap.put("book_id", book_id);
	paramMap.put("book_file_name", book_file_name);
	session.insert(namespace+".replaceAttach",paramMap);
	}
	
	

	
	


	
	
	
	

}