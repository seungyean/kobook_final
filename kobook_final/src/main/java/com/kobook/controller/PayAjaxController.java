package com.kobook.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.kobook.admin.domain.MonthPayVO;
import com.kobook.admin.service.PayService;
import com.kobook.board.domain.BoardVO;
import com.kobook.board.service.BoardService;
import com.kobook.book.domain.SearchCriteria;
import com.kobook.community.domain.BlackVO;
import com.kobook.community.domain.DonateVO;
import com.kobook.community.service.BlackService;
import com.kobook.community.service.DonateService;

@RestController
@RequestMapping("/pay/*")
public class PayAjaxController {

	@Inject
	private PayService service;
	
	@Inject
	private DonateService donateservice;
	
	@Inject
	private BlackService blackservice;
	
	@Inject
	private BoardService boardservice;


	private ArrayList<?> listt;

	
	
	@RequestMapping(value="/payList", method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<HashMap<String, List<Integer>>> payMonthListPOST(@RequestParam("pay_date") String pay_date)throws Exception {
		
		ResponseEntity<HashMap<String, List<Integer>>> entity = null;
		HashMap<String, List<Integer>> map = new HashMap<>();
		List<Integer> list = new LinkedList<>();
		int sum = 0;
		try {
			for(int i=0; i<12; i++){
				if(i<9){
					sum = service.paySum(pay_date.substring(2)+"/0"+(i+1)+"%");
					list.add(sum);
				}else {
					sum = service.paySum(pay_date.substring(2)+"/"+(i+1)+"%");
					list.add(sum);
				}
			}
			map.put("month", list);
			entity = new ResponseEntity<HashMap<String, List<Integer>>>(map, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<HashMap<String, List<Integer>>>(HttpStatus.BAD_REQUEST);
		}
			
		return entity;
	}
	

	@ResponseBody	
	@RequestMapping(value="/notiList", method=RequestMethod.POST)
	public ResponseEntity<List<?>> notiListPOST(@RequestParam("noti_select") String noti_select, SearchCriteria cri) throws Exception {

		ResponseEntity<List<?>> entity = null;
		List<?> list = null ;
		
		System.out.println("선택한 게시판: "+ noti_select);
		try {
			/*System.out.println(cri);*/
			if(noti_select.equals("sin")){
				list = blackservice.blackList(cri);
				System.out.println(list);
			} else if(noti_select.equals("mu")){
				list = donateservice.donateList(cri);
				System.out.println(list);
			} else if(noti_select.equals("pho")){
				
			} else if(noti_select.equals("gong")){
				list = boardservice.boardListCri(cri);
				System.out.println(list);
			}
			
			entity = new ResponseEntity<List<?>>(list, HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<List<?>>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	
}
