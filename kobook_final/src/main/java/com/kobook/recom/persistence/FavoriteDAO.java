package com.kobook.recom.persistence;

import java.util.List;

import com.kobook.recom.domain.FavoriteBookVO;
import com.kobook.recom.domain.FavoriteVO;
import com.kobook.recom.domain.RdataVO;

public interface FavoriteDAO {

	public List<FavoriteBookVO> getFavorite(int person_id);
	public void deleteFavorite(FavoriteVO favorite);
	public List<RdataVO> getRdata();
	public void updateFavoriteRank(FavoriteVO favorite);
	public List<String> favoriteList(int person_id) throws Exception;
	public List<RdataVO> getBigdata(int person_id);
}
