package com.kobook.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kobook.book.domain.PageMaker;
import com.kobook.book.domain.SearchCriteria;
import com.kobook.community.domain.BlackVO;
import com.kobook.community.domain.DonateFileVO;
import com.kobook.community.domain.DonateVO;
import com.kobook.community.domain.PhotoVO;
import com.kobook.community.domain.ReplyVO;
import com.kobook.community.service.BlackService;
import com.kobook.community.service.DonateService;
import com.kobook.community.service.PhotoReviewService;
import com.kobook.util.MediaUtils;
import com.kobook.util.UploadFileUtils;

@Controller
@RequestMapping("/community/*")
public class CommunityController {

	@Inject
	private BlackService blackService;
	
	@Inject
	private DonateService donateService;
	
	@Inject
	private PhotoReviewService photoService;
	
	@Resource(name = "uploadPath")
	private String uploadPath;

	//파일 업로드
	@ResponseBody
	@RequestMapping(value = "/uploadAjax", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public ResponseEntity<String> uploadAjax(MultipartFile file) throws Exception {

		System.out.println("originalName: " + file.getOriginalFilename());

		return new ResponseEntity<>(UploadFileUtils.uploadFile(uploadPath, file.getOriginalFilename(), file.getBytes()),
				HttpStatus.CREATED);
	}

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

	//attach 테이블에서 업로드된 파일 삭제
	@ResponseBody
	@RequestMapping(value = "/deleteFile", method = RequestMethod.POST)
	public ResponseEntity<String> deleteFile(String fileName) {

		System.out.println("delete file: " + fileName);

		String formatName = fileName.substring(fileName.lastIndexOf(".") + 1);

		MediaType mType = MediaUtils.getMediaType(formatName);

		if (mType != null) {

			String front = fileName.substring(0, 12);
			String end = fileName.substring(14);
			new File(uploadPath + (front + end).replace('/', File.separatorChar)).delete();
		}

		new File(uploadPath + fileName.replace('/', File.separatorChar)).delete();

		return new ResponseEntity<String>("deleted", HttpStatus.OK);
	}

	@ResponseBody
	@RequestMapping(value = "/deleteAllFiles", method = RequestMethod.POST)
	public ResponseEntity<String> deleteFile(@RequestParam("files[]") String[] files) {

		System.out.println("delete all files: " + files);

		if (files == null || files.length == 0) {
			return new ResponseEntity<String>("deleted", HttpStatus.OK);
		}

		for (String fileName : files) {
			String formatName = fileName.substring(fileName.lastIndexOf(".") + 1);

			MediaType mType = MediaUtils.getMediaType(formatName);

			if (mType != null) {

				String front = fileName.substring(0, 12);
				String end = fileName.substring(14);
				new File(uploadPath + (front + end).replace('/', File.separatorChar)).delete();
			}

			new File(uploadPath + fileName.replace('/', File.separatorChar)).delete();

		}
		return new ResponseEntity<String>("deleted", HttpStatus.OK);
	}
	
	//자주묻는질문
	@RequestMapping(value = "/qna", method = RequestMethod.GET)
	public void qna() throws Exception {
		
	}	
	
	//신고게시판 글 등록 폼 이동
	@RequestMapping(value = "blackRegist", method = RequestMethod.GET)
	public void blackRegistGet(@ModelAttribute("blackCommand") BlackVO vo) throws Exception {

	}

	//신고게시판 글 등록(DB)
	@RequestMapping(value = "blackRegist", method = RequestMethod.POST)
	public String blackRegistPost(@ModelAttribute("blackCommand") @Valid BlackVO vo, BindingResult errors, Model model) throws Exception {
		if(errors.hasErrors()) {
			return "/community/blackRegist";
		}
		blackService.blackRegist(vo);
		return "redirect:/community/blackList";
	}
	
	//신고 게시판 List출력
	@RequestMapping(value = "blackList", method = RequestMethod.GET)
	public void blackList(@ModelAttribute SearchCriteria cri, Model model)throws Exception{
		List<BlackVO> list = blackService.blackList(cri);
		HashMap<Integer, String> userMap = new HashMap<Integer,String>();
		
		int black_id;
		
		for(int index = 0; index<list.size(); index++){
			black_id = list.get(index).getBlack_id();		
			userMap.put(black_id, blackService.blackWriter(black_id));
		}
		model.addAttribute("list", list);
		model.addAttribute("userMap", userMap);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(blackService.blackCount(cri));
		
		model.addAttribute("pageMaker", pageMaker);
	}
	
	//신고게시판 상세보기
	@RequestMapping("blackRead")
	public void blackRead(@RequestParam("black_id") int black_id, Model model,
			@ModelAttribute("cri") SearchCriteria cri) throws Exception{
		model.addAttribute(blackService.blackRead(black_id));
		model.addAttribute("writer", blackService.blackWriter(black_id));
	}
	
	//신고게시판 수정 폼 이동
	@RequestMapping(value = "blackModify", method = RequestMethod.GET)
	public void blackModifyGet(@RequestParam("black_id") int black_id, Model model,
			@ModelAttribute("cri") SearchCriteria cri) throws Exception {
		model.addAttribute(blackService.blackRead(black_id));
		model.addAttribute("writer", blackService.blackWriter(black_id));
	}
	
	//신고게시판 글 수정(DB)
	@RequestMapping(value = "blackModify", method = RequestMethod.POST)
	public String blackModifyPost(RedirectAttributes rtts, BlackVO vo, SearchCriteria cri) throws Exception {
		blackService.blackModify(vo);
		
		rtts.addAttribute("page", cri.getPage());
		rtts.addAttribute("perPageNum", cri.getPerPageNum());
		rtts.addAttribute("searchType", cri.getSearchType());
		rtts.addAttribute("keyword", cri.getKeyword());
		
		return "redirect:/community/blackList";
	}
	
	//신고게시판 글 삭제(DB)
	@RequestMapping("blackRemove")
	public String blackRemove(RedirectAttributes rtts, SearchCriteria cri
			, @RequestParam("black_id") Integer black_id) throws Exception {
		blackService.blackRemove(black_id);
		
		rtts.addAttribute("page", cri.getPage());
		rtts.addAttribute("perPageNum", cri.getPerPageNum());
		rtts.addAttribute("searchType", cri.getSearchType());
		rtts.addAttribute("keyword", cri.getKeyword());
		
		return "redirect:/community/blackList";
	}

	//black_attach 파일명 추출
	@RequestMapping("/blackGetAttach/{black_id}")
	@ResponseBody
	public List<String> blackGetAttach(@PathVariable("black_id") Integer black_id) throws Exception{
		return blackService.blackGetAttach(black_id);
		
	}
	
	//무료나눔 게시판 글 등록 폼 이동
	@RequestMapping(value = "/donateRegist", method = RequestMethod.GET)
	public void donateRegistGet(@ModelAttribute("donateCommand") DonateVO vo) throws Exception {
		
	}

	//무료나눔 글 등록(DB)
	@RequestMapping(value = "/donateRegist", method = RequestMethod.POST)
	public String donateRegistPost(@ModelAttribute("donateCommand") @Valid DonateVO vo , BindingResult errors, @RequestParam("file") MultipartFile file ) throws Exception {
		if(errors.hasErrors()) {
			return "/community/donateRegist";
		}
		String donate_thumbnail = UploadFileUtils.uploadFile(uploadPath, file.getOriginalFilename(), file.getBytes());
		String[] donate_thumbnail1 =donate_thumbnail.split("_");
		
		if(donate_thumbnail1.length>2) {
			vo.setDonate_thumbnail(donate_thumbnail);
		}
		donateService.donateRegist(vo);
		
		return "redirect:/community/donateList";
	}
	
	//무료나눔 List 출력
	@RequestMapping("donateList")
	public void donateList(@ModelAttribute SearchCriteria cri, Model model, @ModelAttribute DonateFileVO fileVO) throws Exception {
		List<DonateVO> list = donateService.donateList(cri);
		HashMap<Integer, String> userMap = new HashMap<Integer,String>();
		
		int donate_id;
		
		for(int index = 0; index<list.size(); index++){
			donate_id = list.get(index).getDonate_id();		
			userMap.put(donate_id, donateService.donateWriter(donate_id));		
		}

		model.addAttribute("list", list);
		model.addAttribute("userMap", userMap);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(donateService.donateCount(cri));
		
		model.addAttribute("pageMaker", pageMaker);
	}
	
	//무료나눔 첨부파일 추출
	@RequestMapping(value="/donateGetAttach/{donate_id}")
	@ResponseBody
	public List<String> donateGetAttach(@PathVariable("donate_id")Integer donate_id) throws Exception {		
		return donateService.donateGetAttach(donate_id);
	}
	
	//무료나눔 게시판 상세보기
	@RequestMapping("donateRead")
	public void donateRead(@RequestParam("donate_id") Integer donate_id, Model model,
			@ModelAttribute("cri") SearchCriteria cri, ReplyVO vo)throws Exception{
		
		//Integer person_id = vo.getPerson_id();
		//System.out.println("person_id"+person_id);
		//System.out.println("reply_id : "+vo.getReply_id());
		model.addAttribute(donateService.donateRead(donate_id, true));
		model.addAttribute("writer",donateService.donateWriter(donate_id));
		model.addAttribute("replyList",donateService.donateReplyList(donate_id));
		//model.addAttribute("reply_person", donateService.selectPersonName(person_id,donate_id));
	}
	
	//무료나눔 글 수정 폼 이동
	@RequestMapping(value = "donateModify", method = RequestMethod.GET)
	public void donateModifyGet(@RequestParam("donate_id") int donate_id, Model model,
			@ModelAttribute("cri") SearchCriteria cri) throws Exception {
		model.addAttribute(donateService.donateRead(donate_id, false));
		model.addAttribute("writer",donateService.donateWriter(donate_id));
	}
	
	//무료나눔 글 수정(DB)
	@RequestMapping(value = "donateModify", method = RequestMethod.POST)
	public String donateModifyPost(RedirectAttributes rtts, DonateVO vo, SearchCriteria cri
			, @RequestParam("file") MultipartFile file ) throws Exception {
		String donate_thumbnail = UploadFileUtils.uploadFile(uploadPath, file.getOriginalFilename(), file.getBytes());
		String[] donate_thumbnail1 =donate_thumbnail.split("_");
		
		if(donate_thumbnail1.length>2) {
			vo.setDonate_thumbnail(donate_thumbnail);
		}
		donateService.donateModify(vo);
		
		rtts.addAttribute("page", cri.getPage());
		rtts.addAttribute("perPageNum", cri.getPerPageNum());
		rtts.addAttribute("searchType", cri.getSearchType());
		rtts.addAttribute("keyword", cri.getKeyword());
		
		return "redirect:/community/donateList";
	}
	
	//무료나눔 글 삭제(DB)
	@RequestMapping("donateRemove")
	public String donateRemove(RedirectAttributes rtts, SearchCriteria cri
			, @RequestParam("donate_id") Integer donate_id) throws Exception {
		donateService.donateRemove(donate_id);
		
		rtts.addAttribute("page", cri.getPage());
		rtts.addAttribute("perPageNum", cri.getPerPageNum());
		rtts.addAttribute("searchType", cri.getSearchType());
		rtts.addAttribute("keyword", cri.getKeyword());
		
		return "redirect:/community/donateList";
	}
	
	//무료나눔 댓글 등록(DB)
	@RequestMapping(value="donateReplyRegist", method=RequestMethod.POST)
	public String donateReplyRegist(ReplyVO vo, Model model, @ModelAttribute("cri") SearchCriteria cri) throws Exception {
		donateService.donateReplyRegist(vo);
		int donate_id = vo.getDonate_id();
		
		model.addAttribute(donateService.donateRead(donate_id, false));
		model.addAttribute("writer",donateService.donateWriter(donate_id));
		model.addAttribute("replyList",donateService.donateReplyList(donate_id));
		return "/community/donateRead";
	}
	
	//무료나눔 게시판 댓글 수정 폼 이동
	@RequestMapping(value="donateReplyModify", method=RequestMethod.GET)
	public void donateReplyModifyGET(Model model, @ModelAttribute("cri") SearchCriteria cri,
			@RequestParam("donate_id") Integer donate_id, @RequestParam("reply_id") Integer reply_id) throws Exception {
		
		model.addAttribute("reply_id", reply_id);
		model.addAttribute(donateService.donateRead(donate_id, false));
		model.addAttribute("writer",donateService.donateWriter(donate_id));
		model.addAttribute("replyList",donateService.donateReplyList(donate_id));
	}
	
	//무료나눔 게시판 댓글 수정(DB)
	@RequestMapping(value="donateReplyModify", method=RequestMethod.POST)
	public String donateReplyModifyPOST(Model model,ReplyVO vo
			, @ModelAttribute("cri") SearchCriteria cri) throws Exception {
		donateService.replyModify(vo);
		System.out.println(vo.toString());
		
		model.addAttribute(donateService.donateRead(vo.getDonate_id(), false));
		model.addAttribute("writer",donateService.donateWriter(vo.getDonate_id()));
		model.addAttribute("replyList",donateService.donateReplyList(vo.getDonate_id()));
		
		return "/community/donateRead";
	}
	
	//무료나눔 댓글 삭제
	@RequestMapping("donateReplyRemove")
	public String donateReplyRemove(Model model, @RequestParam("reply_id") Integer reply_id,
			 @ModelAttribute("cri") SearchCriteria cri,@RequestParam("donate_id") Integer donate_id) throws Exception{
		donateService.replyRemove(reply_id);
		model.addAttribute(donateService.donateRead(donate_id, false));
		model.addAttribute("writer",donateService.donateWriter(donate_id));
		model.addAttribute("replyList",donateService.donateReplyList(donate_id));
		return "/community/donateRead";
	}

	//포토리뷰 글 등록 폼 이동
	@RequestMapping(value = "photoReviewRegist", method = RequestMethod.GET)
	public void photoReviewRegistGet(@ModelAttribute("photoCommand") PhotoVO vo) throws Exception {
		
	}

	//포토리뷰 글 등록(DB)
	@RequestMapping(value = "/photoReviewRegist", method = RequestMethod.POST)
	public String photoReviewRegistPost(@ModelAttribute("photoCommand") @Valid PhotoVO vo,
			BindingResult errors, @RequestParam("file") MultipartFile file ) throws Exception {
		if(errors.hasErrors()) {
			return "/community/photoReviewRegist";
		}
		String photo_thumbnail = UploadFileUtils.uploadFile(uploadPath, file.getOriginalFilename(), file.getBytes());
		String[] photo_thumbnail1 =photo_thumbnail.split("_");
		
		if(photo_thumbnail1.length>2) {
			String photo_img = photo_thumbnail.substring(0,12);
			String photo_img2 = photo_thumbnail.substring(14);
			vo.setPhoto_thumbnail((photo_img+photo_img2));
		}
		photoService.photoRegist(vo);
		
		return "redirect:/community/photoReviewRegist";
	}
	
}
