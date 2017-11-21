package com.kobook.message.service;

import com.kobook.message.domain.MessageVO;

public interface MessageService {
	
	public void messageSend(MessageVO message) throws Exception;

}
