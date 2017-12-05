package com.kobook.chatbot.service;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.kobook.alarm.persistence.AlarmDAO;
import com.kobook.board.domain.BoardVO;
import com.kobook.board.persistence.BoardDAO;
import com.kobook.book.domain.BookVO;
import com.kobook.book.domain.SearchCriteria;
import com.kobook.book.persistence.BookDAO;
import com.kobook.chatbot.domain.ChatlogVO;
import com.kobook.chatbot.persistence.ChatbotDAO;
import com.kobook.community.domain.BlackVO;
import com.kobook.community.domain.DonateVO;
import com.kobook.community.domain.PhotoVO;
import com.kobook.community.persistence.BlackDAO;
import com.kobook.community.persistence.DonateDAO;
import com.kobook.community.persistence.PhotoReviewDAO;
import com.kobook.message.domain.MessageVO;
import com.kobook.message.persistence.MessageDAO;
import com.kobook.mypage.persistence.MyPageDAO;
import com.kobook.person.persistence.PersonDAO;
import com.kobook.recom.persistence.FavoriteDAO;
import com.sun.media.jfxmedia.logging.Logger;

@Service
public class ChatbotServiceImpl implements ChatbotService {

	@Inject
	private AlarmDAO alarmDao;
	
	@Inject
	private BlackDAO blackDao;
	
	@Inject
	private BoardDAO boardDao;
	
	@Inject
	private BookDAO bookDao;
	
	@Inject
	private ChatbotDAO chatbotDao;

	@Inject
	private DonateDAO donateDao;
	
	@Inject
	private FavoriteDAO favDao;
	
	@Inject
	private MyPageDAO mypageDao;
	
	@Inject
	private MessageDAO messageDao;
	
	@Inject
	private PersonDAO personDao;
	
	@Inject
	private PhotoReviewDAO photoDao;
	

	@Override
	public void chatRegister(ChatlogVO vo) throws Exception {
		chatbotDao.registerLog(vo);
	}

	@Override
	public List<ChatlogVO> chatList(Integer person_id) throws Exception {
		return chatbotDao.listLog(person_id);
	}

	// 사용자가 마지막으로 입력한 문장을 분석 및 처리
	@Override
	public ChatlogVO chatResponse(ChatlogVO vo) throws Exception {
		
		String text = vo.getChatlog_content();
		int person_id = vo.getPerson_id();
		
		String newText = "";
		
		// user_text 판별
		if(text.equals("야") || text.contains("도와줘") || text.contains("도움")){
			
			newText += personDao.findPersonName(person_id) + "님, 오셨군요!"
					+ "\n 무엇을 도와드릴까요??"
					+ "\n 카테고리는 크게"
					+ "\n &nbsp; 1. 책(도서) "
					+ "\n &nbsp; 2. 게시판(공지, 포토, 무료나눔, 블랙)"
					+ "\n &nbsp; 3. 쪽지"
					+ "\n &nbsp; 4. 마이페이지"
					+ "\n 로 구성되어있습니다."
					+ "\n 카테고리명 + 도움말을 입력하시면 가능한 질문들을 보실 수 있습니다.";
		
		} else if(text.contains("쪽지")){	
			
			newText = manageMessage(text, person_id);
			
			
			// 쪽지 파트
		} else if(text.contains("책") || text.contains("도서") || text.contains("상품")){
			
//			newText = manageBook(text, person_id);
			newText = "책은 좀 나중에 준비해드릴게요";
			
			// 책 파트
		} else if(text.contains("마일리지") || text.contains("관심")){	//	마이페이지 파트

			newText = manageMypage(text, person_id);
		
			
			// 게시판 파트
		} else if(text.contains("공지") || text.contains("블랙") || text.contains("포토") || text.contains("무료나눔")){
			
//			newText = "게시판 관련 ㄱㄱ";
			newText = manageBoard(text, person_id);
			
			// 카테고리에 벗어난 키워드 입력
		} else {
			
			newText = "카테고리 내에서 질문해 주시겠어요??";
		}
		
		vo.setChatlog_content(newText);
		//computer가 대답하는 것으로 값 setting
		vo.setChatlog_speaker("C");
		
		return vo;
	}

	// 책 관련 사항
	@Override
	public String manageBook(String text, int person_id) throws Exception {
		String newText = "";
		List<BookVO> list = null;
		
		if(text.contains("최근") && text.contains("등록")){	//최근 등록된 책 보여줘
			
			// 좀 나중에....
			
			/*list = bookDao.getRecentList();
			
			if(list.size() == 0){
				newText += "최근 3일간 등록된 책이 없습니다.";
			} else if(list.size() > 3){
				for(int i=0; i<3; i++){
					newText += "\n * " + list.get(i).getBook_name();
				}
				newText += "\n &nbsp; \n <a href='#'>더보기</a>";
			} else {
				for(int i=0; i<list.size(); i++){
					newText += "\n * " + list.get(i).getBook_name();
				}
			}*/
			
			
		} else if(text.contains("내가") && text.contains("등록")){ //내가 등록한 책 보여줘
			list = bookDao.getMyBookList(person_id);
			System.out.println("내가 등록한책 리스트 크기: " + list.size());
			if(list.size() == 0){
				newText += personDao.findPersonName(person_id) + "님이 등록한 책이 없습니다.";
			} else if(list.size() > 3){
				
				for(int i=0; i<3; i++){
					newText += "\n * " + list.get(i).getBook_name();
				}
				
				newText += "\n &nbsp; \n <a href='#'>더보기</a>";
			} else {
				
				for(int i=0; i<list.size(); i++){
					newText += "\n * " + list.get(i).getBook_name();
				}
			}
			
		} else if(text.contains("모든")){
			
			// select book_name 
			
		} else if(text.contains("관련") || text.contains("관한")){	 //종류 관한 책보여줘
			
		} else {
			newText += "책에 대해서 다시 질문해주시겠어요?";
		}
		
		return newText;
	}

	
	// 게시판 관련 사항
	@Override
	public String manageBoard(String text, int person_id) throws Exception {
		String newText = "검색 결과는 제목+내용에서 검색된 결과이며 최대 5개까지 보여드립니다. \n";
		List<?> list = null;
		SearchCriteria cri = new SearchCriteria();
		
		Pattern bPattern = Pattern.compile("^공지|^포토|^블랙|^무료나눔");
		Matcher bMatcher = bPattern.matcher(text);
		String boardName = null;
		
		while(bMatcher.find()){
			boardName = boardNameReplace(bMatcher.group());
			
			if(boardName != null){
				System.out.println("boardname 추출 ::" + boardName);
			}
		}
		
		String rawKeyword = text.substring(text.indexOf(" ")+1);
		String keyword = null;
		System.out.println("rawkeyword 추출 ::" + rawKeyword);
		
		keyword = keyWordReplace(rawKeyword);
		
		System.out.println("keyword 추출 ::" + keyword);
		
		if(boardName.contains("공지")){
			System.out.println("공지사항 진입");
	
			cri.setSearchType("tc");
			cri.setKeyword(keyword);
			list = boardDao.boardListCri(cri);
			System.out.println("photolist 크기: "+list.size());
			
			if(list.size() < 1){
				newText += "찿으시는 결과가 없습니다. 다시 검색해주세요";
			}
			else {
				newText += "<b>"+list.size() + "</b>" + "개의 결과가 검색되었습니다.<hr>";
				newText += "<공지사항 게시판 글제목>";
				
				if(list.size() > 5){
					for(int i=0; i<5; i++){
						newText += "\n * " + ((BoardVO)list.get(i)).getBoard_title();
					}
					
					newText += "\n &nbsp;";
					newText += "\n <a href='#'>더보기</a>";
				} else {
					for(int i=0; i<list.size(); i++){
						newText += "\n * " + ((BoardVO)list.get(i)).getBoard_title();
					}
				}
			}
			
		} else if(boardName.contains("포토")){
			System.out.println("포토리뷰 진입");
			
			cri.setSearchType("tc");
			cri.setKeyword(keyword);
			list = photoDao.photoList(cri);
			System.out.println("photolist 크기: "+list.size());
			
			if(list.size() < 1){
				newText += "찿으시는 결과가 없습니다. 다시 검색해주세요";
			} else{
				newText += "<b>"+list.size() + "</b>" + "개의 결과가 검색되었습니다.<hr>";
				newText += "<포토리뷰리스트 게시판 글제목>";

				if(list.size() > 5){
					for(int i=0; i<5; i++){
						newText += "\n * " + ((PhotoVO)list.get(i)).getPhoto_title();
					}
					
					newText += "\n &nbsp;";
					newText += "\n <a href='#'>더보기</a>";
				} else {
					for(int i=0; i<list.size(); i++){
						newText += "\n * " + ((PhotoVO)list.get(i)).getPhoto_title();
					}
				}
			}
				
			
		} else if(boardName.contains("블랙")){
			System.out.println("블랙 진입");
			
			cri.setSearchType("tc");
			cri.setKeyword(keyword);
			list = blackDao.blackList(cri);
			System.out.println("blacklist 크기: "+list.size());
			
			if(list.size() < 1){
				newText += "찿으시는 결과가 없습니다. 다시 검색해주세요";
			} else {
				newText += "<b>"+list.size() + "</b>" + "개의 결과가 검색되었습니다.<hr>";
				newText += "<블랙리스트 게시판 글제목>";
				
				if(list.size() > 5){
					for(int i=0; i<5; i++){
						newText += "\n * " + ((BlackVO)list.get(i)).getBlack_title();
					}
					
					newText += "\n &nbsp;";
					newText += "\n <a href='#'>더보기</a>";
				} else {
					for(int i=0; i<list.size(); i++){
						newText += "\n * " + ((BlackVO)list.get(i)).getBlack_title();
					}
				}
				
			}
				
		} else if(boardName.equals("무료나눔")){
			System.out.println("무료나눔 진입");
			
			cri.setSearchType("tc");
			cri.setKeyword(keyword);
			list = donateDao.donateList(cri);
			System.out.println("donatelist 크기: "+list.size());
			
			if(list.size() < 1){
				newText += "찿으시는 결과가 없습니다. 다시 검색해주세요";
			} else { 
				newText += "<b>"+list.size() + "</b>" + "개의 결과가 검색되었습니다.<hr/>";
				newText += "<무료나눔 게시판 글제목>";
				if(list.size() > 5){
					for(int i=0; i<5; i++){
						newText += "\n * " + ((DonateVO)list.get(i)).getDonate_title();
					}
					
					newText += "\n &nbsp;";
					newText += "\n <a href='#'>더보기</a>";
				} else {
					for(int i=0; i<list.size(); i++){
						newText += "\n * " + ((DonateVO)list.get(i)).getDonate_title();
					}
				}
			}

		} else {
			newText += "우리 코북은 공지사항, 포토리뷰, 블랙리스트, 무료나눔 게시판이 있어요";
		}
		
		return newText;
	}

	// 마이페이지 관련 사항
	@Override
	public String manageMypage(String text, int person_id) throws Exception {
		
		String newText = "";
		List<String> list;
		
		if(text.contains("내") || text.contains("마일리지")){	// 내 마일리지 보여줘 
			System.out.println("토탈마일리지: " + mypageDao.mileageTotal(person_id));
			System.out.println("사용 마일리지" + mypageDao.mileageUse(person_id));
			newText += personDao.findPersonName(person_id) + "님의 마일리지는 "
					+ (mypageDao.mileageTotal(person_id) - mypageDao.mileageUse(person_id)) + "입니다.";
			
		} else if(text.contains("관심분야")){	//내 관심분야
			list = favDao.favoriteList(person_id);
			newText += personDao.findPersonName(person_id) + "님의 관심분야는";
			
			for(String s : list){
				newText += "\n  * " + s;
			}
			newText += "\n 입니다.";
		} 
		
		return newText;
	}

	// 메세지 관련 사항
	@Override
	public String manageMessage(String text, int person_id) throws Exception {
		/*SimpleDateFormat dateFormat = new SimpleDateFormat("yy-MM-dd");
		dateFormat.format(m.getMessage_date();*/
		
		String newText = "";
		List<MessageVO> list = null;
		
		if(text.contains("새") || text.contains("새로운") || text.contains("새로온") || text.contains("새로 온")){		// 새 쪽지 보여줘
			if(messageDao.newMessageList(person_id).size() != 0){	// 리스트의 크기가 0이라는 것은 검색된 메시지가 없다는 뜻
				list = messageDao.newMessageList(person_id);
				newText += "(최신의 쪽지가 상단에 표시됩니다)<hr>";
				newText += "<b>&nbsp;보낸 사람 &nbsp;&nbsp;&nbsp; 내용 </b>";
				
				for(MessageVO m : list){
					newText += "\n * " + personDao.findPersonName(m.getPerson_id()) + "&nbsp; &nbsp; &nbsp;" + m.getMessage_content();
				}
				
				// 쪽지를 조회함과 동시에 쪽지 알림도 0으로 됨 
				alarmDao.alarmUpdateByMessage(person_id);
				
			} else {
				newText += "\n새로운 쪽지가 없습니다.";
			}
			
		} else if(text.contains("보관함") || text.contains("쪽지함")){	// 내 쪽지함 보여줘
			if(messageDao.messageList(person_id).size() != 0){	// 리스트의 크기가 0이라는 것은 검색된 메시지가 없다는 뜻
				list = messageDao.messageList(person_id);
				newText += "(최신의 쪽지가 상단에 표시됩니다) \n 쪽지는 최대 5개만 보여드립니다.<hr>";
				newText += "<b>&nbsp;보낸 사람 &nbsp;&nbsp;&nbsp; 내용 </b>";
				
				// 쪽지 보관함에 5개 이상 있다면 최대 5개까지만 보여주고 링크를 걸어준다
				if(list.size() > 5){
					for(int i=0; i<5; i++){
						newText += "\n * " + personDao.findPersonName(list.get(i).getPerson_id()) + "&nbsp; &nbsp; &nbsp;" + list.get(i).getMessage_content();
					}
					newText +="<hr/> &nbsp; 쪽지를 더보고 싶으면 \n <a href='#'>쪽지보관함으로 이동 </a>";
				} else {
					for(MessageVO m : list){
						newText += "\n * " + personDao.findPersonName(m.getPerson_id()) + "&nbsp; &nbsp; &nbsp;" + m.getMessage_content();
					}
				}	
				
				// 쪽지를 조회함과 동시에 쪽지 알림도 0으로 됨 
				alarmDao.alarmUpdateByMessage(person_id);
				
			} else {
				newText += "\n쪽지함에 쪽지가 없습니다.";
			}
		} else {
			newText += "\n 쪽지 어떤거요?";
		}
		
		return newText;
	}

	@Override
	public String boardNameReplace(String text) {
		String boardName = "";
		
		if(text.contains("에서")){
			boardName = StringUtils.replace(text, "에서", "");
		}
		boardName = StringUtils.replace(text, " ", "");
		
		if(text.length() < 1){
			return null;
		}
		return boardName;
	}

	@Override
	public String keyWordReplace(String text) {
		String keyword = "";
		
		if(text.length() < 1){
			return null;
		}

		if(text.contains("검색")){
			keyword = StringUtils.replace(text, "검색", "");
		} else if(text.contains("보여줘")){
			keyword = StringUtils.replace(text, "보여줘", "");
		} else if(text.contains("알려줘")){
			keyword = StringUtils.replace(text, "알려줘", "");
		} else if(text.contains("찾아줘")){
			keyword = StringUtils.replace(text, "찾아줘", "");
		}

		keyword = keyword.replaceAll("\\s+$", "");
		
		return keyword;
	}
	
}
