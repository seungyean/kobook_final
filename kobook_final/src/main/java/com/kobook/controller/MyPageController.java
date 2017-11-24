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

import com.kobook.alarm.domain.AlarmVO;
import com.kobook.alarm.service.AlarmService;
import com.kobook.book.domain.BookVO;
import com.kobook.mypage.service.MyPageService;
import com.kobook.person.domain.PersonVO;

@Controller
@RequestMapping("/mypage/*")
public class MyPageController {

	@Inject
	private MyPageService service;
	
	@Inject
	private AlarmService alarmService;

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
	public String sellStateUpdate(HttpServletRequest request, BookVO book, RedirectAttributes rttr) throws Exception {
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
				
				//"판매가 완료되었습니다." 알림 주는 부분 (아름)
				if(temp.getBook_sell_state().equals("C")) {
					AlarmVO alarmVO = new AlarmVO();
					
					alarmVO.setAlarm_kind("SellBook");
					alarmVO.setAlarm_content("판매가 완료되었습니다.");
					alarmVO.setPerson_id(person_id);
					
					alarmService.alarmMessage(alarmVO);
				}
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
	
	/* 마일리지 내역 */
	@RequestMapping(value = "/mileageList", method = RequestMethod.GET)
	public void mileageList(HttpServletRequest request, Model model) {
		System.out.println("----------------Controller : 마일리지 내역 출력-----------------");
		
		HttpSession session = request.getSession();
		int person_id = Integer.parseInt((String)session.getAttribute("person_id"));
		
		model.addAttribute("mileageList", service.mileageList(person_id));
	}
	
	/* 주문 */
	@RequestMapping(value = "/order", method = RequestMethod.GET)
	public void orderList(HttpServletRequest request, Model model) {
		System.out.println("----------------Controller : 주문 출력-----------------");
		
		HttpSession session = request.getSession();
		int person_id = Integer.parseInt((String)session.getAttribute("person_id"));
		
		List<HashMap<String, String>> list = service.orderList(person_id);
		model.addAttribute("orderList", service.orderList(person_id));
		model.addAttribute( service.orderPerson(person_id));
		
		PersonVO person = service.orderPerson(person_id);
		
		list.get(0).get("book_id");
		
		
		
		
		
		// 휴대폰 - 
		String strPhone[] = person.getPerson_phone().split("-");
		
		model.addAttribute("phone0", strPhone[0]);
		model.addAttribute("phone1", strPhone[1]);
		model.addAttribute("phone2", strPhone[2]);
		
		// 이메일 @
		String strEmail[] = person.getPerson_email().split("@");
		model.addAttribute("email0", strEmail[0]);
		model.addAttribute("email1", strEmail[1]);
		
	}
	
	
	


}
