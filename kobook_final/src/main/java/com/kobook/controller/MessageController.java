package com.kobook.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kobook.login.service.PersonService;
import com.kobook.message.domain.MessageVO;
import com.kobook.message.service.MessageService;

@Controller
@RequestMapping("/message")
public class MessageController {
	
	@Inject
	private MessageService mService;

	@Inject
	private PersonService pService;
	
	
	public String messageSend(MessageVO message, RedirectAttributes rttr) throws Exception{
		
		return "";
	}
	
}
