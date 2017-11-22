package com.kobook.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kobook.book.domain.BookVO;
import com.kobook.book.domain.PageMaker;
import com.kobook.book.domain.SearchCriteria;
import com.kobook.book.service.BookService;

@Controller
@RequestMapping("/book/*")
public class BookController {

	@Inject
	private BookService service;
	
	@RequestMapping(value="/bookRegist",method=RequestMethod.GET)
	public void bookRegistGET(BookVO book, Model model)throws Exception{
	}
	
	@RequestMapping(value="/bookRegist",method=RequestMethod.POST)
	public String bookRegistPOST(BookVO book,Model model) throws Exception{
		
		System.out.println("aaaaaaaaaaaa");
		System.out.println(book.toString()); 
		service.regist(book);
		System.out.println("bbbbbbbbbb");
		return "redirect:/book/bookList";
		
	}

	@RequestMapping("/bookList")
	public void list(@ModelAttribute("cri") SearchCriteria cri, Model model)throws Exception{
		model.addAttribute("list", service.listCriteria(cri));
		PageMaker pageMaker=new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.countPaging(cri));
		model.addAttribute("pageMaker",pageMaker);
	}
	
	
	@RequestMapping(value="/bookRead",method=RequestMethod.GET)
	public void read(@RequestParam("book_id")int book_id, @ModelAttribute("cri")SearchCriteria cri, Model model)throws Exception{
		model.addAttribute(service.read(book_id));
	}
	
	
	@RequestMapping(value="/bookModify",method=RequestMethod.GET)
	public void modifyGET(@RequestParam("book_id")int book_id, BookVO book, Model model)throws Exception
	{
		model.addAttribute(service.read(book_id));
	}
	
	@RequestMapping(value="/bookModify",method=RequestMethod.POST)
	public String modifyPOST(RedirectAttributes rttr, BookVO book, Model model, @ModelAttribute("cri")SearchCriteria cri)throws Exception{
		service.modify(book);
		rttr.addAttribute("page",cri.getPage());
		rttr.addAttribute("perPageNum",cri.getPerPageNum());
		rttr.addAttribute("searchType", cri.getSearchType());
		rttr.addAttribute("keyword", cri.getKeyword());
		return "redirect:/book/bookList";
	}	
}