package org.nowr.dao;

import org.nowr.dto.MemberDTO;
import org.springframework.stereotype.Repository;

@Repository
public class RestDAO extends AbstractDAO {
		
	public String getEmail (String id) {
		return sqlSession.selectOne("rest.getEmail", id);
	}

	public void setKey(MemberDTO dto) {
		sqlSession.update("rest.setKey", dto);
	}
	
}
