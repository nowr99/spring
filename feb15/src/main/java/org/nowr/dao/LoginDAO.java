package org.nowr.dao;

import org.nowr.dto.LoginDTO;
import org.springframework.stereotype.Repository;

@Repository
public class LoginDAO extends AbstractDAO {

	public LoginDTO login(LoginDTO dto) {
		return sqlSession.selectOne("login.login", dto);
	}

	public void mcountUp(LoginDTO loginDTO) {
		sqlSession.update("login.mcountUp", loginDTO);
	}

	public void mcountReset(LoginDTO loginDTO) {
		sqlSession.update("login.mcountReset", loginDTO);
	}

	public String getEmail(String email) {
		return sqlSession.selectOne("login.getEmail", email);
	}
	
}
