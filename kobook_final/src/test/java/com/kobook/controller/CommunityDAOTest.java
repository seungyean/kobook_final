package com.kobook.controller;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kobook.community.domain.BlackVO;
import com.kobook.community.persistence.BlackDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class CommunityDAOTest {

	@Inject
	private BlackDAO dao;
	
	@Test
	public void test() throws Exception{
		BlackVO vo = new BlackVO();
		vo.setBlack_title("black_title");
		vo.setBlack_content("black_content");
		vo.setBlack_email("black_email");
		vo.setPerson_id(2);
		dao.blackInsert(vo);
	}

}
