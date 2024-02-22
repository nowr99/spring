package org.nowr.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.nowr.dto.BoardDTO;
import org.nowr.dto.CommentDTO;
import org.nowr.dto.WriteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	
	public List<BoardDTO> boardList(int pageNo) {
		//System.out.println("다오 통과");
		return sqlSession.selectList("board.boardList", pageNo);
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
	public List<CommentDTO> commentsList(int reNo) {
		return sqlSession.selectList("board.commentsList", reNo);
	}
	public int postDel(WriteDTO dto) {
		return sqlSession.update("board.postDel", dto);
	}
	public int totalRecordCount() {
		return sqlSession.selectOne("board.totalRecordCount");
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
