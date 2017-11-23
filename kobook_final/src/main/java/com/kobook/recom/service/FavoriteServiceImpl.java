package com.kobook.recom.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kobook.recom.domain.FavoriteBookVO;
import com.kobook.recom.persistence.FavoriteDAO;

@Service
public class FavoriteServiceImpl implements FavoriteService {

	@Inject
	private FavoriteDAO dao;
	
	@Override
	public List<FavoriteBookVO> getFavorite(int person_id) {
		System.out.println("service - getfavorite");
		return dao.getFavorite(person_id);
	}

	
}
