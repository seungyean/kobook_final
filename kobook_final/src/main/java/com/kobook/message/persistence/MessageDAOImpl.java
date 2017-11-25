package com.kobook.message.persistence;

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
	public void send(MessageVO message) throws Exception {
		session.insert(namespace + ".send", message);
	}
	

}
