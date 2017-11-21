package com.kobook.persistence.message;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kobook.domain.message.MessageVO;

@Repository
public class MessageDAOImpl implements MessageDAO {
	
	@Inject
	private SqlSession session;
	
	private static String namespace = "com.kobook.mappers.messageMapper";

	@Override
	public void messageSend(MessageVO message) throws Exception {
		session.insert(namespace + ".send", message);
	}

}
