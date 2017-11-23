package com.kobook.recom.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kobook.recom.domain.FavoriteBookVO;

@Service
public class FavoriteServiceImpl implements FavoriteService {

	@Override
	public List<FavoriteBookVO> getFavorite(int person_id) {
		System.out.println("service - getfavorite");
		return null;
	}

	
}
