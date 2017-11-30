package com.kobook.recom.persistence;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kobook.recom.domain.FavoriteBookVO;
import com.kobook.recom.domain.FavoriteVO;
import com.kobook.recom.domain.RdataVO;

@Repository
public class FavoriteDAOImpl implements FavoriteDAO {

	@Inject
	private SqlSession session;
	
	private static String namespace = "com.kobook.mappers.recomMapper";
	
	@Override
	public List<FavoriteBookVO> getFavorite(int person_id) {
		return session.selectList(namespace + ".getFavorite", person_id);
	}

	@Override
	public void deleteFavorite(FavoriteVO favorite) {
		session.delete(namespace + ".deleteFavorite", favorite);
	}

	@Override
	public List<RdataVO> getRdata() {
		return session.selectList(namespace + ".getRdata");
	}

	@Override
	public void updateFavoriteRank(FavoriteVO favorite) {
		session.update(namespace + ".updateFavoriteRank", favorite);
		
	}
}
