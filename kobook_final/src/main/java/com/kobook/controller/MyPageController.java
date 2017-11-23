package com.kobook.controller;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kobook.book.domain.BookVO;
import com.kobook.mypage.service.MyPageService;

@Controller
@RequestMapping("/mypage/*")
public class MyPageController {

	@Inject
	private MyPageService service;

	/* 판매내역 */
	@RequestMapping(value = "/sellList", method = RequestMethod.GET)
	public void sellList(HttpServletRequest request, Model model) {
		System.out.println("----------------Controller : 판매내역 출력-----------------");
		
		HttpSession session = request.getSession();
		int person_id = Integer.parseInt((String)session.getAttribute("person_id"));
		
		
		model.addAttribute("sellList", service.sellList(person_id));
	}
	
	/* 판매상태 변경 */
	@RequestMapping(value = "/sellStateUpdate", method = RequestMethod.POST)
	public String sellStateUpdate(HttpServletRequest request, BookVO book, RedirectAttributes rttr) {
		System.out.println("----------------Controller : 판매상태 변경-----------------");
		
		HttpSession session = request.getSession();
		int person_id = Integer.parseInt((String)session.getAttribute("person_id"));
		
		List<BookVO> booksellList = service.sellList(person_id);
		
		for (BookVO bookVO : booksellList) {
			int book_id = bookVO.getBook_id();
			String  book_sell_state = request.getParameter(String.valueOf(book_id));
			
			if(book_sell_state != null && !"".equals(book_sell_state)){
				BookVO temp = new BookVO();
				temp.setBook_id(book_id);
				temp.setBook_sell_state(book_sell_state);
				service.sellStateUpdate(temp);
			}
		}
		
		booksellList = service.sellList(person_id);
		request.setAttribute("sellList", booksellList);
		return "redirect:/mypage/sellList";

	}

	/* 구매내역 */
	@RequestMapping(value = "/buyList", method = RequestMethod.GET)
	public void buyList(HttpServletRequest request, Model model) {
		System.out.println("----------------Controller : 구매내역 출력-----------------");
		
		HttpSession session = request.getSession();
		int person_id = Integer.parseInt((String)session.getAttribute("person_id"));
		System.out.println(service.buyList(person_id).toString());
		model.addAttribute("buyList", service.buyList(person_id));
	}
	
	/* 찜리스트 */
	@RequestMapping(value = "/pickList", method = RequestMethod.GET)
	public void pickList(HttpServletRequest request, Model model) {
		System.out.println("----------------Controller : 찜리스트 출력-----------------");
		
		HttpSession session = request.getSession();
		int person_id = Integer.parseInt((String)session.getAttribute("person_id"));
		
		List<HashMap<String, String>> pickList = service.pickList(person_id);
		request.setAttribute("pickList", pickList);
		model.addAttribute("pickList", service.pickList(person_id));
	}
	
	/* 찜리스트 상태 변경 */
	@RequestMapping(value = "/pickStateUpdate", method = RequestMethod.GET)
	public String pickStateUpdate(@RequestParam("pick_id") int pick_id, RedirectAttributes rttr) {
		System.out.println("----------------Controller :찜리스트 상태 변경-----------------");
		System.out.println(pick_id);
		service.pickUpdate(pick_id);
		
		return "redirect:/mypage/pickList";

	}
	

}
