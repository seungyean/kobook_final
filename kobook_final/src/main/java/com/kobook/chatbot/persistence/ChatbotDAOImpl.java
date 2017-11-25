package com.kobook.chatbot.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kobook.chatbot.domain.ChatlogVO;

@Repository
public class ChatbotDAOImpl implements ChatbotDAO {

	@Inject
	private SqlSession session;
	
	private static String namespace = "com.kobook.mappers.chatbotMapper";
	
	@Override
	public void registerLog(ChatlogVO vo) throws Exception {
		session.insert(namespace  + ".registerLog", vo);
	}

	@Override
	public List<ChatlogVO> listLog(Integer person_id) throws Exception {
		return session.selectList(namespace + ".listLog", person_id);
	}

}
