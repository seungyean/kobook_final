package com.kobook.mypage.persistence;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kobook.book.domain.BookVO;
import com.kobook.message.DTO.MessageDTO;
import com.kobook.message.domain.MessageVO;
import com.kobook.mypage.domain.DeliveryVO;
import com.kobook.mypage.domain.MileageVO;
import com.kobook.mypage.domain.MyPageCriteria;
import com.kobook.mypage.domain.OrderVO;
import com.kobook.mypage.domain.PayVO;
import com.kobook.person.domain.PersonVO;


@Repository
public class MyPageDAOImpl implements MyPageDAO {
	
	@Inject
	private SqlSession session;
	
	private static String namespace = "com.kobook.mappers.myPageMapper";

	@Override
	public List<BookVO> sellList(int person_id) throws Exception {
		return session.selectList(namespace + ".sellList", person_id);
	}

	@Override
	public void sellStateUpdate(BookVO vo) throws Exception {
		session.update(namespace + ".sellStateUpdate", vo);
	
	}

	@Override
	public List<HashMap<String, String>> buyList(MyPageCriteria cri) throws Exception {
		return session.selectList(namespace + ".buyList",  cri, new RowBounds(cri.getPageStart(), cri.getPerPageNum()));
	}

	@Override
	public List<HashMap<String, String>> pickList(int person_id) throws Exception {
		return session.selectList(namespace + ".pickList", person_id);
	}

	@Override
	public void pickUpdate(int pick_id) throws Exception {
		 session.selectOne(namespace + ".pickUpdate", pick_id);
	}

	@Override
	public List<HashMap<String, String>> mileageList(int person_id) throws Exception {
		return session.selectList(namespace + ".mileageList",  person_id);
	}

	@Override
	public PersonVO orderPerson(int person_id) throws Exception {
		return session.selectOne(namespace + ".orderPerson", person_id);
	}

	@Override
	public void orderInsert(OrderVO vo) throws Exception {
		session.insert(namespace + ".orderInsert", vo);
		
	}

	@Override
	public BookVO oneBook(int book_id) throws Exception {
		return session.selectOne(namespace + ".oneBook", book_id);
	}

	@Override
	public int mileageInsert(MileageVO vo) throws Exception{
		return session.insert(namespace + ".mileageInsert", vo);
	}

	@Override
	public void mileageMinus(MileageVO vo) throws Exception {
		session.update(namespace + ".mileageMinus", vo);
		
	}

	@Override
	public void payInsert(PayVO vo) throws Exception {
		session.insert(namespace + ".payInsert", vo);
		
	}

	@Override
	public int maxOrderID(int order_id) throws Exception{
		return session.selectOne(namespace + ".maxOrderID", order_id);
	}

	@Override
	public void deliveryInsert(DeliveryVO vo)throws Exception {
		session.insert(namespace + ".deliveryInsert", vo);
		
	}

	@Override
	public int maxPayID(int pay_id) throws Exception{
		return session.selectOne(namespace + ".maxPayID", pay_id);
	}

	@Override
	public int mileageTotal(int person_id) throws Exception{
		return session.selectOne(namespace + ".mileageTotal", person_id);
	}

	@Override
	public int mileageUse(int person_id) throws Exception{
		return session.selectOne(namespace + ".mileageUse", person_id);
	}

	@Override
	public List<MessageVO> receivedMsgTotal(int receiver_id) throws Exception{
		return  session.selectList(namespace + ".receivedMsgTotal", receiver_id);
	}

	@Override
	public void msgUpdate(int message_id)throws Exception {
		session.selectOne(namespace+".msgUpdate", message_id);
		
	}





}
