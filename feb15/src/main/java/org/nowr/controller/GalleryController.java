package org.nowr.controller;

import java.util.List;

import org.nowr.dto.GalleryDTO;
import org.nowr.service.GalleryService;
import org.nowr.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class GalleryController {
	
	@Autowired 
	private GalleryService galleryService;
	
	@Autowired
	private Util util;
	
	// 갤러리 들어가기
	@GetMapping("/gallery")
	public String gallery(Model model) {
		List<GalleryDTO> list = galleryService.galleryList();
		model.addAttribute("list" ,list);
		return "gallery";
	}
	
	// 갤러리에 글쓰기(불러만와요)
	@GetMapping("/galleryInsert")
	public String galleryInsert() {
		
		return "galleryInsert";
	}
	
	// 글쓰기 저장하기
	@PostMapping("/galleryInsert")
	public String galleryInsert(GalleryDTO dto, @RequestParam("file1") MultipartFile upFile) {
		// System.out.println(dto.getGtitle());
		// System.out.println(dto.getGcontent());
		// System.out.println(upFile.getOriginalFilename());
		
		dto.setGtitle(dto.getGtitle());
		dto.setGcontent(dto.getGcontent());
		
		// 파일 업로드 -> util에다 만들꺼임
		String newFileName = util.fileUpload(upFile);
		
		dto.setGfile(newFileName); // UUID+
		
		
		int result = galleryService.galleryInsert(dto);
		return "redirect:/gallery";
	}

}
