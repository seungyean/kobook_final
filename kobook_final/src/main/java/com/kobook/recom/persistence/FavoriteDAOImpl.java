package com.kobook.recom.persistence;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kobook.recom.domain.FavoriteBookVO;
import com.kobook.recom.domain.FavoriteVO;

@Repository
public class FavoriteDAOImpl implements FavoriteDAO {

	@Inject
	private SqlSession session;
	
	private static String namespace = "com.kobook.mappers.recomMapper";
	
	@Override
	public List<FavoriteBookVO> getFavorite(int person_id) {
		System.out.println("dao - getfavorite");
		return session.selectList(namespace + ".getFavorite", person_id);
	}

	@Override
	public void deleteFavorite(FavoriteVO favorite) {
		System.out.println("dao - delete");
		session.delete(namespace + ".deleteFavorite", favorite);
	}

}
