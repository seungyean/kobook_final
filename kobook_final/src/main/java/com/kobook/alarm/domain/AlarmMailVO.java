package com.kobook.alarm.domain;

import java.io.File;

import javax.inject.Inject;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.kobook.person.persistence.PersonDAO;
import com.kobook.person.service.PersonService;

@Component
public class AlarmMailVO {

	
	private String person_name;
	private String alarm_kind;
	private String alarm_content;
	
	public AlarmMailVO(){}
	
	public AlarmMailVO(String person_name, String alarm_kind, String alarm_content) {
		super();
		this.person_name = person_name;
		this.alarm_kind = alarm_kind;
		this.alarm_content = alarm_content;
	}
	
	public String getPerson_name() {
		return person_name;
	}
	public void setPerson_name(String person_name) {
		this.person_name = person_name;
	}
	public String getAlarm_kind() {
		return alarm_kind;
	}
	public void setAlarm_kind(String alarm_kind) {
		this.alarm_kind = alarm_kind;
	}
	public String getAlarm_content() {
		return alarm_content;
	}
	public void setAlarm_content(String alarm_content) {
		this.alarm_content = alarm_content;
	}
	
	
	public void sendMail(AlarmVO alarmVO,JavaMailSender mailSender,PersonService service) throws Exception {
		
		
		
		String setfrom = "dkfma93703@gmail.com";         
	    String tomail  = service.findPersonEmail(alarmVO.getPerson_id());
	    String title   = "[KOBOOK] 새로운 알림이 도착하였습니다.";

	    String htmlText = "<p><img src='cid:logo' /></p>"
	    		+ "<h1>"
	    		+ service.findPersonName(alarmVO.getPerson_id())
	    		+ "님, </h1>"
	    		+ "<h3>새로운 알림이 도착했습니다.</h3>"
	    		+ "<h3 style='margin-left: 30px;'>- "
	    		+ alarmVO.getAlarm_kind() + " : " + alarmVO.getAlarm_content()
	    		+ "</h3>"
	    		+ "<p><img src='cid:line' /></p>"
	    		+ "<br>"
	    		+ "<a href='https://www.naver.com' style='font-size: 15px;'> 확인하러 가기  >> </a>"
	    		+ "<br>"
	    		+ "<br>"
	    		+ "<br>";
	   		
	    
	    
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper messageHelper 
                          = new MimeMessageHelper(message, true, "UTF-8");
        
        messageHelper.setText(alarmVO.getAlarm_content(), true);
        messageHelper.setText(alarmVO.getAlarm_content(), htmlText);
        
        FileSystemResource file = new FileSystemResource(new File("/kobook_final//resources/img/logo.PNG"));
        //messageHelper.addInline("logo", file);	
        
        FileSystemResource file2 = new FileSystemResource(new File("/resources/img//line.PNG"));
        //messageHelper.addInline("line", file2);	
        
 
        messageHelper.setFrom(setfrom);  // 보내는사람 생략하거나 하면 정상작동을 안함
        messageHelper.setTo(tomail);     // 받는사람 이메일
        messageHelper.setSubject(title); // 메일제목은 생략이 가능하다
        
        mailSender.send(message);
	    
/*	    try {
	        MimeMessage message = mailSender.createMimeMessage();
	        MimeMessageHelper messageHelper 
	                          = new MimeMessageHelper(message, true, "UTF-8");
	        
	        messageHelper.setText(alarmVO.getAlarm_content(), true);
	        messageHelper.setText(alarmVO.getAlarm_content(), htmlText);
	        
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
	    }*/
	}
	
}
