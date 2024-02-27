package org.nowr.service;

import java.util.List;

import org.nowr.dao.BoardDAO;
import org.nowr.dto.BoardDTO;
import org.nowr.dto.CommentDTO;
import org.nowr.dto.WriteDTO;
import org.nowr.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService extends AbstractService {

	@Autowired
	private BoardDAO boardDAO;

	public List<BoardDTO> boardList(int PageNo) {
		// System.out.println("서브시통과");
		return boardDAO.boardList(PageNo);
	}

	public BoardDTO detail(int no) {
		// 2024-02-22 요구사항 확인
		// 로그인했어? -> 읽음 수 올리기
		if (util.getSession().getAttribute("mid") != null) {
			BoardDTO dto = new BoardDTO();
			dto.setBoard_no(no);
			dto.setMid((String) util.getSession().getAttribute("mid"));
			// int result = boardDAO.alreadyRead(dto);
			// if(result == 0) { // 이미 읽었는지 검사하기
			boardDAO.countUP(dto);
		}
		return boardDAO.detail(no);
	}

	public int write(WriteDTO dto) {
		// HttpServletRequest request = util.req();
		// HttpSession session = request.getSession();
		// 엔터키 처리 24.02.21
		dto.setContent(dto.getContent().replaceAll("(\r\n|\r|\n|\n\r)", "<br>"));

		dto.setMid((String) util.getSession().getAttribute("mid"));
		dto.setIp(util.getIP());
		return boardDAO.write(dto);
	}

	public int commentWrite(CommentDTO comment) {
		// 댓글 내용 + 글번호 + mid
		comment.setMid((String) util.getSession().getAttribute("mid"));
		comment.setCip(util.getIP());
		return boardDAO.commentWrite(comment);
	}

	public List<CommentDTO> commentsList(int no) {
		return boardDAO.commentsList(no);
	}

	public int postDel(int no) {
		WriteDTO dto = new WriteDTO();
		dto.setBoard_no(no);
		dto.setMid((String) util.getSession().getAttribute("mid"));
		return boardDAO.postDel(dto);
	}

	public int totalRecordCount() {
		return boardDAO.totalRecordCount();
	}

	public int deleteComment(int no, int cno) {
		CommentDTO dto = new CommentDTO();
		dto.setNo(cno);
		dto.setBoard_no(no);
		dto.setMid((String) util.getSession().getAttribute("mid"));

		return boardDAO.deleteComment(dto);
	}

	public int likeUp(CommentDTO dto) {
		return boardDAO.likeUp(dto);
	}

}
