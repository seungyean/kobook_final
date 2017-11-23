package com.kobook.recom.persistence;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.kobook.recom.domain.FavoriteBookVO;

@Repository
public class FavoriteDAOImpl implements FavoriteDAO {

	@Override
	public List<FavoriteBookVO> getFavorite(int person_id) {
		System.out.println("dao - getfavorite");
		return null;
	}

	
}
