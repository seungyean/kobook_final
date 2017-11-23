package com.kobook.recom.persistence;

import java.util.List;

import com.kobook.recom.domain.FavoriteBookVO;
import com.kobook.recom.domain.FavoriteVO;

public interface FavoriteDAO {

	public List<FavoriteBookVO> getFavorite(int person_id);
	public void deleteFavorite(FavoriteVO favorite);
}
