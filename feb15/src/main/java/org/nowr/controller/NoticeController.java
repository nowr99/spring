package org.nowr.controller;

import java.util.List;

import javax.annotation.Resource;

import org.nowr.dto.NoticeDTO;
import org.nowr.service.NoticeService;
import org.nowr.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

@Controller
public class NoticeController {

	@Resource(name = "noticeService")
	private NoticeService noticeService;
	
	@Autowired
	Util util;

	// 2024-02-27 요구사항 확인 psd
	@GetMapping("/notice")
	public String notice(@RequestParam(value = "pageNo", required = false) String no, Model model) {
		int currentPageNo = 1;
		if (util.str2Int(no) > 0) {
			currentPageNo = Integer.parseInt(no);
		}
		int totalRecordCount = noticeService.totalRecordCount();
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(currentPageNo); // 현재 페이지 번호
		paginationInfo.setRecordCountPerPage(10); // 한 페이지에 게시되는 게시물 건 수
		paginationInfo.setPageSize(10); // 페이징 리스트의 사이즈
		paginationInfo.setTotalRecordCount(totalRecordCount); // 전체 게시물 건 수
		
		List<NoticeDTO> list = noticeService.noticeList(paginationInfo.getFirstRecordIndex());
		model.addAttribute("list", list);
		model.addAttribute("paginationInfo", paginationInfo);
		return "notice"; // ..../views/notice.jsp 실행
	}

	// 공지 글 쓰기-> admin 관리자 화면으로 이사 예정
	@GetMapping("/admin/noticeWrite")
	public String noticeWrite() {
		return "admin/noticeWrite"; // views/admin/noticeWrite.jsp
	}

	@PostMapping("/admin/noticeWrite")
	public String noticeWrite(NoticeDTO dto) {
		// System.out.println(dto.getNtitle());
		// System.out.println(dto.getNcontent());
		int result = noticeService.noticeWrite(dto);
		return "redirect:/notice";
	}

	@GetMapping("/noticeDetail")
	public String noticeDetail(@RequestParam(value = "no", defaultValue = "0") int no, Model model) {
		if (no == 0) {
			return "redirect:/error";
		} else {
			NoticeDTO detail = noticeService.detail(no);
			if (detail.getNno() == 0) {
				return "redirect:/error";
			} else {
				model.addAttribute("detail", detail);
				return "noticeDetail";
			}
		}
	}
	
	//noticeDel
	@GetMapping ("/noticeDel{no}")
	public String noticeDel(@PathVariable("no") int no) {
		System.err.println("@pathVariable : " + no);
		noticeService.noticeDel(no);
		return "redirect:/notice";
	}

}