package com.kobook.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kobook.book.domain.BookVO;
import com.kobook.login.service.PersonService;
import com.kobook.mypage.service.MyPageService;

@Controller
@RequestMapping("/mypage/*")
public class MyPageController {

	@Inject
	private MyPageService myPageService;

	/* 판매내역 */
	@RequestMapping(value = "/sellList", method = RequestMethod.GET)
	public void sellList(int person_id, Model model) {
		System.out.println("판매내역 출력~~~~~~~~~~~");

		model.addAttribute("sellList", myPageService.sellList(person_id));
	}

	/* 판매상태 변경 */
	@RequestMapping(value = "/sellStateUpdate", method = RequestMethod.GET)
	public void sellStateUpdateGET(int person_id, Model model) {
		System.out.println("판매상태 변경 GET!!!!");
		model.addAttribute("sellList", myPageService.sellList(person_id));
	}

	@RequestMapping(value = "/sellStateUpdate", method = RequestMethod.POST)
	public String sellStateUpdatePOST(BookVO book, RedirectAttributes rttr) {
		System.out.println("판매상태 변경 POST!!!!");
		myPageService.sellStateUpdate(book);
		return "redirect:/mypage/sellList";

	}

	/* 구매내역 */
	@RequestMapping(value = "/buyList", method = RequestMethod.GET)
	public void buyList(int person_id, Model model) {
		System.out.println("구매내역 출력~~~~~~~~~~~");

		model.addAttribute("buyList", myPageService.buyList(person_id));
	}

}
