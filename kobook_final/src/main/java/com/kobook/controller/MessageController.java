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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kobook.login.service.PersonService;
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
	
	@RequestMapping(value="/messageSend", method=RequestMethod.GET)
	public void sendGET(@ModelAttribute("dto") MessageDTO dto, HttpSession session) throws Exception{
		
	}
	
	@RequestMapping(value="/messageSend", method=RequestMethod.POST)
	public String sendPOST(MessageDTO dto, HttpSession session, Model model) throws Exception {
		
		System.out.println("ÇöÀç id:" + pService.findPersonId(dto.getReceiver_email()));
		
		int receiver_id = pService.findPersonId(dto.getReceiver_email());
		
		if(receiver_id == -1){
			
			/*model.addAttribute("dto", dto);*/
			return "/message/sendFail";
			
		} else {
			
			MessageVO message = new MessageVO();
			
			message.setPerson_id(dto.getPerson_id());
			message.setReceiver_id(receiver_id);
			message.setMessage_content(dto.getMessage_content());
			
			mService.messageSend(message);
			
			return "redirect:/message/sendOk";
		}

	}
	
}
