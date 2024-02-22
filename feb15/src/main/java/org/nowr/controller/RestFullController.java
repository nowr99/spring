package org.nowr.controller;

import org.apache.commons.mail.EmailException;
import org.apache.ibatis.annotations.Param;
import org.nowr.dto.BoardDTO;
import org.nowr.service.BoardService;
import org.nowr.service.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestFullController {
	// ajax, json애들 전용 @RestController -> @responsebody 빼도 됨

	@Autowired
	private BoardService boardService;

	@Autowired
	private RestService restService;

	@PostMapping("/restDetail")
	public BoardDTO restDetail(@Param("no") int no) {
		// System.out.println("restDetail : " + no);
		BoardDTO detail = boardService.detail(no);
		return detail;
	}

	@PostMapping("/emailAuth")
	public int emailAuth() throws EmailException {
		System.err.println("emailAuth통과");
		return restService.sendEmail();

	}
}
