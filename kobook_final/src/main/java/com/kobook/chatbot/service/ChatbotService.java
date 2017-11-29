package com.kobook.chatbot.service;

import java.util.List;

import com.kobook.chatbot.domain.ChatlogVO;

public interface ChatbotService {
	
	public void chatRegister(ChatlogVO vo) throws Exception;
	public List<ChatlogVO> chatList(Integer person_id) throws Exception;
	public ChatlogVO chatResponse(ChatlogVO vo) throws Exception;

}
