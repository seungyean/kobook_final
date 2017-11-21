package com.kobook.controller;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kobook.mypage.persistence.MyPageDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class MyPageTest {
	
	@Inject
	private MyPageDAO dao;
	
	@Test
	public void sellListTest(){
		System.out.println(dao.sellList(4).toString());
	}

}
