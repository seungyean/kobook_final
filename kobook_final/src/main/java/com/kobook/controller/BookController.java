package com.kobook.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kobook.domain.book.BookVO;
import com.kobook.service.book.BookService;

@Controller
@RequestMapping("/book/*")
public class BookController {

	@Inject
	private BookService service;
	
	@RequestMapping(value="bookinsertForm",method=RequestMethod.GET)
	public void bookinsertFormGET(BookVO book, Model model)throws Exception{
	}
	
	@RequestMapping(value="bookinsertForm",method=RequestMethod.POST)
	public String bookinsertFormPOST(BookVO book, RedirectAttributes rttr)throws Exception{
		service.regist(book);
		return "redirect:/book/booklist";
		
	}
	
}
