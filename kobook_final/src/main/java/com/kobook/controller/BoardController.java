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
		
		service.boardRegist(vo);
	
		rttr.addFlashAttribute("result", "SUCCESS");
		
		return "redirect:/board/boardList";
	}
	
	@RequestMapping(value="/boardList", method = RequestMethod.GET)
	public void BoardList(@ModelAttribute("cri") SearchCriteria cri, Model model)throws Exception{
		model.addAttribute("list", service.boardListCri(cri));
		PageMaker pageMaker=new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.boardcountPaging(cri));
		model.addAttribute("pageMaker",pageMaker);
	}
	
	
	@RequestMapping("/adminMain")
	public String admin()throws Exception {
		logger.info("adminPage....loggging");
		return "/board/adminMain";
	}
	
	
	@RequestMapping("boardDetail")
	public void blackRead(@RequestParam("board_id") int board_id, Model model,
			@ModelAttribute("cri") SearchCriteria cri) throws Exception{
		model.addAttribute(service.boardRead(board_id));
	}
	

	@RequestMapping("boardRemove")
	public String boardRemove(@RequestParam("board_id")Integer board_id, SearchCriteria cri, RedirectAttributes rttr)throws Exception {
		
		service.boardRemove(board_id);
		
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("searchType", cri.getSearchType());
		rttr.addAttribute("keyword", cri.getKeyword());
		
		rttr.addFlashAttribute("msg", "SUCCESS");
		
		return "redirect:/board/boardList";
	}
}
