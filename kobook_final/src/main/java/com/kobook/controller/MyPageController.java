package com.kobook.controller;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kobook.alarm.domain.AlarmMailVO;
import com.kobook.alarm.domain.AlarmVO;
import com.kobook.alarm.service.AlarmService;
import com.kobook.book.domain.BookVO;
import com.kobook.book.service.BookService;
import com.kobook.message.domain.MessageVO;
import com.kobook.mypage.domain.DeliveryVO;
import com.kobook.mypage.domain.MileageVO;
import com.kobook.mypage.domain.MyPageCriteria;
import com.kobook.mypage.domain.MyPageMaker;
import com.kobook.mypage.domain.OrderVO;
import com.kobook.mypage.domain.PayVO;
import com.kobook.mypage.domain.SearchDateCriteria;
import com.kobook.mypage.service.MyPageService;
import com.kobook.person.domain.PersonVO;
import com.kobook.person.service.PersonService;
import com.kobook.util.MediaUtils;

import oracle.net.aso.s;

@Controller
@RequestMapping("/mypage/*")
public class MyPageController {

	@Inject
	private MyPageService service;
	
	@Inject
	private AlarmService alarmService;
	
	   @Inject
	   private PersonService pService;

	   @Autowired
	   private JavaMailSender mailSender;
	
	@Resource(name = "uploadPath")
	private String uploadPath;
	
	//파일(이미지) 출력
		@ResponseBody
		@RequestMapping("/displayFile")
		public ResponseEntity<byte[]> displayFile(String fileName) throws Exception {

			InputStream in = null;
			ResponseEntity<byte[]> entity = null;

			System.out.println("FILE NAME: " + fileName);

			try {

				String formatName = fileName.substring(fileName.lastIndexOf(".") + 1);

				MediaType mType = MediaUtils.getMediaType(formatName);

				HttpHeaders headers = new HttpHeaders();

				in = new FileInputStream(uploadPath + fileName);

				if (mType != null) {
					headers.setContentType(mType);
				} else {

					fileName = fileName.substring(fileName.indexOf("_") + 1);
					headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
					headers.add("Content-Disposition",
							"attachment; filename=\"" + new String(fileName.getBytes("UTF-8"), "ISO-8859-1") + "\"");
				}

				entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);
			} catch (Exception e) {
				e.printStackTrace();
				entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
			} finally {
				in.close();
			}
			return entity;
		}


	/* 판매내역 */
	@RequestMapping(value = "/sellList", method = RequestMethod.GET)
	public void sellList(HttpServletRequest request, Model model,@ModelAttribute("cri") SearchDateCriteria cri) throws Exception{
		System.out.println("----------------Controller : 판매내역 출력-----------------");
		
		HttpSession session = request.getSession();
		int person_id = Integer.parseInt((String)session.getAttribute("person_id"));
		System.out.println(person_id);
		cri.setPerson_id(person_id);
		
		model.addAttribute("sellList", service.sellList(cri));
		
		MyPageMaker pageMaker = new MyPageMaker();
		pageMaker.setCri(cri);
		
		pageMaker.setTotalCount(service.sellCountPaging(cri));
		model.addAttribute("pageMaker", pageMaker);
		
	}
	
	/* 판매상태 변경 */
	@RequestMapping(value = "/sellStateUpdate", method = RequestMethod.POST)
	public String sellStateUpdate(HttpServletRequest request, BookVO book, RedirectAttributes rttr, @ModelAttribute("cri") SearchDateCriteria cri) throws Exception {
		System.out.println("----------------Controller : 판매상태 변경-----------------");
		
		HttpSession session = request.getSession();
		int person_id = Integer.parseInt((String)session.getAttribute("person_id"));
		cri.setPerson_id(person_id);
		
		List<BookVO> booksellList = service.sellList(cri);
		
		for (BookVO bookVO : booksellList) {
			int book_id = bookVO.getBook_id();
			String  book_sell_state = request.getParameter(String.valueOf(book_id));
			
			if(book_sell_state != null && !"".equals(book_sell_state)){
				BookVO temp = new BookVO();
				temp.setBook_id(book_id);
				temp.setBook_sell_state(book_sell_state);
				service.sellStateModify(temp);
				
				//"판매가 완료되었습니다." 알림 주는 부분 (아름)
				if(temp.getBook_sell_state().equals("C")) {
					AlarmVO alarmVO = new AlarmVO();
					AlarmMailVO mailVO = new AlarmMailVO();

					alarmVO.setAlarm_kind("SellBook");
					alarmVO.setAlarm_content("판매가 완료되었습니다.");
					alarmVO.setPerson_id(person_id);
//					mailVO.sendMail(alarmVO,mailSender,pService);
					
					alarmService.alarmMessage(alarmVO);
				}
			}
		}
		
		booksellList = service.sellList(cri);
		request.setAttribute("sellList", booksellList);
		return "redirect:/mypage/sellList";

	}

	/* 구매내역 */
	@RequestMapping(value = "/buyList", method = RequestMethod.GET)
	public void buyList(HttpServletRequest request, Model model, @ModelAttribute("cri") SearchDateCriteria cri )throws Exception {
		System.out.println("----------------Controller : 구매내역 출력-----------------");
		
		HttpSession session = request.getSession();
		int person_id = Integer.parseInt((String)session.getAttribute("person_id"));
		System.out.println(person_id);
		cri.setPerson_id(person_id);
		
		model.addAttribute("buyList", service.buyList(cri));
		
		MyPageMaker pageMaker = new MyPageMaker();
		pageMaker.setCri(cri);

		pageMaker.setTotalCount(service.countPaging(cri));
		model.addAttribute("pageMaker", pageMaker);
	}
	
	/* 찜리스트 */
	@RequestMapping(value = "/pickList", method = RequestMethod.GET)
	public void pickList(HttpServletRequest request, Model model, @ModelAttribute("cri") MyPageCriteria cri)throws Exception {
		System.out.println("----------------Controller : 찜리스트 출력-----------------");
		
		HttpSession session = request.getSession();
		int person_id = Integer.parseInt((String)session.getAttribute("person_id"));
		cri.setPerson_id(person_id);
		
		model.addAttribute("pickList", service.pickList(cri));
		
		MyPageMaker pageMaker = new MyPageMaker();
		pageMaker.setCri(cri);
		
		pageMaker.setTotalCount(service.countPagingPick(cri));
		model.addAttribute("pageMaker", pageMaker);
		
		
	}
	
	/* 찜리스트 상태 변경 */
	@RequestMapping(value = "/pickStateUpdate", method = RequestMethod.GET)
	public String pickStateUpdate(@RequestParam("pick_id") String pick_id, RedirectAttributes rttr)throws Exception {
		System.out.println("----------------Controller :찜리스트 상태 변경-----------------");
		System.out.println(pick_id);
		
		
		String[] pick_id2 = pick_id.split(",");
		
		System.out.println("찜리 : " + pick_id2);
		
		for (int i=0; i<pick_id2.length; i++) {
			service.pickModify(Integer.parseInt(pick_id2[i]));
		}


		
		
		
		
		return "redirect:/mypage/pickList";

	}
	
	/* 마일리지 내역 */
	@RequestMapping(value = "/mileageList", method = RequestMethod.GET)
	public void mileageList(HttpServletRequest request, Model model) throws Exception{
		System.out.println("----------------Controller : 마일리지 내역 출력-----------------");
		
		HttpSession session = request.getSession();
		int person_id = Integer.parseInt((String)session.getAttribute("person_id"));
		
		Integer mileageTotal = service.mileageTotal(person_id);
		Integer mileageUse = service.mileageUse(person_id);
		
		if(mileageTotal == null && mileageUse == null){
			System.out.println("널값이라 들어왔다!!!");
			mileageTotal = 0;
			mileageUse = 0;
			model.addAttribute("mileageTotal", mileageTotal );
			model.addAttribute("mileageUse", mileageUse );
			
		}else{
			System.out.println("널값아니라 안 들어왔다!!!");
			model.addAttribute("mileageTotal", mileageTotal );
			model.addAttribute("mileageUse", mileageUse );
		}
		
	
		model.addAttribute("mileageList", service.mileageList(person_id));
	}
	
	/* 주문 */
	@RequestMapping(value = "/order", method = RequestMethod.GET)
	public void orderList(@RequestParam("book_id") int book_id,HttpServletRequest request, Model model) throws Exception{
		System.out.println("----------------Controller : 주문내역 출력-----------------");
		
		HttpSession session = request.getSession();
		int person_id = Integer.parseInt((String)session.getAttribute("person_id"));
		
		model.addAttribute("book_id", book_id);
		model.addAttribute("oneBook", service.oneBook(book_id));
		model.addAttribute( service.orderPerson(person_id));
		
		System.out.println(service.oneBook(book_id));
		
		PersonVO person = service.orderPerson(person_id);
		
		Integer mileageTotal = service.mileageTotal(person_id);
		Integer mileageUse = service.mileageUse(person_id);
		
		if(mileageTotal == null && mileageUse == null){
			System.out.println("널값이라 들어왔다!!!");
			mileageTotal = 0;
			mileageUse = 0;
			model.addAttribute("mileageTotal", mileageTotal);
			model.addAttribute("mileageUse", mileageUse);
		}else{
			System.out.println("널값아니라 안 들어왔다!!!");
			model.addAttribute("mileageTotal", service.mileageTotal(person_id) );
			model.addAttribute("mileageUse", service.mileageUse(person_id) );
		}
		
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
	
	@RequestMapping(value="/order", method=RequestMethod.POST)
	public String orderSuccessPOST(RedirectAttributes rttr, HttpServletRequest request,
			@RequestParam("book_id") int book_id,
			@RequestParam("total_price2") int total_price,
			@RequestParam("addr") String delivery_address,
			@RequestParam("msg") String delivery_msg,
			@RequestParam("mileageAvg2") int mileageAvg,
			@RequestParam("input_mile2") int input_mile
			)throws Exception{
		System.out.println("주문등록 post~~~~~~~~~~~~~~~~~");
		
		// 주문등록
		OrderVO temp = new OrderVO();
		HttpSession session = request.getSession();
		int person_id = Integer.parseInt((String)session.getAttribute("person_id"));
		
		temp.setPerson_id(person_id);
		temp.setBook_id(book_id);
		System.out.println("주문등록 person_id : " + person_id);
		System.out.println("주문등록 book_id : " + book_id);
		
		//결제등록
		PayVO pay = new PayVO();
		pay.setPay_amount(total_price);
		System.out.println("주문등록 total_price :  " + total_price);
		
		// 배달등록
		DeliveryVO deliveryVO = new DeliveryVO();
		deliveryVO.setDelivery_address(delivery_address);
		deliveryVO.setDelivery_msg(delivery_msg);
		
		System.out.println("주문등록 delivery_address :  " + delivery_address);
		System.out.println("주문등록 delivery_msg :  " + delivery_msg);
		
		// 결제 후 마일리지 적립
		MileageVO mileageVO = new MileageVO();
		mileageVO.setMileage_kind('P');
		mileageVO.setMileage_point(mileageAvg);
		mileageVO.setPerson_id(person_id);
		
		// 결제 후 책 판매상태 변경
		BookVO bookVO = new BookVO();
		bookVO.setBook_id(book_id);
		bookVO.setBook_sell_state("C");
		
		//"판매가 완료되었습니다." 알림 주는 부분 (아름)
		if(bookVO.getBook_sell_state().equals("C")) {
			AlarmVO alarmVO = new AlarmVO();
			AlarmMailVO mailVO = new AlarmMailVO();

			alarmVO.setAlarm_kind("SellBook");
			alarmVO.setAlarm_content("판매가 완료되었습니다.");
			alarmVO.setPerson_id(person_id);
//			mailVO.sendMail(alarmVO,mailSender,pService);
			
			alarmService.alarmMessage(alarmVO);
		}
		
		
		
		if (input_mile != 0) {
			MileageVO mileageVO2 = new MileageVO();
			mileageVO2.setMileage_kind('M');
			mileageVO2.setMileage_point(input_mile);
			mileageVO2.setPerson_id(person_id);
			service.orderRegist(temp, pay, deliveryVO, mileageVO2,bookVO);
		} else{
			service.orderRegist(temp, pay, deliveryVO, mileageVO,bookVO);
		}
		
		
		
		
		return  "redirect:/mypage/orderSuccess";
		
		
	}
	
	/* 판매내역 */
	@RequestMapping(value = "/orderSuccess", method = RequestMethod.GET)
	public void orderSuccess(HttpServletRequest request, Model model)throws Exception {
		System.out.println("----------------Controller : 주문완료 -----------------");
		
		
		
	}
	
	/* 쪽지보관함 */
	@RequestMapping(value = "/messageBox", method = RequestMethod.GET)
	public void messageBox(HttpServletRequest request, Model model, @ModelAttribute("cri") SearchDateCriteria cri) throws Exception{
		System.out.println("----------------Controller : 쪽지보관함 -----------------");
		HttpSession session = request.getSession();
		int person_id = Integer.parseInt((String)session.getAttribute("person_id"));
		System.out.println(person_id);
		cri.setPerson_id(person_id);
		
		List<HashMap<String, String>> list = service.receivedMsgTotal(cri);
		
		for (HashMap<String, String> hashMap : list) {
			System.out.println(hashMap.toString());
		}
		model.addAttribute("receivedMsgTotal", service.receivedMsgTotal(cri));
		
		
		MyPageMaker pageMaker = new MyPageMaker();
		pageMaker.setCri(cri);

		pageMaker.setTotalCount(service.countPaging(cri));
		model.addAttribute("pageMaker", pageMaker);
		
		
	}
	
	/* 쪽지보관함 쪽지읽음 상태변경 */
	@RequestMapping(value = "/msgUpdate", method = RequestMethod.GET)
	public String msgUpdate(@RequestParam("message_id") int message_id, RedirectAttributes rttr)throws Exception {
		System.out.println("----------------Controller :쪽지읽음 상태 변경-----------------");
		System.out.println("컨트롤러에 쪽지번호 들어옴  : " +message_id);
		service.msgModify(message_id);
		
		return "redirect:/mypage/messageBox";
	}
	/* 쪽지보관함 쪽지 삭제 */
	@RequestMapping(value = "/msgDelete")
	public String msgDelete(HttpServletRequest request, @RequestParam("message_id")int message_id, RedirectAttributes rttr) throws Exception {
		System.out.println("----------------Controller : 쪽지 삭제-----------------");
		
		service.msgDelete(message_id);
		
		
		return "redirect:/mypage/messageBox";

	}
	
	


}
