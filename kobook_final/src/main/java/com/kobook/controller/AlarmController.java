package com.kobook.controller;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.inject.Inject;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.kobook.alarm.domain.AlarmVO;
import com.kobook.alarm.service.AlarmService;


@Controller
public class AlarmController {

/*	@Autowired
	private JavaMailSender mailSender;*/
	
	@Inject
	private AlarmService service;
	
	@RequestMapping(value="/alarmList", method=RequestMethod.GET)
	public String alarmView(HttpServletRequest request) throws Exception {
		System.out.println("controller - view");
		
		HttpSession session = request.getSession();
		int person_id = Integer.parseInt((String)session.getAttribute("person_id"));
		
		List<AlarmVO> alarmList = service.alarmListService(person_id);
		request.setAttribute("alarmList", alarmList);
		
		return "/person/alarm";
	}
	
	@RequestMapping(value="/alarmUpdate", method=RequestMethod.GET)
	public String alarmUpdate(HttpServletRequest request, RedirectAttributes rttr) throws Exception {
		System.out.println("controller - update");
		
		HttpSession session = request.getSession();
		int person_id = Integer.parseInt((String)session.getAttribute("person_id"));
		
		List<AlarmVO> alarmList = service.alarmListService(person_id);
		rttr.addFlashAttribute("alarmList", alarmList);
		
		service.alarmUpdateService(person_id);
		
		return "redirect:/recom";
	}

	
	/*여기부터 알림이 메일로 가기 위한 컨트롤러
	
	
	  // mailForm
	  @RequestMapping(value = "/mail/mailForm")
	  public String mailForm() {
	   
	    return "/mail/mailForm";
	  }  
	
	  // mailSending 코드
	  @RequestMapping(value = "/mail/mailSending")
	  public String mailSending(HttpServletRequest request) throws UnsupportedEncodingException, MessagingException {
	   
	    String setfrom = "dkfma93703@gmail.com";         
	    String tomail  = request.getParameter("tomail");     // 받는 사람 이메일
	    String title   = request.getParameter("title");      // 제목
	    //String content = request.getParameter("content");    // 내용
	    String content = "";
	    
	    title = new String(title.getBytes("8859_1"), "UTF-8");
	    content = new String(content.getBytes("8859_1"), "UTF-8");

	    String htmlText = "<p><img src='cid:logo' /></p>"
	    		+ "<h1>정아름님, </h1>"
	    		+ "<h3>새로운 알림이 도착했습니다.</h3>"
	    		+ "<h3 style='margin-left: 30px;'>- Message : 새로운 쪽지가 도착했습니다.</h3>"
	    		+ "<p><img src='cid:line' /></p>"
	    		+ "<br>"
	    		+ "<a href='https://www.naver.com' style='font-size: 15px;'> 확인하러 가기  >> </a>"
	    		+ "<br>"
	    		+ "<br>"
	    		+ "<br>";
	   		
	    
	    try {
	        MimeMessage message = mailSender.createMimeMessage();
	        MimeMessageHelper messageHelper 
	                          = new MimeMessageHelper(message, true, "UTF-8");
	        
	        messageHelper.setText(content, true);
	        messageHelper.setText(content, htmlText);
	        
	        FileSystemResource file = new FileSystemResource(new File("C:/Users/Areum Jung/Documents/logo.PNG"));
	        messageHelper.addInline("logo", file);	
	        
	        FileSystemResource file2 = new FileSystemResource(new File("C:/Users/Areum Jung/Documents/line.PNG"));
	        messageHelper.addInline("line", file2);	
	        
	 
	        messageHelper.setFrom(setfrom);  // 보내는사람 생략하거나 하면 정상작동을 안함
	        messageHelper.setTo(tomail);     // 받는사람 이메일
	        messageHelper.setSubject(title); // 메일제목은 생략이 가능하다

	      mailSender.send(message);
	    } catch(Exception e){
	      System.out.println(e);
	    }
	   
	    return "redirect:/mail/mailForm";
	  }*/
}
