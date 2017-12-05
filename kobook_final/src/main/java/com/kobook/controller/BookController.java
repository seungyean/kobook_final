package com.kobook.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
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
import com.kobook.mypage.domain.DeliveryVO;
import com.kobook.mypage.domain.MileageVO;
import com.kobook.person.domain.PersonVO;
import com.kobook.today.domain.TodayVO;
import com.kobook.today.service.TodayService;
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
	
	//愿�由ъ�� ���댁�
	@RequestMapping("/delivery")
	public void deliveryList(@ModelAttribute("cri") SearchCriteria cri, Model model, DateDTO dto)throws Exception{
		System.out.println("----------------Controller : delivery컨트롤러-----------------");
		
		//model.addAttribute("dlist",service.deliveryList(cri));
		//System.out.println(service.deliveryList(cri).toString());
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
	}
	
/*	@RequestMapping(value="/delivery" , method=RequestMethod.POST)
	public void deliveryListPOST(@ModelAttribute("cri") SearchCriteria cri, Model model, DateDTO dto)throws Exception{
		
		System.out.println("delivery post 컨트롤러 진입");
				//기간별날짜조회
				System.out.println("시작일"+dto.getStartday());
				System.out.println("끝일"+dto.getEndday());
				//dto.setStartday(startday);
				//model.addAttribute("selectDate", service.selectDate(dto));
				//model.addAttribute("selectDate", service.selectDateList(dto));
	}*/
	

/*	@ResponseBody
	@RequestMapping(value="/deliverydateAjax", method=RequestMethod.POST)
	public ResponseEntity<List<HashMap<String, String>>> deliverydateAjaxPOST(SearchCriteria cri,@RequestBody DateDTO dto)throws Exception{

		System.out.println("deliverydateAjax post 컨트롤러진입--------------");
		
		DateDTO dto=new DateDTO();
		dto.setStartday(startday);
		dto.setEndday(endday);
		
		System.out.println(dto.toString());
		ResponseEntity<List<HashMap<String, String>>> entity =null;
		
		try {
			//service.selectDateList(dto);
			entity = new ResponseEntity<List<HashMap<String, String>>>(service.deliveryList(cri),HttpStatus.OK);
			System.out.println(service.deliveryList(cri));
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
		
	}*/
	
	
	
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
			//service.selectDateList(dto);
			entity=new ResponseEntity<List<DeliveryDTO>>(service.selectDateList(dto),HttpStatus.OK);
			//entity = new ResponseEntity<List<DeliveryDTO>>(service.selectDateList(dto), HttpStatus.OK);
			System.out.println("success : " + service.selectDateList(dto));
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
		
	}
	
	
		/*List<HashMap<String, String>> list = null;
		HashMap<String, String> map = new HashMap<>();
		list = service.deliveryList(cri);
		
		for(int i=0;i<list.size();i++){
		String del_id=String.valueOf(((Map<String, String>)list.get(i)).get("d_id"));
		}		
		ResponseEntity<List<HashMap<String, String>>> entity =null;
		
		DateDTO dto=new DateDTO();
		dto.setStartday(startday);
		dto.setEndday(endday);
		

		
		try {
			service.selectDateList(dto);
			entity=new ResponseEntity<List<HashMap<String,String>>>(service.deliveryList(cri), HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		System.out.println(service.selectDateList(dto));
*/
	

	
	
	
	
	@ResponseBody
	@RequestMapping(value="/deliveryAjax", method=RequestMethod.POST)
	public ResponseEntity<List<HashMap<String, String>>> deliveryAjaxPost(SearchCriteria cri,@RequestParam(value="d_id", required=false) int d_id, @RequestParam(value="check", required=false) char check)throws Exception{
		System.out.println("d_id : " + d_id);
		System.out.println("check : " + check);
	
/*		List<HashMap<String, String>> list = null;
		HashMap<String, String> map = new HashMap<>();
		list = service.deliveryList(cri);
		
		for(int i=0;i<list.size();i++){
		String del_id=String.valueOf(((Map<String, String>)list.get(i)).get("d_id"));
		}		*/
		ResponseEntity<List<HashMap<String, String>>> entity =null;
		
		DeliveryVO delivery=new DeliveryVO();
		delivery.setDelivery_id(d_id);
		delivery.setDelivery_state(check);
		
		

		try {
			service.delstateUpdate(delivery);
			entity=new ResponseEntity<List<HashMap<String,String>>>(service.deliveryList(cri), HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		System.out.println(service.deliveryList(cri));
		

		return entity;
	}
	
	@RequestMapping(value="/bookRegist",method=RequestMethod.GET)
	public void bookRegistGET(BookVO book, Model model)throws Exception{
	}
	
	

	@RequestMapping(value="/bookRegist",method=RequestMethod.POST)
	public String bookRegistPOST(BookVO book,Model model,@RequestParam("file")MultipartFile file) throws Exception{
		
		
		System.out.println(file.getOriginalFilename());
        System.out.println(file.getSize());
        System.out.println(file.getContentType());
        
        String savedName=uploadFile(file.getOriginalFilename(), file.getBytes());

       // UploadFileUtils.uploadFile(uploadPath, file.getOriginalFilename(), file.getBytes());
       
        System.out.println(book.toString()); 
        book.setBook_img(savedName);
		service.regist(book);
		return "redirect:/book/bookList";
		
	}
	
	@RequestMapping(value="/bookModify",method=RequestMethod.GET)
	public void modifyGET(@RequestParam("book_id")int book_id, BookVO book, Model model)throws Exception
	{
		model.addAttribute(service.read(book_id));

	}
	
	@RequestMapping(value="/bookModify",method=RequestMethod.POST)
	public String modifyPOST(@RequestParam("book_id")int book_id,RedirectAttributes rttr, BookVO book, @ModelAttribute("cri") SearchCriteria cri, Model model,@RequestParam("file")MultipartFile file)throws Exception{
		
		 String savedName=uploadFile(file.getOriginalFilename(), file.getBytes());
		 System.out.println("쩌철�짚�체:"+book.toString());
	       book.setBook_img(savedName);
		
		 
		service.modify(book);
		 System.out.println("쩌철�짚��:"+book.toString()); 
		rttr.addAttribute("page",cri.getPage());
		rttr.addAttribute("perPageNum",cri.getPerPageNum());
		//rttr.addAttribute("searchType", cri.getSearchType());
		//rttr.addAttribute("keyword", cri.getKeyword());
		return "redirect:/book/bookList";
	}	
	
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

    
    
	
	@RequestMapping("/booklocationList")
	public void locationlist(@ModelAttribute("cri") SearchCriteria cri, Model model)throws Exception{
		model.addAttribute("list", service.directListCriteria(cri));
		model.addAttribute("list2", service.safeListCriteria(cri));
		
/*		PageMaker pageMaker=new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.directListCount());
		model.addAttribute("pageMaker",pageMaker);
		
		
		PageMaker pageMaker2=new PageMaker();
		pageMaker2.setCri(cri);
		pageMaker2.setTotalCount(service.safeListCount());
		model.addAttribute("pageMaker2",pageMaker2);*/
		
		
		PageMaker pageMaker=new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.countPaging(cri));
		model.addAttribute("pageMaker",pageMaker);
	}
	
	
	@RequestMapping(value="/bookRead",method=RequestMethod.GET)
	public void read(@RequestParam("book_id")int book_id, PersonDTO person, Model model,
			@ModelAttribute("cri") SearchCriteria cri, HttpServletRequest request)throws Exception{
		System.out.println("readCon: book_id: " + book_id);
		model.addAttribute(service.read(book_id));
	
		PersonVO vo=new PersonVO();
		vo.setPerson_name(service.writeName(service.getPersonIdByBookId(book_id)));
		
		//��留ㅼ����蹂대낫�ъ＜湲�
		model.addAttribute("s",service.readSellPerson(service.getPersonIdByBookId(book_id)));
		
		//珥�蹂���
		model.addAttribute("countstar",service.countStar(service.getPersonIdByBookId(book_id)));
		
		//由щ럭 媛���
		model.addAttribute("reviewcount",service.countReview(service.getPersonIdByBookId(book_id)));

		//��留ㅼ�� ��湲� 由ъ�ㅽ��
		model.addAttribute("reviewList", service.reviewList(service.getPersonIdByBookId(book_id), cri));
		
		//由щ럭 ���깆��
		model.addAttribute("reviewer", vo.getPerson_name());
		
		//5�� 以� �щ�� ��,4,3,2,1
		model.addAttribute("fivestar",service.fivestar(service.getPersonIdByBookId(book_id)));
		model.addAttribute("fourstar",service.fourstar(service.getPersonIdByBookId(book_id)));
		model.addAttribute("threestar",service.threestar(service.getPersonIdByBookId(book_id)));
		model.addAttribute("twostar",service.twostar(service.getPersonIdByBookId(book_id)));
		model.addAttribute("onestar",service.onestar(service.getPersonIdByBookId(book_id)));
		
		
		
		
		model.addAttribute("slist",service.sellPersonList(service.getPersonIdByBookId(book_id)));
		
		PageMaker pageMaker=new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.countReview(service.getPersonIdByBookId(book_id)));
		model.addAttribute("pageMaker",pageMaker);
		
		TodayVO todayVO = new TodayVO();
		HttpSession session = request.getSession();
		int person_id = Integer.parseInt((String)session.getAttribute("person_id"));
		
		if(todayService.checkPersonIdByBookID(book_id, person_id) == 0) {
			todayVO.setBook_id(book_id);
			todayVO.setPerson_id(person_id);
			todayService.todayRegist(todayVO);
		}
	}
	

	@RequestMapping(value="/bookreviewRegist",method=RequestMethod.GET)
	public void reviewRegist(Model model,@RequestParam("pay_id")int pay_id)throws Exception{
		System.out.println("由щ럭���� �� form");
		
		ReviewVO reviewVO = new ReviewVO();
		reviewVO.setPay_id(pay_id);
		model.addAttribute("pay_id", reviewVO.getPay_id());
		
		
		/*reviewVO.setReview_star(reviewVO.getReview_star());
		model.addAttribute("review_star",reviewVO.getReview_star());*/
		
		
		System.out.println("寃곗��踰���: "+reviewVO.getPay_id());
		
		
	}
	
	
	@RequestMapping(value="/bookreviewRegist",method=RequestMethod.POST)
	public void reviewRegistPOST(@RequestParam("pay_id") int pay_id,  ReviewVO review, Model model)throws Exception{
		 System.out.println("후기 값 넘어가ㄴ기전");
		 System.out.println("등록전: "+review.toString());
	
		 //review.setReview_star(review.getReview_star());
		// model.addAttribute("review_star",review.getReview_star());
	     service.reviewregist(review);
	     
	     System.out.println("등록후: "+review.toString());
		
		
	}
	
	
	private String uploadFile(String originalName, byte[] fileData) throws Exception{
     
       
        UUID uid=UUID.randomUUID();     
        String savedName=uid.toString()+"_"+originalName;
        File target=new File(uploadPath,savedName);
       FileCopyUtils.copy(fileData, target);  
        return savedName;
}
	@RequestMapping(value="/pick")
	public String pick(PickVO pick, Model model)throws Exception{
		System.out.println("PICK而⑦�몃·�� 吏���");
		service.pick(pick);
		System.out.println("pick �깃났");
		return "redirect:/book/bookList";
	}
	
	
	
}