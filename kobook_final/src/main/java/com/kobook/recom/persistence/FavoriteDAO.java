package com.kobook.recom.persistence;

import java.util.List;

import com.kobook.recom.domain.FavoriteBookVO;

public interface FavoriteDAO {

	public List<FavoriteBookVO> getFavorite(int person_id);
}
