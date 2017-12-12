package com.kobook.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kobook.book.domain.BookVO;
import com.kobook.book.domain.SearchCriteria;
import com.kobook.book.service.BookService;

/**
 * Handles requests for the application home page.
 */

//맨 처음 프로그램을 구동했을 때 도착하는 컨트롤러
//메인 화면을 추출하는 컨트롤러. recomController의 /main과 같은 역할을 한다.

@Controller
public class HomeController {
	
	@Inject
	private BookService bookService;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 * @throws Exception 
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest request) throws Exception {

		
		
		SearchCriteria cri2 = new SearchCriteria();
		cri2.setPerPageNum(10);
		List<BookVO> bookList = bookService.listCriteria(cri2);

		request.setAttribute("bookList", bookList);
		
		return "main";
	}
	
}
