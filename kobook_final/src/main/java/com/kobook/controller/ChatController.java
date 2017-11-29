package com.kobook.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kobook.chatbot.domain.ChatlogVO;
import com.kobook.chatbot.service.ChatbotService;

@RestController
@RequestMapping("/chat")
public class ChatController {
	
	@Inject
	private ChatbotService service;
	
	// ������ ä��â�� ���� �Է��ϸ� ���� ä�÷α׿� ���
	@RequestMapping(value="", method=RequestMethod.POST)
	public ResponseEntity<String> register(@RequestBody ChatlogVO vo) {
		
		ResponseEntity<String> entity = null;
		
		try {
			service.chatRegister(vo);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}

	// Ư�� ����ڰ� ä���ߴ� ��� ���(�����, ê��)���� �������� ���� ����
	@RequestMapping(value = "/{person_id}", method = RequestMethod.GET)
	public ResponseEntity<List<ChatlogVO>> listLog(@PathVariable("person_id") Integer person_id) {
		
		ResponseEntity<List<ChatlogVO>> entity = null;
		
		try {
			entity = new ResponseEntity<>(service.chatList(person_id), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	// ����ڰ� �������� �� ��ȭ�� ������ �ͼ� �ν� �� ó���ϴ� ���� ����
	@RequestMapping(value="/chatProcess", method=RequestMethod.POST)
	public ResponseEntity<String> chatProcess(@RequestBody ChatlogVO vo){
	
		ResponseEntity<String> entity = null;
		ChatlogVO newVo = new ChatlogVO();
		
		try {
			
			// ��ȭ��  �ν� �� ó���ϴ� ������ �����ϴ� ���� ȣ��
			newVo = service.chatResponse(vo);
			
			// ������ ���� �ֱ� ��ȭ�� ���� ���� ä�÷α׿� ���
			service.chatRegister(newVo);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}


}