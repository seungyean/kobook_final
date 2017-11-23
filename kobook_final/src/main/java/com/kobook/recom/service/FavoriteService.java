package com.kobook.recom.service;

import java.util.List;

import com.kobook.recom.domain.FavoriteBookVO;
import com.kobook.recom.domain.FavoriteVO;

public interface FavoriteService {

	public List<FavoriteBookVO> getFavorite(int person_id);
	public void deleteFavorite(FavoriteVO favorite);
}
