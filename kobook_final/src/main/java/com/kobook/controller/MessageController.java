package com.kobook.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kobook.person.service.PersonService;
import com.kobook.alarm.domain.AlarmVO;
import com.kobook.alarm.service.AlarmService;
import com.kobook.message.DTO.MessageDTO;
import com.kobook.message.domain.MessageVO;
import com.kobook.message.service.MessageService;

@Controller
@RequestMapping("/message")
public class MessageController {
	
	@Inject
	private MessageService mService;

	@Inject
	private PersonService pService;
	
	@Inject
	private AlarmService alarmService;
	
	// 메시지 form창으로 이동
	@RequestMapping(value="/messageSend")
	public void messageSendPOST(HttpSession session) throws Exception{
		
	}
	
	// 메시지 전송
	@RequestMapping(value="/send", method=RequestMethod.POST)
	public String sendPOST(MessageDTO dto, HttpSession session) throws Exception {
		
		System.out.println(dto.toString());
		System.out.println("���� ��� id:" + pService.findPersonId(dto.getReceiver_email()));
		
		int receiver_id = pService.findPersonId(dto.getReceiver_email());
		
		// 존재하지 않는 유저일 경우 -1을 리턴
		if(receiver_id == -1){
			
			return "/message/sendFail";
			
		} else {
			
			MessageVO message = new MessageVO();
			
			message.setPerson_id(dto.getPerson_id());
			message.setReceiver_id(receiver_id);
			message.setMessage_content(dto.getMessage_content());
			
			mService.messageSend(message);
			
			
			// 쪽지 보낼시 새로운 알람에 등록 (아름)
			AlarmVO alarmVO = new AlarmVO();
			
			alarmVO.setAlarm_kind("Message");
			alarmVO.setAlarm_content("�� ������ �����Ͽ����ϴ�.");
			alarmVO.setPerson_id(receiver_id);
			
			alarmService.alarmMessage(alarmVO);
			
			
			return "/message/sendOk";
		}

	}
	
}
