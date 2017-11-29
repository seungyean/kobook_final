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
import com.kobook.book.domain.ReviewVO;
import com.kobook.book.domain.BookVO;
import com.kobook.book.domain.PageMaker;
import com.kobook.book.domain.PersonDTO;
import com.kobook.book.domain.SearchCriteria;
import com.kobook.book.service.BookService;
import com.kobook.mypage.domain.DeliveryVO;
import com.kobook.person.domain.PersonVO;
import com.kobook.util.MediaUtils;
import com.kobook.util.UploadFileUtils;

@Controller
@RequestMapping("/book/*")
public class BookController {

	@Resource(name="uploadPath")
	private String uploadPath;
	
	@Inject
	private BookService service;
	
	
	//愿�由ъ�� ���댁�
	@RequestMapping("/delivery")
	public void deliveryList(@ModelAttribute("cri") SearchCriteria cri, Model model)throws Exception{
		System.out.println("----------------Controller : 諛곗�〓━�ㅽ�� 異���-----------------");
		
		model.addAttribute("dlist",service.deliveryList(cri));
		System.out.println(service.deliveryList(cri).toString());
		System.out.println("----");	
		PageMaker pageMaker=new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.countdelList());
		model.addAttribute("pageMaker",pageMaker);
	}
	
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
		model.addAttribute("list", service.listCriteria(cri));
	//	model.addAttribute("rankinglist", service.)
		PageMaker pageMaker=new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.countPaging(cri));
		model.addAttribute("pageMaker",pageMaker);

	}
	
	
	
	@RequestMapping("/booklocationList")
	public void locationlist(@ModelAttribute("cri") SearchCriteria cri, Model model)throws Exception{
		model.addAttribute("list", service.directListCriteria(cri));
		model.addAttribute("list2", service.safeListCriteria(cri));
		
		PageMaker pageMaker=new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.countPaging(cri));
		model.addAttribute("pageMaker",pageMaker);
	}
	
	
	@RequestMapping(value="/bookRead",method=RequestMethod.GET)
	public void read(@RequestParam("book_id")int book_id, PersonDTO person, Model model,@ModelAttribute("cri") SearchCriteria cri)throws Exception{
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
	public void reviewRegistPOST(@RequestParam("pay_id")int pay_id,ReviewVO review, Model model)throws Exception{
		 System.out.println("��湲곗����");
		 System.out.println("��: "+review.toString());
		 
		// review.setReview_star(review.getReview_star());
		 //model.addAttribute("review_star",review.getReview_star());
		 
	     service.reviewregist(review);
	     System.out.println("��: "+review.toString());
		
		
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