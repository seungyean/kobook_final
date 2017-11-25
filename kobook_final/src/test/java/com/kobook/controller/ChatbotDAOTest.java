package com.kobook.controller;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kobook.chatbot.domain.ChatlogVO;
import com.kobook.chatbot.persistence.ChatbotDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class ChatbotDAOTest {

	private static Logger logger = LoggerFactory.getLogger(ChatbotDAOTest.class);

	@Inject
	private ChatbotDAO dao;
	
	/*@Test
	public void registerTest() throws Exception{
		
		ChatlogVO vo = new ChatlogVO();
		vo.setChatlog_content("chatvoTest2");
		vo.setChatlog_speaker("C");
		vo.setPerson_id(3);
		
		dao.registerLog(vo);
	}*/

}
