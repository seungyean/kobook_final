package com.kobook.book.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kobook.book.domain.PickVO;
import com.kobook.book.domain.RankingVO;
import com.kobook.book.domain.ReviewVO;
import com.kobook.book.domain.BookVO;
import com.kobook.book.domain.DateDTO;
import com.kobook.book.domain.DeliveryDTO;
import com.kobook.book.domain.PersonDTO;
import com.kobook.book.domain.SearchCriteria;
import com.kobook.mypage.domain.DeliveryVO;
import com.kobook.person.domain.PersonVO;

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
	public List<BookVO> sellPersonList(int person_id,int book_id) throws Exception {
		Map<String, Object>hmap=new HashMap<String, Object>();
		hmap.put("person_id", person_id);
		hmap.put("book_id", book_id);
		return session.selectList(namespace+".sellPersonList", hmap);
	}

	@Override
	public List<ReviewVO> reviewList(int person_id,SearchCriteria cri) throws Exception {
		Map<String, Object>hmap=new HashMap<String,Object>();
		hmap.put("person_id", person_id);
		hmap.put("cri", cri);
		return session.selectList(namespace+".reviewList",hmap,new RowBounds(cri.getPageStart(),5));
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
		session.insert(namespace+".reviewCreate",review);
	}

	@Override
	public int countReview(int person_id) throws Exception {
		return session.selectOne(namespace+".countReview",person_id);
	}


	@Override
	public int countStar(int person_id) throws Exception {

		
		int a = session.selectOne(namespace+".countStar",person_id);
		System.out.println("dao"+a);
		return a;
	}

	@Override
	public int fivestar(int person_id) throws Exception {
		return session.selectOne(namespace+".fivestar",person_id);
	}

	@Override
	public int fourstar(int person_id) throws Exception {
		return session.selectOne(namespace+".fourstar",person_id);
	}


	@Override
	public int threestar(int person_id) throws Exception {
		return session.selectOne(namespace+".threestar",person_id);
	}


	@Override
	public int twostar(int person_id) throws Exception {
		return session.selectOne(namespace+".twostar",person_id);
	}

	@Override
	public int onestar(int person_id) throws Exception {
		return session.selectOne(namespace+".onestar",person_id);
	}


	@Override
	public void registerkeyword(SearchCriteria cri) throws Exception {
	session.insert(namespace+".registerkeyword",cri);
		
	}

	@Override
	public List<RankingVO> rankingList() throws Exception {
		return session.selectList(namespace+".rankingList");
	}




	@Override
	public int directListCount() throws Exception {
		return session.selectOne(namespace+".directListCount");
	}


	@Override
	public int safeListCount() throws Exception {
		return session.selectOne(namespace+".safeListCount");
	}

	// 챗봇용
	@Override
	public String getNameById(int book_id) throws Exception {
		return session.selectOne(namespace + ".getNameById", book_id);
	}

	@Override
	public List<BookVO> getMyBookList(int person_id) throws Exception {
		return session.selectList(namespace + ".getMyBookList", person_id);
	}
	
	
	
	
	




	
	

	
	
	

	


	
	
	
	

}