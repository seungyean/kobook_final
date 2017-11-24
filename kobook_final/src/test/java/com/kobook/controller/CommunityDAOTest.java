package com.kobook.controller;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kobook.community.domain.BlackFileVO;
import com.kobook.community.domain.BlackVO;
import com.kobook.community.domain.DonateFileVO;
import com.kobook.community.domain.DonateVO;
import com.kobook.community.persistence.BlackDAO;
import com.kobook.community.persistence.DonateDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class CommunityDAOTest {

	@Inject
	private BlackDAO dao;
	@Inject
	private DonateDAO dDao;
	
	@Test
	public void test() throws Exception{
//		DonateVO vo = new DonateVO();
		DonateFileVO fileVO= new DonateFileVO();
//		
//		vo.setPerson_id(3);
//		vo.setDonate_content("donate_content");
//		vo.setDonate_title("donate_title");
//		
//		dDao.donateInsert(vo);
		int donate_id = dDao.donateMaxNum();
		fileVO.setDonate_id(donate_id);
		
			fileVO.setDonate_file_name("file.file");
			dDao.donateAddAttach(fileVO);
		
//		BlackVO vo = new BlackVO();
//		BlackFileVO fileVO = new BlackFileVO();
//		
//		vo.setPerson_id(3);
//		vo.setBlack_content("black_content");
//		vo.setBlack_email("black_email");
//		vo.setBlack_title("black_title");
//		
//		dao.blackInsert(vo);
//		int black_id = dao.blackMaxNum();
//		fileVO.setBlack_id(black_id);
//		String[] files = vo.getFiles();
//		System.out.println(vo.getFiles());
//		for(String black_file_name : files) {
//			fileVO.setBlack_file_name(black_file_name);
//			dao.blackAddAttach(fileVO);
//		}
	}

}
