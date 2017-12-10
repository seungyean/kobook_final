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

import com.kobook.admin.service.VisitService;
import com.kobook.board.domain.BoardVO;
import com.kobook.board.service.BoardService;
import com.kobook.book.domain.PageMaker;
import com.kobook.book.domain.SearchCriteria;
import com.kobook.person.domain.PersonVO;


@Controller
@RequestMapping("/board/*")
public class BoardController {

	private static final Logger logger =
			LoggerFactory.getLogger(BoardController.class);
	
	@Inject
	private BoardService service;
	
	@Inject
	private VisitService visitservice;
	
	//공지사항 입력
	@RequestMapping(value="/boardInsert", method=RequestMethod.GET)
	public void notiGET(BoardVO vo, Model model)throws Exception{
	}
	
	@RequestMapping(value="/boardInsert", method=RequestMethod.POST)
	public String notiPOST(BoardVO vo, RedirectAttributes rttr)throws Exception {
		
		service.boardRegist(vo);
		rttr.addFlashAttribute("result", "SUCCESS");
		return "redirect:/board/boardList";
	}
	
	//공지사항 LIST
	@RequestMapping(value="/boardList", method = RequestMethod.GET)
	public void boardList(@ModelAttribute("cri") SearchCriteria cri, Model model)throws Exception{
		model.addAttribute("list", service.boardListCri(cri));
		PageMaker pageMaker=new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.boardCountPaging(cri));
		model.addAttribute("pageMaker",pageMaker);
	}
	
	//공지사항 상세보기
	@RequestMapping("/boardDetail")
	public void boardRead(@RequestParam("board_id") int board_id, Model model,
			@ModelAttribute("cri") SearchCriteria cri) throws Exception {	
		model.addAttribute(service.boardRead(board_id));
	}

	//공지사항 제거
	@RequestMapping("/boardRemove")
	public String boardRemove(@RequestParam("board_id")Integer board_id, SearchCriteria cri, RedirectAttributes rttr)throws Exception {

		service.boardRemove(board_id);
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("searchType", cri.getSearchType());
		rttr.addAttribute("keyword", cri.getKeyword());
		rttr.addFlashAttribute("msg", "SUCCESS");
		return "redirect:/board/boardList";
	}
	
	//공지사항 수정
	@RequestMapping(value = "/boardModify", method = RequestMethod.GET)
	public void boardModifyGET(@RequestParam("board_id") int board_id, Model model,
			@ModelAttribute("cri") SearchCriteria cri) throws Exception {
			System.out.println("modifyGET");
		model.addAttribute(service.boardRead(board_id));
	}
	
	@RequestMapping(value = "/boardModify", method = RequestMethod.POST)
	public String boardModifyPOST(RedirectAttributes rtts, BoardVO vo, SearchCriteria cri) throws Exception {
		service.boardModify(vo);
		rtts.addAttribute("page", cri.getPage());
		rtts.addAttribute("perPageNum", cri.getPerPageNum());
		rtts.addAttribute("searchType", cri.getSearchType());
		rtts.addAttribute("keyword", cri.getKeyword());
		System.out.println("Modify - post");
		
		return "redirect:/board/boardList";
	}
	
	//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ 관리자용 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	//회원리스트
	@RequestMapping(value="/personList", method = RequestMethod.GET)
	public void personList(@ModelAttribute("cri") SearchCriteria cri, Model model)throws Exception {
		model.addAttribute("list", service.personList(cri));
		PageMaker pageMaker=new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.personCountPage(cri));
		model.addAttribute("pageMaker",pageMaker);
	}
	
	//회원 상세보기
	@RequestMapping("/personDetail")
	public void personRead(@RequestParam("person_id") int person_id, Model model,
			@ModelAttribute("cri") SearchCriteria cri) throws Exception {	
		model.addAttribute(service.personRead(person_id));
	}
	
	//회원 수정
	@RequestMapping(value="/personModify", method=RequestMethod.POST)
	public String personModifyPOST(RedirectAttributes rttr, SearchCriteria cri, PersonVO vo,
			@RequestParam("person_kind")String person_kind, @RequestParam("person_sell_grade")String person_sell_grade) throws Exception {
	
		service.personModify(vo);
		
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("searchType", cri.getSearchType());
		rttr.addAttribute("keyword", cri.getKeyword());
		rttr.addFlashAttribute("msg", "SUCCESS");
	
		
		return "redirect:/board/personList";
	}
	
	//회원 제거
	@RequestMapping(value="/personRemove", method=RequestMethod.POST)
	public String personRemove(@RequestParam("person_id") int person_id, SearchCriteria cri, RedirectAttributes rttr) throws Exception {

		service.personRemove(person_id);
		
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("searchType", cri.getSearchType());
		rttr.addAttribute("keyword", cri.getKeyword());
		rttr.addFlashAttribute("msg", "SUCCESS");
		return "redirect:/board/personList";
	}
	
	//공지사항 입력

	@RequestMapping(value="/blackAdmin", method = RequestMethod.GET)
	public void blackAdminListGET(@ModelAttribute("cri") SearchCriteria cri, Model model)throws Exception {
		model.addAttribute("list", visitservice.blackPersonList());
		PageMaker pageMaker=new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.personCountPage(cri));
		model.addAttribute("pageMaker",pageMaker);
	}
	
		
		@RequestMapping(value="/blackAdmin", method=RequestMethod.POST)
		public String blackAdminPOST(PersonVO vo, RedirectAttributes rttr)throws Exception {
			
			rttr.addFlashAttribute("result", "SUCCESS");
			return "redirect:/board/blackAdmin";
		}

}
