package com.kobook.controller;



import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kobook.board.domain.BoardVO;
import com.kobook.board.service.BoardService;
import com.kobook.book.domain.BookVO;
import com.kobook.book.domain.SearchCriteria;
import com.kobook.book.service.BookService;
import com.kobook.person.service.PersonService;
import com.kobook.recom.domain.FavoriteBookVO;
import com.kobook.recom.domain.FavoriteVO;
import com.kobook.recom.domain.RdataVO;
import com.kobook.recom.service.FavoriteService;


//추천도서 추출하는 컨트롤러
//FAVORITE / RDATA 매퍼와 도메인 사용

@Controller
public class RecomController {
	
	@Inject
	private FavoriteService service;
	
	
	//로그인 했을 때 메인 화면에 공지사항 띄우기 위해 보드 사용함.
	@Inject 
	private BoardService boardService;
	
	@Inject
	private PersonService pService;
	
	@Inject
	private BookService bookService;
	
	@RequestMapping(value="/main", method=RequestMethod.GET)
	public String goMain(HttpServletRequest request) throws Exception{
		
		HttpSession session = request.getSession();
		String p = (String)session.getAttribute("person_id")+"";
		System.out.println(p);
		
		if(p.equals("null")) {
			SearchCriteria cri2 = new SearchCriteria();
			cri2.setPerPageNum(10);
			List<BookVO> bookList = bookService.listCriteria(cri2);
			request.setAttribute("bookList", bookList);

			return "/main";

			
		}else {
			return "redirect:/recom";	
		}
		
	}
	
	//메인으로 가기 전 로그인한 사용자의 추천도서 목록을 추출하는 메소드. 모든 메인은 이 메소드를 거친다.
	@RequestMapping(value="/recom", method = RequestMethod.GET)
	public String recommend(Model model, HttpServletRequest request) throws Exception {
		System.out.println("controller - recom");
		request.getAttribute("alarmList");
		
		HttpSession session = request.getSession();
		int person_id = Integer.parseInt((String)session.getAttribute("person_id"));
		
		
		SearchCriteria cri = new SearchCriteria();
		cri.setPerPageNum(boardService.boardListCri(cri).size());

		List<FavoriteBookVO> favoriteList = service.getFavorite(person_id);
		List<BoardVO> boardList = boardService.boardListCri(cri);
		
		String person_name = pService.findPersonName(person_id);
		session.setAttribute("person_name", person_name);
		
		//사용자의 추천도서를 우선순위별로 출력하는 반복문.
		// favorite + rdata 테이블을 사용해서 추천도서의 우선순위(rank)를 매기고, 출력한다.
/*		for (int i = 0; i < favoriteList.size(); i++) {
			int temp = 0;
			
			if(favoriteList.get(i).getFavorite_rank() == 0){
				
				if(favoriteList.get(i).getFavorite_major().equals("M")){
					favoriteList.get(i).setFavorite_rank(favoriteList.get(i).getFavorite_rank()+10);
				}
				
				while(temp < 20){
						
						if(favoriteList.get(i).getFavorite_name().equals(rdataList.get(temp).getRdata_m())){
							
							favoriteList.get(i).setFavorite_rank(favoriteList.get(i).getFavorite_rank() + rdataList.get(i).getRdata_support());
							
							//update문 매퍼 실행
							FavoriteVO favorite = new FavoriteVO();
							favorite.setPerson_id(person_id);
							favorite.setBook_id(favoriteList.get(i).getBook_id());
							favorite.setFavorite_rank(favoriteList.get(i).getFavorite_rank());
							service.updateFavoriteRank(favorite);
	
						}
					temp++;
				}
			}
		}*/
		
		cri.setPerPageNum(100);
		List<BookVO> bookList = bookService.listCriteria(cri);
		List<RdataVO> rList = service.getBigdata(person_id);	// 데이터 마이닝 추천

		
		//원래 회원이 추천을 누른 과목의 점수를 더하기.
		for (int i = 0; i < favoriteList.size(); i++) {
			
			
			if(favoriteList.get(i).getFavorite_rank() == 0){
				if(favoriteList.get(i).getFavorite_major().equals("M")){
					favoriteList.get(i).setFavorite_rank(favoriteList.get(i).getFavorite_rank()+20);
				}else {
					favoriteList.get(i).setFavorite_rank(favoriteList.get(i).getFavorite_rank()+10);
				}
			}
			
			
		}
		
		//데이터 마이닝 결과의 값들에 입력 
		for (int i = 0; i < rList.size(); i++) {
			for (int j = 0; j < bookList.size(); j++) {
				if(rList.get(i).getRdata_o().equals(bookList.get(j).getBook_kind())){
					
					FavoriteBookVO fbvo = new FavoriteBookVO();
					fbvo.setBook_id(bookList.get(j).getBook_id());
					fbvo.setBook_name(bookList.get(j).getBook_name());
					fbvo.setBook_img(bookList.get(j).getBook_img());
					favoriteList.add(fbvo);
					
					FavoriteVO favorite = new FavoriteVO();
					favorite.setPerson_id(person_id);
					favorite.setBook_id(favoriteList.get(i).getBook_id());
					favorite.setFavorite_rank(favoriteList.get(i).getFavorite_rank());
					service.updateFavoriteRank(favorite);
					
					break;
				}
			}
		}
		
		
		request.setAttribute("list", favoriteList);
		request.setAttribute("boardList", boardList);
		favoriteList = service.getFavorite(person_id);

		return "/main";
	}
	
	
	
	//추천도서 'X'버튼을 누르면 해당 도서가 favorite 테이블에서 삭제된다.
	@RequestMapping(value="/deleteRecom", method = RequestMethod.GET)
	public String deleteRecommend(@RequestParam("book_id")int book_id, HttpServletRequest request) throws Exception {
		System.out.println("controller - deleteRecom");
		
		FavoriteVO vo = new FavoriteVO();
		
		vo.setBook_id(book_id);
		vo.setFavorite_major(request.getParameter("favorite_major"));
		vo.setFavorite_name(request.getParameter("favorite_name"));
		vo.setPerson_id(Integer.parseInt((String)request.getSession().getAttribute("person_id")));
		
		service.deleteFavorite(vo);
		
		return "redirect:/recom";
	}

}
