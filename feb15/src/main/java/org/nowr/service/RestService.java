package org.nowr.service;

import org.apache.commons.mail.EmailException;
import org.nowr.dao.RestDAO;
import org.nowr.dto.MemberDTO;
import org.nowr.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestService {

	@Autowired
	private Util util;
	
	@Autowired
	private RestDAO restDAO;

	public int sendEmail() throws EmailException {
		if (util.getSession().getAttribute("mid") != null) {
			// 메일 발송 + key 데이터베이스에 저장
			String email = getEmail((String) util.getSession().getAttribute("mid"));
			String key = util.createKey();
			
			MemberDTO dto = new MemberDTO();
			dto.setMemail(email);
			dto.setMkey(key);
			dto.setMid((String) util.getSession().getAttribute("mid"));
			restDAO.setKey(dto); // db에 키 저장하기
			util.sendEmail(email, key);
			return 1;
		} else {
			return 0;
		}
	}
	public String getEmail(String email) {
		System.out.println(email);
		System.out.println("rest service 통과");
		return restDAO.getEmail(email);
	}
	
}
