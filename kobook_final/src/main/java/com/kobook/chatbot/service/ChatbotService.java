package com.kobook.chatbot.service;

import java.util.List;

import com.kobook.chatbot.domain.ChatlogVO;

public interface ChatbotService {
	
	public void registerLog(ChatlogVO chatlog) throws Exception;
	public List<ChatlogVO> listLog(int person_id) throws Exception;

}
