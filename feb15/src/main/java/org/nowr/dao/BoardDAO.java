package org.nowr.dao;

import java.util.List;

import org.nowr.dto.BoardDTO;
import org.nowr.dto.CommentDTO;
import org.nowr.dto.SearchDTO;
import org.nowr.dto.WriteDTO;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO extends AbstractDAO {
	
	public List<BoardDTO> boardList(SearchDTO searchDTO) {
		//System.out.println("다오 통과");
		return sqlSession.selectList("board.boardList", searchDTO);
	}
	public BoardDTO detail(int no) {
		return sqlSession.selectOne("board.detail", no);
	}
	public int write(WriteDTO dto) {
		return sqlSession.insert("board.write", dto);
	}
	public int commentWrite(CommentDTO comment) {
		return sqlSession.insert("board.commentWrite", comment);
	}
	public List<CommentDTO> commentsList(int no) {
		return sqlSession.selectList("board.commentsList", no);
	}
	public int postDel(WriteDTO dto) {
		return sqlSession.update("board.postDel", dto);
	}
	public int totalRecordCount(String search) {
		return sqlSession.selectOne("board.totalRecordCount", search);
	}
	public int deleteComment(CommentDTO dto) {
		return sqlSession.update("board.deleteComment", dto);
	}
	public void countUP(BoardDTO dto) {
		sqlSession.insert("board.countUP", dto);
	}
	public int alreadyRead(BoardDTO dto) {
		return sqlSession.selectOne("board.alreadyRead", dto);
	}
	public int likeUp(CommentDTO dto) {
		return sqlSession.update("board.likeUp", dto);
	}

}
