package com.kobook.message.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kobook.message.domain.MessageVO;

@Repository
public class MessageDAOImpl implements MessageDAO {
	
	@Inject
	private SqlSession session;
	
	private static String namespace = "com.kobook.mappers.messageMapper";

	@Override
	public void send(MessageVO vo) throws Exception {
		session.insert(namespace + ".send", vo);
	}

	@Override
	public List<MessageVO> messageList(int person_id) throws Exception {
		return session.selectList(namespace + ".getList", person_id);
	}

	@Override
	public List<MessageVO> newMessageList(int person_id) throws Exception {
		return session.selectList(namespace + ".getNewList", person_id);
	}
	
	
}
