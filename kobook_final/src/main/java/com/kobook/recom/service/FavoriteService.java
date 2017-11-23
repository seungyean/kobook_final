package com.kobook.recom.service;

import java.util.List;

import com.kobook.recom.domain.FavoriteBookVO;

public interface FavoriteService {

	public List<FavoriteBookVO> getFavorite(int person_id);
}
