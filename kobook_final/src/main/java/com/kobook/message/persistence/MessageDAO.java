package com.kobook.message.persistence;

import java.util.List;

import com.kobook.message.domain.MessageVO;

public interface MessageDAO {
	
	public void send(MessageVO vo) throws Exception;
	public List<MessageVO> messageList(int person_id) throws Exception;
	public List<MessageVO> newMessageList(int person_id) throws Exception;

}
