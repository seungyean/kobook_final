package com.kobook.controller;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kobook.message.domain.MessageVO;
import com.kobook.message.persistence.MessageDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class MessageDAOTest {
	
	@Inject
	private MessageDAO dao;

	@Test
	public void test() throws Exception {
		
		MessageVO vo = new MessageVO();
		vo.setMessage_content("test2");
		vo.setPerson_id(1);
		vo.setReceiver_id(2);
		dao.send(vo);
		System.out.println(vo);
	}

}
