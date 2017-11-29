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
		
		// user_content �м�
		if(user_text.contains("å")){
			vo.setChatlog_content("å�� ���� ����");
		} else if(user_text.contains("����")){
			vo.setChatlog_content("���� ���� ����");
		} else if(user_text.contains("��������")){
			vo.setChatlog_content("�Խ��� ���� ����");
		} else if(user_text.contains("���ϸ���")){
			vo.setChatlog_content("���������� ���� ����");
		} else {
			vo.setChatlog_content("�Ӿ�\n�ϰ͵�\n�ش�ȵ��ڳ�");
		}
		
		//computer�� ���� ������ setting
		vo.setChatlog_speaker("C");
		
		return vo;
	}
	
}
