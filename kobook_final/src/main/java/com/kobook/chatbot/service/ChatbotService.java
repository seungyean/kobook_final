package com.kobook.chatbot.service;

import java.util.List;

import com.kobook.chatbot.domain.ChatlogVO;

public interface ChatbotService {
	
	public void chatRegister(ChatlogVO vo) throws Exception;
	public List<ChatlogVO> chatList(Integer person_id) throws Exception;
	public ChatlogVO chatResponse(ChatlogVO vo) throws Exception;
	public String manageBook(String text, int person_id) throws Exception;
	public String manageBoard(String text, int person_id) throws Exception;
	public String manageMypage(String text, int person_id) throws Exception;
	public String manageMessage(String text, int person_id) throws Exception;
	
	
	public String boardNameReplace(String text);
	public String keyWordReplace(String text);
}
