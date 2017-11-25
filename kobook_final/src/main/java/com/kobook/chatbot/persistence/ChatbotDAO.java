package com.kobook.chatbot.persistence;

import java.util.List;

import com.kobook.chatbot.domain.ChatlogVO;

public interface ChatbotDAO {
	
	public void registerLog(ChatlogVO vo) throws Exception;
	public List<ChatlogVO> listLog(Integer person_id) throws Exception; 
	
}