package com.kobook.book.persistence;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kobook.book.domain.DateDTO;
import com.kobook.book.domain.DeliveryDTO;
import com.kobook.book.domain.SearchCriteria;
@Repository
public class DeliveryDAOImpl implements DeliveryDAO {

	@Inject
	private SqlSession session;
	
	private static String namespace
	="com.kobook.mappers.deliveryMapper";
	
	@Override
	public List<HashMap<String, String>> deliveryList(SearchCriteria cri){
		return session.selectList(namespace + ".deliveryList",cri,new RowBounds(cri.getPageStart(),cri.getPerPageNum()));
	}

	@Override
	public int countdelList() throws Exception {
		return session.selectOne(namespace+".countdelList");
	}

	@Override
	public List<DeliveryDTO> selectDateList(DateDTO dto) throws Exception {
		return session.selectList(namespace+".selectDateList",dto);
	}
	
	@Override
	public int wpercent() throws Exception {
	return session.selectOne(namespace+".wpercent");
	}

	@Override
	public int ipercent() throws Exception {
		return session.selectOne(namespace+".ipercent");
	}

	@Override
	public int cpercent() throws Exception {
		return session.selectOne(namespace+".cpercent");
	}


	@Override
	public int month(int m) throws Exception {
		return session.selectOne(namespace+".month",m);
	}




	@Override
	public int todayMoney() throws Exception {
		return session.selectOne(namespace+".todayMoney");
	}


	@Override
	public void delstateUpdate(DeliveryDTO dto) throws Exception {
		session.update(namespace+".delstateUpdate",dto);
		
	}

}
