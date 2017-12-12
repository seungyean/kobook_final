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
public class BookController {

	@Resource(name="uploadPath")
	private String uploadPath;
	
	@Inject
	private BookService service;
	
	@Inject
	private TodayService todayService;
	
	//책 등록
	@RequestMapping(value="/bookRegist",method=RequestMethod.GET)
	public void bookRegistGET(BookVO book, Model model)throws Exception{
	}
	
	
	//책등록(이미지등록포함)
	@RequestMapping(value="/bookRegist",method=RequestMethod.POST)
	public String bookRegistPOST( BookVO book,Model model,@RequestParam("file")MultipartFile file) throws Exception{
		
		System.out.println(file.getOriginalFilename());
        System.out.println(file.getSize());
        System.out.println(file.getContentType());
        
        String savedName=uploadFile(file.getOriginalFilename(), file.getBytes());
       
        System.out.println(book.toString()); 
        book.setBook_img(savedName);
		service.regist(book);
		return "redirect:/book/bookList";
		
	}
	
	//책수정
	@RequestMapping(value="/bookModify",method=RequestMethod.GET)
	public void modifyGET(@RequestParam("book_id")int book_id, BookVO book, Model model)throws Exception
	{
		model.addAttribute(service.read(book_id));

	}
	
	//책수정
	@RequestMapping(value="/bookModify",method=RequestMethod.POST)
	public String modifyPOST(@RequestParam("book_id")int book_id,RedirectAttributes rttr, BookVO book, @ModelAttribute("cri") SearchCriteria cri, Model model,@RequestParam("file")MultipartFile file)throws Exception{
		
		 String savedName=uploadFile(file.getOriginalFilename(), file.getBytes());
		 System.out.println("book정보:"+book.toString());
	       book.setBook_img(savedName);
		
		 
		service.modify(book);
		 System.out.println("책정보:"+book.toString()); 
		rttr.addAttribute("page",cri.getPage());
		rttr.addAttribute("perPageNum",cri.getPerPageNum());
		return "redirect:/book/bookList";
	}	
	
	
	//이미지 보여주는부분
	@ResponseBody
    @RequestMapping(value="/displayFile",method=RequestMethod.GET)
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
    
    
    //책 리스트 보여주기
    @RequestMapping("/bookList")
	public void list(@ModelAttribute("cri") SearchCriteria cri, Model model)throws Exception{
    		System.out.println("검색내용 없을 때 null이어야함:"+cri.getKeyword());
    		service.listCriteria(cri);
    		
    		PageMaker pageMaker=new PageMaker();
    		pageMaker.setCri(cri);
    		pageMaker.setTotalCount(service.countPaging(cri));
    		model.addAttribute("pageMaker",pageMaker);

        //검색값 있을때,없을때 다보여줘야함(책리스트, 인기검색어리스트,)
    	model.addAttribute("list", service.listCriteria(cri));
    	model.addAttribute("rankingList", service.rankingList());
	}
    
    
    //인기검색어
    @RequestMapping(value="/rankingRegist",method=RequestMethod.POST)
	public String rankingRegistPOST(@ModelAttribute("cri") SearchCriteria cri,Model model,RedirectAttributes rttr)throws Exception{
    	System.out.println(cri.getKeyword());
    	RankingVO ranking=new RankingVO();
    	ranking.setRanking_keyword(cri.getKeyword());
    	service.registerkeyword(cri);
    	System.out.println("등록된값: "+ranking.getRanking_keyword());
    	
    	rttr.addAttribute("page", cri.getPage());
        rttr.addAttribute("perPageNum", cri.getPerPageNum());
        rttr.addAttribute("searchType", cri.getSearchType());
        rttr.addAttribute("keyword", cri.getKeyword());
    	return "redirect:/book/bookList";
    }

    
    
	//지역검색
	@RequestMapping("/booklocationList")
	public void locationlist(@ModelAttribute("cri") SearchCriteria cri, Model model)throws Exception{
		model.addAttribute("list", service.directListCriteria(cri));
		model.addAttribute("list2", service.safeListCriteria(cri));
		
		PageMaker pageMaker=new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.directListCount());
		model.addAttribute("pageMaker",pageMaker);
		
		PageMaker pageMaker2=new PageMaker();
		pageMaker2.setCri(cri);
		pageMaker2.setTotalCount(service.safeListCount());
		model.addAttribute("pageMaker2",pageMaker2);
	}
	
	
	//책 상세보기 부분 
	@RequestMapping(value="/bookRead",method=RequestMethod.GET)
	public void read(@RequestParam("book_id")int book_id, PersonDTO person, Model model,
			@ModelAttribute("cri") SearchCriteria cri, HttpServletRequest request)throws Exception{
		System.out.println("readCon: book_id: " + book_id);
		model.addAttribute(service.read(book_id));
		
		model.addAttribute("s",service.readSellPerson(service.getPersonIdByBookId(book_id)));
		
		model.addAttribute("countstar",service.countStar(service.getPersonIdByBookId(book_id)));
		
		model.addAttribute("reviewcount",service.countReview(service.getPersonIdByBookId(book_id)));

		model.addAttribute("reviewList", service.reviewList(service.getPersonIdByBookId(book_id), cri));
		
		model.addAttribute("fivestar",service.fivestar(service.getPersonIdByBookId(book_id)));
		model.addAttribute("fourstar",service.fourstar(service.getPersonIdByBookId(book_id)));
		model.addAttribute("threestar",service.threestar(service.getPersonIdByBookId(book_id)));
		model.addAttribute("twostar",service.twostar(service.getPersonIdByBookId(book_id)));
		model.addAttribute("onestar",service.onestar(service.getPersonIdByBookId(book_id)));

		model.addAttribute("slist",service.sellPersonList(service.getPersonIdByBookId(book_id),book_id));
		
		PageMaker pageMaker=new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.countReview(service.getPersonIdByBookId(book_id)));
		model.addAttribute("pageMaker",pageMaker);
		
		

		
		
		HttpSession session = request.getSession(false);
		if(session.getAttribute("person_id") != null) {
			Integer person_id = Integer.parseInt((String)session.getAttribute("person_id"));
		
			TodayVO todayVO = new TodayVO();
			
			if(service.getPersonIdByBookId(book_id) != person_id) {
			
				if(todayService.checkPersonIdByBookID(book_id, person_id) == 0) {
					todayVO.setBook_id(book_id);
					todayVO.setPerson_id(person_id);
					todayService.todayRegist(todayVO);
					}
				}
			}
		}
		

	//후기등록(pay_id 가져오는 부분)
	@RequestMapping(value="/bookreviewRegist",method=RequestMethod.GET)
	public void reviewRegist(Model model,@RequestParam("pay_id")int pay_id)throws Exception{
		System.out.println("후기등록 form");
		
		ReviewVO reviewVO = new ReviewVO();
		reviewVO.setPay_id(pay_id);
		model.addAttribute("pay_id", reviewVO.getPay_id());
		System.out.println("pay_id값: "+reviewVO.getPay_id());
	}
	
	
	//후기등록(후기 내용전체등록)
	@RequestMapping(value="/bookreviewRegist",method=RequestMethod.POST)
	public void reviewRegistPOST(@RequestParam("pay_id") int pay_id,  ReviewVO review, Model model)throws Exception{
		 System.out.println("후기 값 넘어가ㄴ기전");
		 System.out.println("등록전: "+review.toString());
	     service.reviewregist(review);
	     System.out.println("등록후: "+review.toString());
	}
	
	
	
	//책 이미지등록시(파일이름앞에 uuid붙는 부분)
	private String uploadFile(String originalName, byte[] fileData) throws Exception{
        UUID uid=UUID.randomUUID();     
        String savedName=uid.toString()+"_"+originalName;
        File target=new File(uploadPath,savedName);
       FileCopyUtils.copy(fileData, target);  
        return savedName;
		}
	
	//찜하기
	@RequestMapping(value="/pick")
	public String pick(PickVO pick, Model model)throws Exception{
		System.out.println("PICK컨트롤러 진입");
		service.pick(pick);
		System.out.println("pick 상태");
		return "redirect:/mypage/pickList";
	}
	
	
	
}