package com.kobook.message.persistence;

import com.kobook.message.domain.MessageVO;

public interface MessageDAO {
	
	public void send(MessageVO message) throws Exception;

}
