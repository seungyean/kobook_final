package com.kobook.chatbot.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kobook.chatbot.domain.ChatlogVO;
import com.kobook.chatbot.persistence.ChatbotDAO;

@Service
public class ChatbotServiceImpl implements ChatbotService {

	@Inject
	private ChatbotDAO dao;

	@Override
	public void registerLog(ChatlogVO vo) throws Exception {
		dao.registerLog(vo);
		
	}

	@Override
	public List<ChatlogVO> listLog(Integer person_id) throws Exception {
		return dao.listLog(person_id);
	}
	
	
}
