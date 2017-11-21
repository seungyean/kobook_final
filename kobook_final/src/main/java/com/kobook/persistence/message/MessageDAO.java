package com.kobook.persistence.message;

import com.kobook.domain.message.MessageVO;

public interface MessageDAO {
	
	public void messageSend(MessageVO message) throws Exception;

}
