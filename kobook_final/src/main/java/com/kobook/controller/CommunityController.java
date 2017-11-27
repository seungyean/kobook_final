package com.kobook.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
import com.kobook.community.service.BlackService;
import com.kobook.community.service.DonateService;
import com.kobook.util.MediaUtils;
import com.kobook.util.UploadFileUtils;

@Controller
@RequestMapping("/community/*")
public class CommunityController {

	@Inject
	private BlackService blackService;
	
	@Inject
	private DonateService donateService;
	
	@Resource(name = "uploadPath")
	private String uploadPath;
	
	@ResponseBody
	@RequestMapping(value = "/uploadAjax", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public ResponseEntity<String> uploadAjax(MultipartFile file) throws Exception {

		System.out.println("originalName: " + file.getOriginalFilename());

		return new ResponseEntity<>(UploadFileUtils.uploadFile(uploadPath, file.getOriginalFilename(), file.getBytes()),
				HttpStatus.CREATED);
	}

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
	
	@RequestMapping(value = "blackRegist", method = RequestMethod.GET)
	public void blackRegistGet() throws Exception {

	}

	@RequestMapping(value = "blackRegist", method = RequestMethod.POST)
	public String blackRegistPost(BlackVO vo, Model model) throws Exception {
		blackService.blackRegist(vo);
		return "redirect:/community/blackList";
	}
	
	@RequestMapping(value = "blackList", method = RequestMethod.GET)
	public void blackList(@ModelAttribute SearchCriteria cri, Model model)throws Exception{
		model.addAttribute("list", blackService.blackList(cri));
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(blackService.blackCount(cri));
		
		model.addAttribute("pageMaker", pageMaker);
	}
	
	@RequestMapping("blackRead")
	public void blackRead(@RequestParam("black_id") int black_id, Model model,
			@ModelAttribute("cri") SearchCriteria cri) throws Exception{
		model.addAttribute(blackService.blackRead(black_id));
	}
	
	@RequestMapping(value = "blackModify", method = RequestMethod.GET)
	public void blackModifyGet(@RequestParam("black_id") int black_id, Model model,
			@ModelAttribute("cri") SearchCriteria cri) throws Exception {
		model.addAttribute(blackService.blackRead(black_id));
	}
	
	@RequestMapping(value = "blackModify", method = RequestMethod.POST)
	public String blackModifyPost(RedirectAttributes rtts, BlackVO vo, SearchCriteria cri) throws Exception {
		blackService.blackModify(vo);
		
		rtts.addAttribute("page", cri.getPage());
		rtts.addAttribute("perPageNum", cri.getPerPageNum());
		rtts.addAttribute("searchType", cri.getSearchType());
		rtts.addAttribute("keyword", cri.getKeyword());
		
		return "redirect:/community/blackList";
	}
	
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

	@RequestMapping("/blackGetAttach/{black_id}")
	@ResponseBody
	public List<String> blackGetAttach(@PathVariable("black_id") Integer black_id) throws Exception{
		return blackService.blackGetAttach(black_id);
		
	}
	
	@RequestMapping(value = "/donateRegist", method = RequestMethod.GET)
	public void donateRegistGet() throws Exception {
		
	}


	@RequestMapping(value = "/donateRegist", method = RequestMethod.POST)
	public String donateRegistPost(DonateVO vo , @RequestParam("file") MultipartFile file ) throws Exception {
		String donate_thumbnail = UploadFileUtils.uploadFile(uploadPath, file.getOriginalFilename(), file.getBytes());
		if(donate_thumbnail !=null){
			vo.setDonate_thumbnail(donate_thumbnail);
		}
		donateService.donateRegist(vo);
		
		return "redirect:/community/donateList";
	}
	
	@RequestMapping("donateList")
	public void donateList(@ModelAttribute SearchCriteria cri, Model model, @ModelAttribute DonateFileVO fileVO) throws Exception {
		model.addAttribute("list", donateService.donateList(cri));
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(donateService.donateCount(cri));
		
		model.addAttribute("pageMaker", pageMaker);
	}
	
	@RequestMapping(value="/donateGetAttach/{donate_id}")
	@ResponseBody
	public List<String> donateGetAttach(@PathVariable("donate_id")Integer donate_id) throws Exception {		
		return donateService.donateGetAttach(donate_id);
	}
	
	@RequestMapping("donateRead")
	public void donateRead(@RequestParam("donate_id") Integer donate_id, Model model,
			@ModelAttribute("cri") SearchCriteria cri)throws Exception{
		model.addAttribute(donateService.donateRead(donate_id));
	}

}
