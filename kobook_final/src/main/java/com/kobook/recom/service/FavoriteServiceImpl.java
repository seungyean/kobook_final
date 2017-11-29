package com.kobook.recom.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kobook.recom.domain.FavoriteBookVO;
import com.kobook.recom.domain.FavoriteVO;
import com.kobook.recom.domain.RdataVO;
import com.kobook.recom.persistence.FavoriteDAO;

@Service
public class FavoriteServiceImpl implements FavoriteService {

	@Inject
	private FavoriteDAO dao;
	
	@Override
	public List<FavoriteBookVO> getFavorite(int person_id) {
		return dao.getFavorite(person_id);
	}

	@Override
	public void deleteFavorite(FavoriteVO favorite) {
		dao.deleteFavorite(favorite);
	}

	@Override
	public List<RdataVO> getRdata() {

		double rdata_support = 0;
		List<RdataVO> r_data = new ArrayList<RdataVO>();
		
		r_data = dao.getRdata();

		for (int i = 0; i < r_data.size(); i++) {
			rdata_support = dao.getRdata().get(i).getRdata_support();
			r_data.get(i).setRdata_support(rdata_support*100);
		}
		
		return r_data;
	}

	
}
