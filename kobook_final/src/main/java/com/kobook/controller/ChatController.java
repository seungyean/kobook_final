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
	
	// 유저가 대화창에 입력하고 전송시 채팅로그에 기록
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

	// 해당 유저에 대한 모든 채팅 기록을 가져옴
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
	
	// 유저의 마지막 답에 대한 인식과 처리를 동시에 진행
	@RequestMapping(value="/chatProcess", method=RequestMethod.POST)
	public ResponseEntity<String> chatProcess(@RequestBody ChatlogVO vo){
	
		ResponseEntity<String> entity = null;
		ChatlogVO newVo = new ChatlogVO();
		
		try {
			
			// 입력한 대화에 대한 컴퓨터의 응답을 새로운 객체에 저장
			newVo = service.chatResponse(vo);
			
			// 컴퓨터의 응답을 채팅 로그에 기록
			service.chatRegister(newVo);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}


}