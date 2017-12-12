package com.kobook.chatbot.service;

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
		
		int person_id = vo.getPerson_id();
		String text = vo.getChatlog_content();
		String newText = "";
		
		// 사용자의 대화 판별
		if(text.equals("야") || text.contains("도와줘") || text.contains("도움")){
			
			newText += personDao.findPersonName(person_id) + "님, 오셨군요!";;
		
		// 쪽지 파트
		} else if(text.contains("쪽지")){	
			
			newText = manageMessage(text, person_id);
			
			
		// 마일리지 파트
		} else if(text.contains("마일리지") || text.contains("관심")){	

			newText = manageMypage(text, person_id);
		
			
		// 게시판 파트
		// 책검색도 찾아줘,보여줘,알려줘,검색등을 사용하지만 각 게시판에 대한 내용이 들어가있다면 우선순위를 먼저둔다 
		} else if(text.contains("공지") || text.contains("블랙") || text.contains("포토") || text.contains("무료나눔")){
			
			newText = manageBoard(text, person_id);
			
			
		// 책 검색
		} else if(text.contains("찾아줘") || text.contains("보여줘") || text.contains("알려줘") || text.contains("검색") ||  text.contains("책")){
			
			newText = manageBook(text, person_id);
			
			
		// 카테고리를 벗어났을 때
		} else {
			
			newText = "저희가 준비한 카테고리는"
					+ "\n 책 검색, 게시판 검색, 개인정보, 쪽지 입니다."
					+ "\n 카테고리 내에서 질문해 주시겠어요??";
		}
		
		vo.setChatlog_content(newText);
		//computer가 대답하는 것으로 값 setting
		vo.setChatlog_speaker("C");
		
		return vo;
	}

	
	// 책 관련사항  (찾아줘,보여줘,알려줘,검색,책)
	@Override
	public String manageBook(String text, int person_id) throws Exception {
		
		SearchCriteria cri = new SearchCriteria();
		List<BookVO> list = null;
		List<BookVO> sList = null;	//안전거래리스트	
		List<BookVO> dList = null;	//직거래리스트
		String newText = "";
		String keyword = "";
		String contentUrl = "";
		String more = "";
		String area = "";
		
		if(text.contains("근처") || text.contains("주변")){
			
			newText = "검색 결과는 제목+내용에서 검색된 결과이며 최대 5개까지 보여드립니다. \n";
			
			// 검색,찾아줘,보여줘,알려줘라는 단어와 그 바로앞에 공백이 있다면 cut
			area = keyWordReplace(text);
			
			// 주변,근처라는 단어와 그 바로앞에 공백이 있다면 cut
			area = areaReplace(area);
			cri.setKeyword(area);
			sList = bookDao.safeListCriteria(cri);
			dList = bookDao.directListCriteria(cri);
			
			newText += "<hr> <안전거래 리스트> \n";
			if(sList.size() < 1){
				newText += "해당 키워드에 맞는 책이 없습니다.";
				
			} else {
				newText += "&nbsp; \n <b>"+sList.size() + "</b>" + "개의 결과가 검색되었습니다. \n";
				
				if(sList.size() > 5){
					for(int i=0; i<5; i++){
						contentUrl = "/book/bookRead?book_id=" + sList.get(i).getBook_id();
						
						// 해당 url을 클릭하게 되면 부모창에서 화면 전환이 이루어진다  
						newText += "\n ■ &nbsp;"
								+ "<a href=\"javascript:;\" onClick=\"opener.parent.location='"+ contentUrl +"'; return false;\">"
								+ sList.get(i).getBook_name()+"</a>";
						
					}
				} else {
					for(int i=0; i<sList.size(); i++){
						contentUrl = "/book/bookRead?book_id=" + sList.get(i).getBook_id();
						newText += "\n ■ &nbsp;"
								+ "<a href=\"javascript:;\" onClick=\"opener.parent.location='"+ contentUrl +"'; return false;\">"
								+ sList.get(i).getBook_name()+"</a>";
						 
					}
				}
				
			}
			
			newText += "<hr> <직거래 리스트> \n";
			
			if(dList.size() < 1){
				newText += "해당 키워드에 맞는 책이 없습니다.";
				
			} else {
				newText += "&nbsp; \n <b>"+ dList.size() + "</b>" + "개의 결과가 검색되었습니다. \n";
				
				if(dList.size() > 5){
					for(int i=0; i<5; i++){
						contentUrl = "/book/bookRead?book_id=" + dList.get(i).getBook_id();
						newText += "\n ■ &nbsp;"
								+ "<a href=\"javascript:;\" onClick=\"opener.parent.location='"+ contentUrl +"'; return false;\">"
								+ dList.get(i).getBook_name()+"</a>";
					}
				} else {
					for(int i=0; i<dList.size(); i++){
						contentUrl = "/book/bookRead?book_id=" + dList.get(i).getBook_id();
						newText += "\n ■ &nbsp;"
								+ "<a href=\"javascript:;\" onClick=\"opener.parent.location='"+ contentUrl +"'; return false;\">"
								+ dList.get(i).getBook_name()+"</a>";
					}
				}
				
			}
			
		}
		
		// 제목 혹은 해시태그로 검색
		else if(text.contains("알려줘") || text.contains("보여줘") || text.contains("찾아줘") || text.contains("검색")){	
			
			newText = "검색 결과는 제목+내용에서 검색된 결과이며 최대 5개까지 보여드립니다. \n";
			
			// 검색,찾아줘,보여줘,알려줘라는 단어와 그 바로앞에 공백이 있다면 cut
			keyword = keyWordReplace(text);
			
			// criteria를 책제목과 해시태그를 검색할 것으로 설정
			cri.setSearchType("tw");
			cri.setKeyword(keyword);
			list = bookDao.listCriteria(cri);
			
			
			if(list.size() < 1){
				newText += "해당 키워드에 맞는 책이 없습니다.";
				
			} else {
				newText += "&nbsp; \n <b>"+list.size() + "</b>" + "개의 결과가 검색되었습니다.<hr>";
				newText += "<찾으시는 책 제목>";
				
				if(list.size() > 5){
					for(int i=0; i<5; i++){
						contentUrl = "/book/bookRead?book_id=" + list.get(i).getBook_id();
						newText += "\n ■ &nbsp;"
								+ "<a href=\"javascript:;\" onClick=\"opener.parent.location='"+ contentUrl +"'; return false;\">"
								+ list.get(i).getBook_name()+"</a>";
					}
					more = "/book/bookList?page=1&perPageNum=9&searchType=tw&keyword=" + keyword;
					newText += "<hr>"
							+ "<a href=\"javascript:;\" onClick=\"opener.parent.location='"+ more +"'; return false;\"> 더보러가기 </a>"; 
				} else {
					for(int i=0; i<list.size(); i++){
						contentUrl = "/book/bookRead?book_id=" + list.get(i).getBook_id();
						newText += "\n ■ &nbsp;"
								+ "<a href=\"javascript:;\" onClick=\"opener.parent.location='"+ contentUrl +"'; return false;\">"
								+ list.get(i).getBook_name()+"</a>";
					}
				}
			}
			
			
			
		//내가 등록한 책 보여줘
		} else if(text.contains("내가") && text.contains("등록")){ 
			list = bookDao.getMyBookList(person_id);
			
			if(list.size() < 1){
				newText += personDao.findPersonName(person_id) + "님이 등록한 책이 없습니다.";
			} else {
				newText += "\n <내가 등록한 책 제목>";
				for(int i=0; i<list.size(); i++){
					contentUrl = "/book/bookRead?book_id=" + list.get(i).getBook_id();
					newText += "\n ■ &nbsp;"
							+ "<a href=\"javascript:;\" onClick=\"opener.parent.location='"+ contentUrl +"'; return false;\">"
							+ list.get(i).getBook_name()+"</a>";
				}
			}
			
			
		} else {
			newText += "책에 대해서 다시 질문해주시겠어요?";
		}
		
		return newText;
	}

	
	// 게시판 관련 사항(공지,블랙,무료나눔,포토)
	@Override
	public String manageBoard(String text, int person_id) throws Exception {
		
		SearchCriteria cri = new SearchCriteria();
		List<?> list = null;
		String newText = "검색 결과는 제목+내용에서 검색된 결과이며 최대 5개까지 보여드립니다. \n";
		String boardName = null;
		
		// 게시판의 성향을 띈 부분을 제외한 나머지 부분(검색할 내용)을 추리는 과정
		String rawKeyword = text.substring(text.indexOf(" ")+1);
		String keyword = null;
		
		Pattern bPattern = Pattern.compile("^공지|^포토|^블랙|^무료나눔");
		Matcher bMatcher = bPattern.matcher(text);
		
		// 공지, 포토, 블랙, 무료나눔으로 시작하는 문자열이 있다면 while문에 진입해서 게시판 이름만 가져오기
		while(bMatcher.find()){
			boardName = boardNameReplace(bMatcher.group());
		}
		
		String contentUrl = "";
		
		keyword = keyWordReplace(rawKeyword);
		
		// 공지사항파트
		if(boardName.contains("공지")){
	
			cri.setSearchType("tc");
			cri.setKeyword(keyword);
			list = boardDao.boardListCri(cri);
			
			if(list.size() < 1){
				newText += "찿으시는 결과가 없습니다. 다시 검색해주세요";
			}
			else {
				newText += "&nbsp; \n <b>"+list.size() + "</b>" + "개의 결과가 검색되었습니다.<hr>";
				newText += "<공지사항 게시판 글제목>";
				
				if(list.size() > 5){
					for(int i=0; i<5; i++){
						contentUrl = "/board/boardDetail?board_id="
								+ ((BoardVO)list.get(i)).getBoard_id();
						newText += "\n ■ &nbsp;"
								+ "<a href=\"javascript:;\" onClick=\"opener.parent.location='"+ contentUrl +"'; return false;\">"
								+((BoardVO)list.get(i)).getBoard_title() + "</a>";
					}
					contentUrl = "/board/boardList?page=1&perPageNum=9&searchType=tc&keyword=" + keyword;
					newText += "\n ■ &nbsp;"
							+ "<a href=\"javascript:;\" onClick=\"opener.parent.location='"+ contentUrl +"'; return false;\">더보기</a>";
				} else {
					for(int i=0; i<list.size(); i++){
						contentUrl = "/board/boardDetail?board_id="
								+ ((BoardVO)list.get(i)).getBoard_id();
						newText += "\n ■ &nbsp;"
								+ "<a href=\"javascript:;\" onClick=\"opener.parent.location='"+ contentUrl +"'; return false;\">"
								+((BoardVO)list.get(i)).getBoard_title() + "</a>";
					}
				}
			}
			
		// 포토리뷰 파트
		} else if(boardName.contains("포토")){
			
			cri.setSearchType("tc");
			cri.setKeyword(keyword);
			list = photoDao.photoList(cri);
			
			if(list.size() < 1){
				newText += "찿으시는 결과가 없습니다. 다시 검색해주세요";
			} else{
				newText += "&nbsp; \n <b>"+list.size() + "</b>" + "개의 결과가 검색되었습니다.<hr>";
				newText += "<포토리뷰리스트 게시판 글제목>";

				if(list.size() > 5){
					for(int i=0; i<5; i++){
						contentUrl = "/community/photoReviewRead?page=1&perPageNum=9&searchType&keyword&photo_id="
									+ ((PhotoVO)list.get(i)).getPhoto_id();
						newText += "\n ■ &nbsp;"
								+ "<a href=\"javascript:;\" onClick=\"opener.parent.location='"+ contentUrl +"'; return false;\">"
								+ ((PhotoVO)list.get(i)).getPhoto_title()+"</a>";
					}
					contentUrl = "/community/photoReviewList?page=1&perPageNum=9&searchType=tc&keyword=" + keyword;
					newText += "\n ■ &nbsp;"
							+ "<a href=\"javascript:;\" onClick=\"opener.parent.location='"+ contentUrl +"'; return false;\">더보기</a>";
				} else {
					for(int i=0; i<list.size(); i++){
						contentUrl = "/community/photoReviewRead?page=1&perPageNum=9&searchType&keyword&photo_id=" 
								+ ((PhotoVO)list.get(i)).getPhoto_id();
						newText += "\n ■ &nbsp;"
								+ "<a href=\"javascript:;\" onClick=\"opener.parent.location='"+ contentUrl +"'; return false;\">"
								+ ((PhotoVO)list.get(i)).getPhoto_title()+"</a>";
					}
				}
			}
				
		// 블랙리스트 파트
		} else if(boardName.contains("블랙")){
			
			cri.setSearchType("tcw");
			cri.setKeyword(keyword);
			list = blackDao.blackList(cri);
			
			if(list.size() < 1){
				newText += "<hr>찿으시는 결과가 없습니다.\n다시 검색해주세요";
			} else {
				newText += "&nbsp; \n <b>"+list.size() + "</b>" + "개의 결과가 검색되었습니다.<hr>";
				newText += "<블랙리스트 게시판 글제목>";
				
				if(list.size() > 5){
					for(int i=0; i<5; i++){
						contentUrl = "/community/blackRead?page=1&perPageNum=9&searchType&keyword&black_id="
								+ ((BlackVO)list.get(i)).getBlack_id();
						newText += "\n ■ &nbsp;"
								+ "<a href=\"javascript:;\" onClick=\"opener.parent.location='"+ contentUrl +"'; return false;\">"
								+ ((BlackVO)list.get(i)).getBlack_title() + "</a>";
					}				
					contentUrl = "/community/blackList?page=1&perPageNum=9&searchType=tcw&keyword=" + keyword;
					newText += "\n ■ &nbsp;"
							+ "<a href=\"javascript:;\" onClick=\"opener.parent.location='"+ contentUrl +"'; return false;\">더보기</a>";
				} else {
					for(int i=0; i<list.size(); i++){
						contentUrl = "/community/blackRead?page=1&perPageNum=9&searchType&keyword&black_id="
								+ ((BlackVO)list.get(i)).getBlack_id();
						newText += "\n ■ &nbsp;"
								+ "<a href=\"javascript:;\" onClick=\"opener.parent.location='"+ contentUrl +"'; return false;\">" 
								+ ((BlackVO)list.get(i)).getBlack_title() + "</a>";
					}
				}
				
			}
				
		// 무료나눔 파트
		} else if(boardName.equals("무료나눔")){
			System.out.println("무료나눔 진입");
			
			cri.setSearchType("tc");
			cri.setKeyword(keyword);
			list = donateDao.donateList(cri);
			
			if(list.size() < 1){
				newText += "찿으시는 결과가 없습니다. 다시 검색해주세요";
			} else { 
				newText += "&nbsp; \n <b>"+list.size() + "</b>" + "개의 결과가 검색되었습니다.<hr/>";
				newText += "<무료나눔 게시판 글제목>";
				if(list.size() > 5){
					for(int i=0; i<5; i++){
						contentUrl = "/community/donateRead?page=1&perPageNum=9&searchType&keyword&donate_id="
								+ ((DonateVO)list.get(i)).getDonate_id();
						newText += "\n ■ &nbsp;"
								+ "<a href=\"javascript:;\" onClick=\"opener.parent.location='"+ contentUrl +"'; return false;\">" 
								+ ((DonateVO)list.get(i)).getDonate_title() + "</a>";
					}
					contentUrl = "/community/donateList?page=1&perPageNum=9&searchType=tc&keyword=" + keyword;
					newText += "\n ■ &nbsp;"
							+ "<a href=\"javascript:;\" onClick=\"opener.parent.location='"+ contentUrl +"'; return false;\">더보기</a>";
					
				} else {
					for(int i=0; i<list.size(); i++){
						contentUrl = "/community/donateRead?page=1&perPageNum=9&searchType&keyword&donate_id="
								+ ((DonateVO)list.get(i)).getDonate_id();
						newText += "\n ■ &nbsp;"
								+ "<a href=\"javascript:;\" onClick=\"opener.parent.location='"+ contentUrl +"'; return false;\">" 
								+ ((DonateVO)list.get(i)).getDonate_title() + "</a>";
					}
				}
			}

		} else {
			newText += "우리 코북은 공지사항, 포토리뷰, 블랙리스트, 무료나눔 게시판이 있어요";
		}
		
		return newText;
	}

	
	// 마이페이지 관련 사항(마일리지,관심분야)
	@Override
	public String manageMypage(String text, int person_id) throws Exception {
		
		String newText = "";
		List<String> list;
		
		if(text.contains("마일리지")){	// 내 마일리지 보여줘 
			newText += personDao.findPersonName(person_id) + "님의 마일리지는 "
					+ (mypageDao.mileageTotal(person_id) - mypageDao.mileageUse(person_id)) + "입니다.";
			
		} else if(text.contains("관심분야")){	//내 관심분야
			list = favDao.favoriteList(person_id);
			newText += personDao.findPersonName(person_id) + "님의 관심분야는";
			
			for(String s : list){
				newText += "\n  ■ " + s;
			}
			newText += "\n 입니다.";
		} 
		
		return newText;
	}

	
	// 쪽지 관련 사항(쪽지)
	@Override
	public String manageMessage(String text, int person_id) throws Exception {
		/*SimpleDateFormat dateFormat = new SimpleDateFormat("yy-MM-dd");
		dateFormat.format(m.getMessage_date();*/
		
		String newText = "";
		String contentUrl = "";
		List<MessageVO> list = null;
		
		if(text.contains("새") || text.contains("새로운") || text.contains("새로온") || text.contains("새로 온")){		// 새 쪽지 보여줘
			if(messageDao.newMessageList(person_id).size() < 1){	// 리스트의 크기가 0이라는 것은 검색된 메시지가 없다는 뜻
				list = messageDao.newMessageList(person_id);
				newText += "(최신의 쪽지가 상단에 표시됩니다)<hr>";
				newText += "<b>&nbsp;보낸 사람 &nbsp;&nbsp;&nbsp; 내용 </b>";
				
				for(MessageVO m : list){
					newText += "\n ■  " + personDao.findPersonName(m.getPerson_id()) + "&nbsp; &nbsp; &nbsp;" + m.getMessage_content();
				}
				
				// 쪽지를 조회함과 동시에 쪽지 알림도 0으로 됨 
				alarmDao.alarmUpdateByMessage(person_id);
				
			} else {
				newText += "\n새로운 쪽지가 없습니다.";
			}
			
			contentUrl = "/mypage/messageBox";
			newText +="<hr/> &nbsp; \n"
					+ "<a href=\"javascript:;\" onClick=\"opener.parent.location='"+ contentUrl +"'; return false;\"> 쪽지보관함으로 이동 </a>";
			
		} else if(text.contains("보관함") || text.contains("쪽지함")){	// 내 쪽지함 보여줘
			if(messageDao.messageList(person_id).size() < 1){	// 리스트의 크기가 0이라는 것은 쪽지함에 쪽지가 없다는 뜻
				list = messageDao.messageList(person_id);
				newText += "(최신의 쪽지가 상단에 표시됩니다) \n 쪽지는 최대 5개만 보여드립니다.<hr>";
				newText += "<b>&nbsp;보낸 사람 &nbsp;&nbsp;&nbsp; 내용 </b>";
				
				// 쪽지 보관함에 5개 이상 있다면 최대 5개까지만 보여주고 링크를 걸어준다
				if(list.size() > 5){
					for(int i=0; i<5; i++){
						newText += "\n ■  " + personDao.findPersonName(list.get(i).getPerson_id()) + "&nbsp; &nbsp; &nbsp;" + list.get(i).getMessage_content();
					}
					
				} else {
					for(MessageVO m : list){
						newText += "\n ■  " + personDao.findPersonName(m.getPerson_id()) + "&nbsp; &nbsp; &nbsp;" + m.getMessage_content();
					}
				}	
				
				contentUrl = "/mypage/messageBox";
				newText +="<hr/> &nbsp; \n"
						+ "<a href=\"javascript:;\" onClick=\"opener.parent.location='"+ contentUrl +"'; return false;\"> 쪽지보관함으로 이동 </a>";
				
				// 쪽지를 조회함과 동시에 쪽지 알림도 0으로 됨 
				alarmDao.alarmUpdateByMessage(person_id);
				
			} else {
				newText += "\n쪽지함에 쪽지가 없습니다.";
			}
		} else {
			newText += "\n 쪽지 어떤거요? 새쪽지? 보관함?";
		}
		
		return newText;
	}

	
	
	/*해당 문자열 치환 메소드*/
	
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
			return "";
			
		} else {
			
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
		}
		
		return keyword;
	}
	
	public String areaReplace(String text){
		String area = "";
		
		if(text.length() < 1){
			return "";
			
		} else {
			
			if(text.contains("주변")){
				area = StringUtils.replace(text, "주변", "");
			} else if(text.contains("근처")){
				area = StringUtils.replace(text, "근처", "");
			}

			area = area.replaceAll("\\s+$", "");
		}
		
		return area;
	}
	
}
