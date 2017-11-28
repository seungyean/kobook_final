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
	
	// 유저가 채팅창에 글을 입력하면 먼저 채팅로그에 등록
	@RequestMapping(value="", method=RequestMethod.POST)
	public ResponseEntity<String> register(@RequestBody ChatlogVO vo) {
		
		ResponseEntity<String> entity = null;
		
		try {
			service.registerLog(vo);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}

	// 특정 사용자가 채팅했던 모든 기록(사용자, 챗봇)들을 가져오는 것을 관장
	@RequestMapping(value = "/{person_id}", method = RequestMethod.GET)
	public ResponseEntity<List<ChatlogVO>> listLog(@PathVariable("person_id") Integer person_id) {
		
		ResponseEntity<List<ChatlogVO>> entity = null;
		
		try {
			entity = new ResponseEntity<>(service.listLog(person_id), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@RequestMapping(value="/chatProcess", method=RequestMethod.POST)
	public ResponseEntity<String> chatProcess(@RequestBody ChatlogVO vo){
	
		ResponseEntity<String> entity = null;
		
		vo.setChatlog_speaker("C");
		if(vo.getChatlog_content().equals("난 잘생김")){
			vo.setChatlog_content("꺼져맨");
		} else if(vo.getChatlog_content().equals("꺄륵")){
			vo.setChatlog_content("노잼");
		} else {
			vo.setChatlog_content("응");
		}
		
		
		// 유저의 가장 최근 대화에 대한 답을 채팅로그에 등록
		try {
			service.registerLog(vo);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}


}