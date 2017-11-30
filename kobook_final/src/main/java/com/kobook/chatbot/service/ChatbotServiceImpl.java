package com.kobook.chatbot.service;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kobook.alarm.persistence.AlarmDAO;
import com.kobook.chatbot.domain.ChatlogVO;
import com.kobook.chatbot.persistence.ChatbotDAO;
import com.kobook.message.domain.MessageVO;
import com.kobook.message.persistence.MessageDAO;
import com.kobook.person.persistence.PersonDAO;

@Service
public class ChatbotServiceImpl implements ChatbotService {

	@Inject
	private ChatbotDAO chatbotDao;
	
	@Inject
	private MessageDAO messageDao;
	
	@Inject
	private PersonDAO personDao;
	
	@Inject
	private AlarmDAO alarmDao;
	
	

	@Override
	public void chatRegister(ChatlogVO vo) throws Exception {
		chatbotDao.registerLog(vo);
	}

	@Override
	public List<ChatlogVO> chatList(Integer person_id) throws Exception {
		return chatbotDao.listLog(person_id);
	}

	@Override
	public ChatlogVO chatResponse(ChatlogVO vo) throws Exception {
		
		String text = vo.getChatlog_content();
		int person_id = vo.getPerson_id();
		
		String newText = "";
		
		// user_text 판별
		if(text.contains("책") || text.contains("도서") || text.contains("상품")){
			newText = "책 관련 ㄱㄱ";
		} else if(text.contains("쪽지")){
			newText = manageMessage(text, person_id);
//			newText = "쪽지 관련 그리고 ㅇㅏ이디는" + person_id;
		} else if(text.contains("마일리지")){
			newText = "마일리지 관련 ㄱㄱ";
		} else if(text.contains("마이페이지")){
			newText = "마이페이지 관련 ㄱㄱ";
		} else {
			newText = "응\n그런거\n말구";
		}
		
		vo.setChatlog_content(newText);
		//computer의 speaker의 값 setting
		vo.setChatlog_speaker("C");
		
		return vo;
	}

	@Override
	public String manageBook(String text, int person_id) throws Exception {
		String newText = "";
		if(text.contains("최근") || text.contains("등록")){	//최근 등록된 책 보여줘
			
		} else if(text.contains("내가") || text.contains("등록")){ //내가 등록한 책 보여줘
			
		} else if(text.contains("관련") || text.contains("관한")){		//종류 관한 책보여줘
			
		}
		
		return newText;
	}

	@Override
	public String manageBoard(String text, int person_id) throws Exception {
		String newText = "";
		if(text.contains("공지사항")){
			
		} else if(text.contains("포토리뷰")){
			
		} else if(text.contains("블랙")){
			
		} else if(text.contains("무료나눔")){
			
		}	
		
		return newText;
	}

	@Override
	public String manageMypage(String text, int person_id) throws Exception {
		String newText = "";
		if(text.contains("적립금") || text.contains("마일리지")){	// 내 마일리지 보여줘 
			
		} else if(text.contains("관심분야")){
			
		} 
		
		return newText;
	}

	@Override
	public String manageMessage(String text, int person_id) throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yy-MM-dd");
		
		String newText = "";
		List<MessageVO> list = null;
		
		
		newText += "(최신의 쪽지가 상단에 표시됩니다)\n\n";
		newText += "&nbsp;보낸 사람 &nbsp;&nbsp;&nbsp; 내용 &nbsp;&nbsp;&nbsp; 보낸날짜";
		
		if(text.contains("새") || text.contains("새로운") || text.contains("새로온") || text.contains("새로 온")){		// 새 쪽지 보여줘
			if(messageDao.newMessageList(person_id) != null){
				list = messageDao.newMessageList(person_id);
				
				for(MessageVO m : list){
					newText += "\n" + "* " + personDao.findPersonName(m.getPerson_id()) + "&nbsp; &nbsp; &nbsp;" + m.getMessage_content() + "&nbsp; &nbsp; &nbsp;" + dateFormat.format(m.getMessage_date());
				}	
			}
			
		} else if(text.contains("보관함") || text.contains("쪽지함")){	// 내 쪽지함 보여줘
			if(messageDao.messageList(person_id) != null){
				list = messageDao.messageList(person_id);
				
				for(MessageVO m : list){
					newText += "\n" + "* " + personDao.findPersonName(m.getPerson_id()) + "&nbsp; &nbsp; &nbsp;" + m.getMessage_content() + "&nbsp; &nbsp; &nbsp;" + dateFormat.format(m.getMessage_date());
				}
			}
		}
		
		// 쪽지를 조회함과 동시에 쪽지 알림도 0으로 됨 
		
		
		return newText;
	}
	
}
