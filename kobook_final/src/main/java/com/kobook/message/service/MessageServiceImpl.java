package com.kobook.message.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kobook.message.domain.MessageVO;
import com.kobook.message.persistence.MessageDAO;

@Service
public class MessageServiceImpl implements MessageService {
	
	@Inject
	private MessageDAO dao; 

	@Override
	public void messageSend(MessageVO message) throws Exception {
		dao.send(message);
	}

}
