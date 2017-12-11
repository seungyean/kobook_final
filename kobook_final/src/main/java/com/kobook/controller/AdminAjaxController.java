package com.kobook.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



import com.kobook.admin.service.PayService;
import com.kobook.admin.service.VisitService;

import com.kobook.board.service.BoardService;
import com.kobook.book.domain.SearchCriteria;

import com.kobook.community.service.BlackService;
import com.kobook.community.service.DonateService;
import com.kobook.community.service.PhotoReviewService;
import com.kobook.person.domain.PersonVO;


@RestController
@RequestMapping("/pay/*")
public class AdminAjaxController {

	@Inject
	private PayService service;
	
	@Inject
	private DonateService donateservice;
	
	@Inject
	private BlackService blackservice;
	
	@Inject
	private BoardService boardservice;

	@Inject
	private PhotoReviewService photoservice;
	
	@Inject
	private VisitService visitservice;

	

	
	//매출금액 리스트
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
					if(i==0) {
						// 전년도 12월
						sum = service.paySum(Integer.parseInt(pay_date.substring(2))-1+"/12");
						list.add(sum);
					}
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

	//게시판관리 list
	@RequestMapping(value="/notiList", method=RequestMethod.POST)
	@ResponseBody	
	public ResponseEntity<List<?>> notiListPOST(@RequestParam("noti_select") String noti_select, SearchCriteria cri) throws Exception {

		ResponseEntity<List<?>> entity = null;
		List<?> list = null ;
		
		try {
			if(noti_select.equals("sin")){
				list = blackservice.blackList(cri);
				System.out.println(list);
			} else if (noti_select.equals("mu")){
				list = donateservice.donateList(cri);
				System.out.println(list);
			} else if (noti_select.equals("pho")){
				list = photoservice.photoList(cri);
				System.out.println(list);
			} else if (noti_select.equals("gong")){
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
	
	//선택한 게시물 삭제
	@RequestMapping(value="/notiRemove", method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> notiRemovePOST(@RequestParam("kind")String kind, @RequestParam("num") Integer num)throws Exception {
		
		ResponseEntity<String> entity = null;
		
		try {
			if(kind.equals("sin")){
				blackservice.blackRemove(num);
			}else if(kind.equals("mu")){
				donateservice.donateRemove(num);
			}else if(kind.equals("pho")){
				photoservice.photoReviewRemove(num);
			}else if(kind.equals("gong")){
				boardservice.boardRemove(num);
			}
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}

		return entity;
	}
	
	@RequestMapping(value="/visitCount", method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Integer> visitCountPOST() throws Exception {
		
		ResponseEntity<Integer> entity = null;
		
		int count ;
		try {
			count = visitservice.visitCount();
			entity = new ResponseEntity<Integer>(count ,HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<Integer>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	@RequestMapping(value="/personModi", method=RequestMethod.POST)
	@ResponseBody	
	public ResponseEntity<String> personModiPOST(SearchCriteria cri, @RequestParam("person_kind") String person_kind, 
			@RequestParam("person_sell_grade") String person_sell_grade, @RequestParam("person_id") int person_id) throws Exception {
	
		ResponseEntity<String> entity = null;
		PersonVO vo = new PersonVO();
		vo = boardservice.personRead(person_id);
		vo.setPerson_kind(person_kind);
		vo.setPerson_sell_grade(person_sell_grade);
		
		try {
			
			boardservice.personModify(vo);
			entity = new ResponseEntity<String>("SUCCESS",HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	@RequestMapping(value="/personRemove", method=RequestMethod.POST)
	@ResponseBody	
	public ResponseEntity<String> personRemovePOST(SearchCriteria cri, @RequestParam("person_id") int person_id)throws Exception {
		
		ResponseEntity<String> entity = null;
		System.out.println(person_id);
		
		try {
			boardservice.personRemove(person_id);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	@RequestMapping(value="/personTotal", method=RequestMethod.POST)
	@ResponseBody	
	public ResponseEntity<List<HashMap<String, String>>> personTotal() throws Exception  {
		
		ResponseEntity<List<HashMap<String, String>>> entity = null;
		
		List<Map<String, String>> list = visitservice.visitCountView();
		List<HashMap<String, String>> replaceList = new ArrayList<HashMap<String,String>>();
		
		for(int i = 0; i < list.size(); i++){
			
			HashMap<String, String> map = (HashMap<String, String>) list.get(i);
			String visitDate = "";
			
			System.out.println(i+ " in list for : "+map);
			System.out.println(i+ " in key for : "+map.keySet());

			java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd");
			
			String[] key = new String[map.keySet().size()];
			map.keySet().toArray(key);
			
			HashMap<String, String> mapList = new HashMap<String,String>();
			for (int j = 0; j < key.length; j++) {
				
				System.out.println("replaceListMAp key : " + key[j]);
				
				if (key[j].equals("VISITDATE")) {
					visitDate = formatter.format(map.get(key[j]));
					mapList.put(key[j], visitDate);
					System.out.println("key : " + key[j] + " value : " + visitDate);
				}else{
					System.out.println("key : " + key[j] + " value : " + String.valueOf(map.get(key[j])));
					mapList.put(key[j], String.valueOf(map.get(key[j])));
				}		
								
			}
			
			replaceList.add(mapList);
		}	
		try {
			entity = new ResponseEntity<List<HashMap<String,String>>>(replaceList,HttpStatus.OK);
		} catch (Exception e) {
			entity = new ResponseEntity<List<HashMap<String,String>>>(HttpStatus.BAD_REQUEST);
		}
		System.out.println(replaceList);
		return entity;
	}
	
}
