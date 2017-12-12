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
	private DonateDAO dDao;	
	@Test
	public void donateRegistTest() throws Exception{
		DonateVO vo = new DonateVO();
		DonateFileVO fileVO= new DonateFileVO();
		
		vo.setPerson_id(3);
		vo.setDonate_content("donate_content");
		vo.setDonate_title("donate_title");
		
		dDao.donateInsert(vo);
		int donate_id = dDao.donateMaxNum();
		fileVO.setDonate_id(donate_id);
		
			fileVO.setDonate_file_name("file.file");
			dDao.donateAddAttach(fileVO);
	}
}

