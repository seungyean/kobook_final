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
	public void registerLog(ChatlogVO chatlog) throws Exception {
		session.insert(namespace  + ".registerLog", chatlog);
	}

	@Override
	public List<ChatlogVO> listLog(int person_id) throws Exception {
		return session.selectOne(namespace + ".listLog", person_id);
	}

}
