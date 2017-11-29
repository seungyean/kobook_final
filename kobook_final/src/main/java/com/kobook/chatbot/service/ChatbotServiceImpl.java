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
	public void chatRegister(ChatlogVO vo) throws Exception {
		dao.registerLog(vo);
	}

	@Override
	public List<ChatlogVO> chatList(Integer person_id) throws Exception {
		return dao.listLog(person_id);
	}

	@Override
	public ChatlogVO chatResponse(ChatlogVO vo) throws Exception {
		
		String user_text = vo.getChatlog_content();
		
		// user_content 분석
		if(user_text.contains("책")){
			vo.setChatlog_content("책에 관련 ㄱㄱ");
		} else if(user_text.contains("쪽지")){
			vo.setChatlog_content("쪽지 관련 ㄱㄱ");
		} else if(user_text.contains("공지사항")){
			vo.setChatlog_content("게시판 관련 ㄱㄱ");
		} else if(user_text.contains("마일리지")){
			vo.setChatlog_content("마이페이지 관련 ㄱㄱ");
		} else {
			vo.setChatlog_content("머야\n암것도\n해당안되자나");
		}
		
		//computer가 보낸 것으로 setting
		vo.setChatlog_speaker("C");
		
		return vo;
	}
	
}
