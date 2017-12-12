package com.kobook.controller;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kobook.recom.domain.FavoriteBookVO;
import com.kobook.recom.domain.FavoriteVO;
import com.kobook.recom.persistence.FavoriteDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class RecomDAOTest {

	private static Logger logger = LoggerFactory.getLogger(RecomDAOTest.class);
	
	@Inject
	private FavoriteDAO dao;
	
/*	@Test
	public void favoriteTest() {
		int person_id = 4;
		dao.getFavorite(person_id);
	}*/
	
/*	@Test
	public void favoriteDeleteTest() {
		
		FavoriteVO favorite = new FavoriteVO();
		favorite.setBook_id(1);
		favorite.setFavorite_id(1);
		favorite.setFavorite_major("M");
		favorite.setFavorite_name("test");
		favorite.setFavorite_rank(10);
		favorite.setPerson_id(4);
		
		dao.deleteFavorite(favorite);
	}*/
	
	
	@Test
	public void favoriteUpdateTest() {
		
		FavoriteVO favorite = new FavoriteVO();
		favorite.setBook_id(1);
		favorite.setFavorite_id(1);
		favorite.setFavorite_major("M");
		favorite.setFavorite_name("test");
		favorite.setFavorite_rank(10);
		favorite.setPerson_id(4);
		
		dao.updateFavoriteRank(favorite);
	}

	
}
