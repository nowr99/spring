package org.nowr.controller;

import java.util.List;

import org.nowr.dto.BoardDTO;
import org.nowr.dto.CommentDTO;
import org.nowr.dto.WriteDTO;
import org.nowr.service.BoardService;
import org.nowr.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

@Controller
public class BoardController {
	// 1. 엔터키 처리 - 글쓰기 / 댓글쓰기
	// 2. 로그인 검사 - 글쓰기 / 댓글쓰기

	@Autowired
	private BoardService boardService; // @Autowired는 각각 하나하나 적어줘야함

	@Autowired
	private Util util;

	@GetMapping("/index")
	public String index() {
		return "index";
	}

	// board에 전자정부 페이징 추가하기 2024-02-20
	@GetMapping("/board")
	public String board(@RequestParam(value = "pageNo", required = false) String no, Model model) {
		// pageNo가 오지 않는다면?
		int currentPageNo = 1;
		if (util.str2Int(no) > 0) {
			currentPageNo = Integer.parseInt(no);
		}

		// 전체글수 totalRecordCount 2024-02-20
		int totalRecordCount = boardService.totalRecordCount();
		// System.out.println("전체 글 갯수는 : " + totalRecordCount);
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(currentPageNo); // 현재 페이지 번호
		paginationInfo.setRecordCountPerPage(10); // 한 페이지에 게시되는 게시물 건 수
		paginationInfo.setPageSize(10); // 페이징 리스트의 사이즈
		paginationInfo.setTotalRecordCount(totalRecordCount); // 전체 게시물 건 수

		List<BoardDTO> list = boardService.boardList(paginationInfo.getFirstRecordIndex());
		model.addAttribute("list", list);
		// 페이징ㅈ 관련 전보가 있는 paginationInfo 객체를 모델에 반드시 넣어준다
		model.addAttribute("paginationInfo", paginationInfo);
		return "board";
	}

	// 2024-02-16 psd
	@GetMapping("/detail")
	// public String detail(HttpServletRequest request) {
	// 오는 no 잡기 httpservletrequest
	public String detail(@RequestParam(value = "no", defaultValue = "0") String no, Model model) {
		// String no = request.getParameter("no");
		// System.out.println(util.str2Int(no)); // 숫자면 자신의 숫자, 문자면 0 출력됨
		// System.err.println("no 값은" + no); // no값 오네요
		int reNo = util.str2Int(no);
		if (reNo != 0) {
			// 0이 아니야 = 정상접근 : DB에 물어보기(완) / 값 가져오기 / 붙이기(완) / 이동(완)
			BoardDTO detail = boardService.detail(reNo);
			model.addAttribute("detail", detail);
			// 2024-02-19 psd 댓글 출력하기
			// System.out.println("댓글 수 : " + detail.getComment());
			if (detail.getComment() > 0) {
				List<CommentDTO> commentsList = boardService.commentsList(reNo);
				model.addAttribute("commentsList", commentsList); // 모델 써서 값 붙이기

				// System.out.println(commentsList.get(0).getMname());
			}

			return "detail";
		} else {
			// 0이야 = 비정상접근 : 에러페이지로 이동
			// return "error/error"; // error폴더의 error.jsp 실행
			return "redirect:/error"; // controller에 있는 error매핑을 실행하라는 뜻
		}

	}

	@GetMapping("/write")
	public String write() {

		return "redirect:/login?error=2048";
	}

	// 글쓰기 2024-02-16
	@PostMapping("/write") // 내용 + 제목 받아요 -> db저장 -> 다시 보드로
	public String write(WriteDTO dto) {
		// 로그인여부 검사
		if (util.getSession().getAttribute("mid") != null) {
			int result = boardService.write(dto);
			// 정상적으로 글이 써졌다 1, 에러 0
			// 추후 세션관련 작업을 더 해야 합니다.
			if (result == 1) {
				return "redirect:/detail?no=" + dto.getBoard_no();
			} else {
				return "redirect:/error";
			}
		} else {
			return "redirect:/login";
		}
	}

	// 댓글쓰기 2024-02-19 psd == 글번호 no, 댓글 내용 comment, 글쓴이mid 값이 넘어와야 에러없이 글이 써짐
	@PostMapping("/commentWrite")
	public String commentWrite(CommentDTO comment) {
		if (util.getSession().getAttribute("mid") != null) {
			// HttpSession session = request.getSession(); 얘네는 이제 안써여
			// comment.setMid((String) session.getAttribute("mid"));
			int result = boardService.commentWrite(comment);
			// System.out.println("댓글쓰기 결과" + result);

			return "redirect:/detail?no=" + comment.getNo();
		} else {
			return "redirect:/login";
		}
	}

	// 게시글 삭제하기 24-02-20
	@PostMapping("/postDel")
	public String postDel(@RequestParam("no") int no) {
		// 로그인 여부 (유틸만든거 가져다쓰기)
		if (util.getSession().getAttribute("mid") != null) {
			// System.out.println("nozz :" + no);
			int result = boardService.postDel(no);
			System.out.println("result :" + result);
			return "redirect:/board";
		} else {
			return "redirect:/login";
		}
	}

	// 댓글 삭제하기 24-02-21 psd == 댓글 번호 + 글번호
	@GetMapping("/deleteComment")
	public String deleteComment(@RequestParam("no") int no, @RequestParam("cno") int cno) {
		System.out.println("no : " + no);
		System.out.println("cno : " + cno);

		int result = boardService.deleteComment(no, cno);

		return "redirect:/detail?no=" + no;
	}

	// 2024-02-22 요구사항 확인 psd
	@GetMapping("/likeUp")
	public String likeUp(@RequestParam("no") String no, @RequestParam("cno") String cno) { // board_no=no, cno=cno
		System.err.println(no);
		System.err.println(cno);
		if (util.intCheck(no) && util.intCheck(cno)) {
			CommentDTO dto = new CommentDTO();
			dto.setBoard_no(util.str2Int(no));
			dto.setNo(util.str2Int(cno));
			int result = boardService.likeUp(dto);
			return "redirect:/detail?no="+dto.getBoard_no();
		} else {
			return "redirect:/error";
		}

	}
}
