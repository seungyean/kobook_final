package com.kobook.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kobook.book.domain.PickVO;
import com.kobook.book.domain.RankingVO;
import com.kobook.book.domain.ReviewVO;
import com.kobook.book.domain.BookVO;
import com.kobook.book.domain.DateDTO;
import com.kobook.book.domain.DeliveryDTO;
import com.kobook.book.domain.PageMaker;
import com.kobook.book.domain.PersonDTO;
import com.kobook.book.domain.SearchCriteria;
import com.kobook.book.service.BookService;
import com.kobook.book.service.DeliveryService;
import com.kobook.chatbot.domain.ChatlogVO;
import com.kobook.community.domain.BlackVO;
import com.kobook.mypage.domain.DeliveryVO;
import com.kobook.mypage.domain.MileageVO;
import com.kobook.mypage.domain.MyPageMaker;
import com.kobook.mypage.domain.SearchDateCriteria;
import com.kobook.person.domain.PersonVO;
import com.kobook.sidebar.domain.TodayVO;
import com.kobook.sidebar.service.TodayService;
import com.kobook.util.MediaUtils;
import com.kobook.util.UploadFileUtils;

@Controller
@RequestMapping("/book/*")
public class DeliveryController {

	@Resource(name="uploadPath")
	private String uploadPath;
	
	@Inject
	private DeliveryService service;
	
	@Inject
	private TodayService todayService;
	
	//관리자 배송관리 부분
	@RequestMapping("/delivery")
	public String deliveryList(@ModelAttribute("cri") SearchCriteria cri, Model model, DateDTO dto)throws Exception{
		System.out.println("----------------Controller : delivery컨트롤러-----------------");
		
		System.out.println("----");	
		
		model.addAttribute("wpercent", service.wpercent());
		model.addAttribute("ipercent", service.ipercent());
		model.addAttribute("cpercent", service.cpercent());
		
		//달별 통계
		model.addAttribute("janmonth", service.month(-11));
		model.addAttribute("febmonth", service.month(-10));
		model.addAttribute("marmonth", service.month(-9));
		model.addAttribute("aprmonth", service.month(-8));
		model.addAttribute("maymonth", service.month(-7));
		model.addAttribute("junmonth", service.month(-6));
		model.addAttribute("julmonth", service.month(-5));
		model.addAttribute("augmonth", service.month(-4));
		model.addAttribute("sepmonth", service.month(-3));
		model.addAttribute("octmonth", service.month(-2));
		model.addAttribute("novmonth", service.month(-1));
		model.addAttribute("decmonth", service.month(0));
		
		
		//오늘매출
		model.addAttribute("todayMoney", service.todayMoney());
		
		PageMaker pageMaker=new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.countdelList());
		model.addAttribute("pageMaker",pageMaker);
		return "/book/delivery";
	}
	

	//기간별 날짜조회(관리자 배송조회)
	@ResponseBody
	@RequestMapping(value="/deliverydate/{startday}/{endday}", method=RequestMethod.GET)
	public ResponseEntity<List<DeliveryDTO>> deliverydate(@PathVariable("startday") String startday, @PathVariable("endday") String endday)throws Exception{

		System.out.println("deliverydate  컨트롤러진입--------------");
		
		DateDTO dto=new DateDTO();
		dto.setStartday(startday);
		dto.setEndday(endday);
		System.out.println(dto.toString());
	
		ResponseEntity<List<DeliveryDTO>> entity =null;
		
		try {
			
			entity=new ResponseEntity<List<DeliveryDTO>>(service.selectDateList(dto),HttpStatus.OK);
			System.out.println("success : " + service.selectDateList(dto));
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
		
	}
	
	
	
	//배송상태(배송중,배송준비중,배송완료)변경부분
	@ResponseBody
	@RequestMapping(value="/deliveryAjax", method=RequestMethod.GET)
	public ResponseEntity<List> deliveryAjaxPost(SearchCriteria cri,@RequestParam(value="delivery_id", required=false)Integer delivery_id, 
			@RequestParam(value="delivery_state", required=false)String delivery_state,Model model)throws Exception{
		
		System.out.println("---------------배송상태 변경부분 컨트롤러진입--------------------");
		System.out.println("delivery_id : " + delivery_id);
		System.out.println("delivery_state : " + delivery_state);
	
		ResponseEntity<List> entity =null;
		
		DeliveryDTO delivery=new DeliveryDTO();
		delivery.setDelivery_id(delivery_id);
		delivery.setDelivery_state(delivery_state);
		
		List<Integer> list = new ArrayList<Integer>();
		
		
		try {
			service.delstateUpdate(delivery);
			
				list.add( service.wpercent());
				list.add( service.ipercent());
				list.add( service.cpercent());
			
			entity=new ResponseEntity<List>(list, HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

	
}