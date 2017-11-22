package com.kobook.controller;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kobook.board.domain.BoardVO;
import com.kobook.board.persistence.BoardDAO;
import com.kobook.book.domain.Criteria;
import com.kobook.book.domain.SearchCriteria;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class BoardDAOTest {
	
	private static Logger logger = LoggerFactory.getLogger(BoardDAOTest.class);

	@Inject
	private BoardDAO dao;
	
/*	@Test
	public void test()throws Exception {
		
		BoardVO vo = new BoardVO();
		
		vo.setBoard_content("货肺款 臂郴侩");
		vo.setBoard_title("货肺款 力格");
		vo.setBoard_writer("货肺款 累己磊");
		
		dao.insertBoard(vo);
		
		System.out.println(vo);
	}*/
	
/*	@Test
	public void testCriteria()throws Exception {
		Criteria cri = new Criteria();
		cri.setPage(1);
		cri.setPerPageNum(20);
		
		List<BoardVO> list = dao.listCriteria(cri);
		
		for(BoardVO boardVO : list) {
			logger.info(boardVO.getBoard_content() + ":" + boardVO.getBoard_title());
		}
	}*/
	
	
	
}
