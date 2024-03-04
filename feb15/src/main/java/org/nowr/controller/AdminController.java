package org.nowr.controller;

import java.util.List;

import javax.annotation.Resource;

import org.nowr.dto.BoardDTO;
import org.nowr.dto.NoticeDTO;
import org.nowr.dto.SearchDTO;
import org.nowr.service.AdminService;
import org.nowr.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

// admin = administrator = root
@Controller
@RequestMapping("/admin")
public class AdminController {
	
	// http://localhost/admin/index
	// 경로 ----------------------
	
	@Autowired
	private Util util;
	
	@Resource(name = "adminService")
	private AdminService adminService;
	
	@GetMapping("/") // url 경로
	public String index() {
		return "admin/index"; // 폴더 경로
	}
	
	@GetMapping("/index") // url 경로
	public String index2() {
		return "admin/index"; // 폴더 경로
	}
	
	@GetMapping("/join") // url 경로
	public String join() {
		return "admin/join"; // 폴더 경로
	}
	
	@GetMapping("/login") // url 경로
	public String login() {
		return "admin/login"; // 폴더 경로
	}
	@GetMapping("/member")
	public String member() {
		return "admin/member";
	}
	// 공지사항 혼자 해보는중
	@GetMapping("/notice")
	public String notice(Model model) {
		List<NoticeDTO> list = adminService.noticeList();
		model.addAttribute("list", list);
		
		return "admin/notice";
	}
	
	
	//2024-03-04 관리자 게시물 보기 (계속 추가)
	@GetMapping("/board")
	public String board(
			@RequestParam(name="pageNo", defaultValue = "1", required = false) String pageNo, 
			@RequestParam(name="perPage", defaultValue = "1", required = false) String perPage,
			@RequestParam(name="search", required = false) String search,
			@RequestParam(name="searchTitle", required = false) String searchTitle,
			Model model) {
		// 페이징 + 검색 + 한 화면에 보이는 게시글 수 변경
		
		// 전체 글 수에도 DTO 보내기
		SearchDTO searchDTO = new SearchDTO();
		searchDTO.setSearchTitle(searchTitle);
		searchDTO.setSearch(search);
		
		// 전체 글 수 뽑가기
		int totalRecordCount = adminService.totalRecordCount(searchDTO);
		
		//전자정부 페이지
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(util.str2Int(pageNo));
		paginationInfo.setRecordCountPerPage(util.str2Int(perPage)*10); // 10 20 30 40 50 100
		paginationInfo.setPageSize(10);
		paginationInfo.setTotalRecordCount(totalRecordCount);

		searchDTO.setPageNo(paginationInfo.getFirstRecordIndex());
		searchDTO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
		
		List<BoardDTO> list = adminService.boardList(searchDTO);
		model.addAttribute("list", list);
		model.addAttribute("paginationInfo", paginationInfo);
		model.addAttribute("pageNo", pageNo);
		model.addAttribute("perPage", perPage);
		model.addAttribute("search", search);
		model.addAttribute("searchTitle", searchTitle);
		
		return "admin/board";
	}
	//2024-03-04
	@GetMapping ("/postDel")
	public String postDel(@RequestParam("no") int no) {
		int result = adminService.postDel(no);
		return "redirect:/admin/board";
	}
}
