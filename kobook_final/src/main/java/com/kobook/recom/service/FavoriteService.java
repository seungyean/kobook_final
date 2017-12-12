package com.kobook.recom.service;

import java.util.List;

import com.kobook.recom.domain.FavoriteBookVO;
import com.kobook.recom.domain.FavoriteVO;
import com.kobook.recom.domain.RdataVO;

public interface FavoriteService {

	public List<FavoriteBookVO> getFavorite(int person_id);
	public void deleteFavorite(FavoriteVO favorite);
	public List<RdataVO> getRdata();
	public void updateFavoriteRank(FavoriteVO favorite);
	public List<RdataVO> getBigdata(int person_id);
	public List<String> favoriteList(int person_id) throws Exception;
}
