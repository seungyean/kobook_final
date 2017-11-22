package com.kobook.controller;


import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kobook.board.domain.BoardVO;
import com.kobook.board.service.BoardService;
import com.kobook.book.domain.PageMaker;
import com.kobook.book.domain.SearchCriteria;

@Controller
@RequestMapping("/board/*")
public class BoardController {

	private static final Logger logger =
			LoggerFactory.getLogger(BoardController.class);
	
	@Inject
	private BoardService service;
	
	@RequestMapping(value="/boardInsert", method=RequestMethod.GET)
	public void notiGET(BoardVO vo, Model model)throws Exception{
	}
	
	@RequestMapping(value="/boardInsert", method=RequestMethod.POST)
	public String notiPOST(BoardVO vo, RedirectAttributes rttr)throws Exception {
		
/*		//BoardVO 내용확인
		logger.info("insert post.....");
		logger.info(vo.toString());*/
		
		service.BoardRegist(vo);
	
	/*	rttr.addFlashAttribute("list", "success");*/
		
		return "redirect:/board/boardList";
	}
	
	@RequestMapping("/boardList")
	public void BoardList(@ModelAttribute("cri") SearchCriteria cri, Model model)throws Exception{
		model.addAttribute("list", service.BoardListCri(cri));
		PageMaker pageMaker=new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.BoardcountPaging(cri));
		model.addAttribute("pageMaker",pageMaker);
	}
	
	
	@RequestMapping("/adminMain")
	public String admin()throws Exception {
		
		logger.info("adminPage....loggging");
		return "/board/adminMain";
	}
	
	
	@RequestMapping(value="/boardDetail", method=RequestMethod.GET)
	public void readGET(@RequestParam("board_id") int board_id, Model model)throws Exception {
		
		model.addAttribute(service.BoardRead(board_id));
	}
	
	@RequestMapping(value="/boardDetail", method=RequestMethod.POST)
	public String readPOST(@RequestParam("board_id") int board_id, RedirectAttributes rttr)throws Exception {
		
		service.BoardRead(board_id);
		
		return "redirect:/board/boardDetail";
	}
	
	
/*	@RequestMapping(value="/detailNoti",method=RequestMethod.GET)
	public void read(@RequestParam("board_id")int board_id, @ModelAttribute("cri")SearchCriteria cri, Model model)throws Exception{
		model.addAttribute(service.BoardRead(board_id));
	}*/
	
}
