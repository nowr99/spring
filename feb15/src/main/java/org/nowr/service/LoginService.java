package org.nowr.service;

import org.nowr.dao.LoginDAO;
import org.nowr.dto.LoginDTO;
import org.nowr.dto.MemberDTO;
import org.nowr.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService extends AbstractService {
	
	@Autowired
	private LoginDAO loginDAO;
	
	
	public LoginDTO login(LoginDTO dto) {
		return loginDAO.login(dto);
	}

	public void mcountUp(LoginDTO loginDTO) {
		loginDAO.mcountUp(loginDTO);
	}

	public void mcountReset(LoginDTO loginDTO) {
		loginDAO.mcountReset(loginDTO);
	}

	public int join(MemberDTO join) {
		return loginDAO.join(join);
	}


	


	
	
}