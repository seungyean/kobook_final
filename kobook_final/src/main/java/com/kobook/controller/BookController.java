package com.kobook.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
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
import com.kobook.util.MediaUtils;
import com.kobook.util.UploadFileUtils;

@Controller
@RequestMapping("/book/*")
public class BookController {

	@Resource(name="uploadPath")
	private String uploadPath;
	
	@Inject
	private BookService service;
	
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
		 System.out.println("¼öÁ¤Àü:"+book.toString());
	       book.setBook_img(savedName);
		
		 
		service.modify(book);
		 System.out.println("¼öÁ¤ÈÄ:"+book.toString()); 
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
	public void read(@RequestParam("book_id")int book_id, PersonDTO person, Model model)throws Exception{
		System.out.println("1");
		System.out.println("컨트롤러2"+service.countStar(service.getPersonIdByBookId(book_id)));
		System.out.println("컨트롤러1:"+service.countReview(service.getPersonIdByBookId(book_id)));
	
		System.out.println("2");
		System.out.println("readCon: book_id: " + book_id);
		model.addAttribute(service.read(book_id));
		
		System.out.println("3");
		//판매자정보보여주기
		model.addAttribute("s",service.readSellPerson(service.getPersonIdByBookId(book_id)));
		
		System.out.println("5");
		model.addAttribute("countstar",service.countStar(service.getPersonIdByBookId(book_id)));
		
		System.out.println("4");
		model.addAttribute("reviewcount",service.countReview(service.getPersonIdByBookId(book_id)));

		
		
		
		
		
		model.addAttribute("slist",service.sellPersonList(service.getPersonIdByBookId(book_id)));
	}
	

	@RequestMapping(value="/bookreviewRegist",method=RequestMethod.GET)
	public void reviewRegist(Model model,@RequestParam("pay_id")int pay_id)throws Exception{
		System.out.println("리뷰작성 전 form");
		
		ReviewVO reviewVO = new ReviewVO();
		reviewVO.setPay_id(pay_id);
		model.addAttribute("pay_id", reviewVO.getPay_id());
		System.out.println("결제번호: "+reviewVO.getPay_id());
		
		
	}
	
	
	@RequestMapping(value="/bookreviewRegist",method=RequestMethod.POST)
	public void reviewRegistPOST(@RequestParam("pay_id")int pay_id,ReviewVO review, Model model)throws Exception{
		 System.out.println("후기작성");
		 System.out.println("전: "+review.toString());

	     service.reviewregist(review);
	     System.out.println("후: "+review.toString());
		
		
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
		System.out.println("PICK컨트롤러 진입");
		service.pick(pick);
		System.out.println("pick 성공");
		return "redirect:/book/bookList";
	}
	
	
	
}