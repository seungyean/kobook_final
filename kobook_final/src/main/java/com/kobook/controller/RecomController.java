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
import com.kobook.book.domain.SearchCriteria;
import com.kobook.recom.domain.FavoriteBookVO;
import com.kobook.recom.domain.FavoriteVO;
import com.kobook.recom.service.FavoriteService;



@Controller
public class RecomController {
	
	@Inject
	private FavoriteService service;
	
	@Inject BoardService boardService;
	
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
		
		request.setAttribute("list", favoriteList);
		request.setAttribute("boardList", boardList);
		
		return "/main";
	}
	
	@RequestMapping(value="/deleteRecom", method = RequestMethod.GET)
	public String deleteRecommend(@RequestParam("book_id")int book_id, HttpServletRequest request) throws Exception {
		System.out.println("controller - deleteRecom");
		
		FavoriteVO vo = new FavoriteVO();
		
		vo.setBook_id(book_id);
		vo.setFavorite_id(Integer.parseInt(request.getParameter("favorite_id")));
		vo.setFavorite_major(request.getParameter("favorite_major"));
		vo.setFavorite_name(request.getParameter("favorite_name"));
		vo.setPerson_id(Integer.parseInt((String)request.getSession().getAttribute("person_id")));
		
		service.deleteFavorite(vo);
		
		return "redirect:/alarmList";
	}

}
