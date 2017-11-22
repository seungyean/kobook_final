package com.kobook.controller;

import java.io.File;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kobook.book.domain.BookVO;
import com.kobook.book.domain.PageMaker;
import com.kobook.book.domain.SearchCriteria;
import com.kobook.book.service.BookService;
import com.kobook.util.UploadFileUtils;

@Controller
@RequestMapping("/book/*")
public class BookController {

	@Inject
	private BookService service;
	
	@RequestMapping(value="/bookRegist",method=RequestMethod.GET)
	public void bookRegistGET(BookVO book, Model model)throws Exception{
	}
	
	
	
	@RequestMapping(value="/bookRegist",method=RequestMethod.POST)
	public String bookRegistPOST(BookVO book,Model model,@RequestParam("file")MultipartFile file, HttpServletRequest request) throws Exception{
		
		//book.setBook_img(file.getOriginalFilename());
		System.out.println(file.getOriginalFilename());
        System.out.println(file.getSize());
        System.out.println(file.getContentType());
        
      /*  String savedName=UploadFileUtils.uploadFile(uploadPath,file.getOriginalFilename(), file.getBytes());

        private String uploadFile(String originalName, byte[] fileData) throws Exception{
            //원본파일이름, 파일데이터를 byte[]로 변환한 정보를통해 실제파일 업로드
           
            UUID uid=UUID.randomUUID();     //중복되지않은 고유키 값 설정시 사용//파일이름생성
            String savedName=uid.toString()+"_"+originalName;
            File target=new File(uploadPath,savedName);
            FileCopyUtils.copy(fileData, target);  //실제파일처리- spring에서 제공하는 FileCopyUtils이용
            return savedName;
    }*/

		System.out.println(book.toString()); 
		service.regist(book);
		System.out.println("bbbbbbbbbb");
		return "redirect:/book/bookList";
		
	}

	@RequestMapping("/bookList")
	public void list(@ModelAttribute("cri") SearchCriteria cri, Model model)throws Exception{
		model.addAttribute("list", service.listCriteria(cri));
		PageMaker pageMaker=new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.countPaging(cri));
		model.addAttribute("pageMaker",pageMaker);
	}
	
	
	@RequestMapping(value="/bookRead",method=RequestMethod.GET)
	public void read(@RequestParam("book_id")int book_id, @ModelAttribute("cri")SearchCriteria cri, Model model)throws Exception{
		model.addAttribute(service.read(book_id));
	}
	
	
	@RequestMapping(value="/bookModify",method=RequestMethod.GET)
	public void modifyGET(@RequestParam("book_id")int book_id, BookVO book, Model model)throws Exception
	{
		model.addAttribute(service.read(book_id));
	}
	
	@RequestMapping(value="/bookModify",method=RequestMethod.POST)
	public String modifyPOST(RedirectAttributes rttr, BookVO book, Model model, @ModelAttribute("cri")SearchCriteria cri)throws Exception{
		service.modify(book);
		rttr.addAttribute("page",cri.getPage());
		rttr.addAttribute("perPageNum",cri.getPerPageNum());
		rttr.addAttribute("searchType", cri.getSearchType());
		rttr.addAttribute("keyword", cri.getKeyword());
		return "redirect:/book/bookList";
	}	
}