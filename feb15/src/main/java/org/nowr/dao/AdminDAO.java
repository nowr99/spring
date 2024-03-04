package org.nowr.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.nowr.dto.BoardDTO;
import org.nowr.dto.NoticeDTO;
import org.nowr.dto.SearchDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository

public class AdminDAO {
	
	@Autowired
	private SqlSession sqlSession;

	public List<BoardDTO> boardList(SearchDTO searchDTO) {
		return sqlSession.selectList("admin.boardList", searchDTO);
	}

	public int totalRecordCount(SearchDTO searchDTO) {
		return sqlSession.selectOne("admin.totalRecordCount", searchDTO);
	}

	public int postDel(int no) {
		return sqlSession.update("admin.postDel", no);
	}

	public List<NoticeDTO> noticeList() {
		return sqlSession.selectList("admin.noticeList");
	}
	
}
