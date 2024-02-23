package org.nowr.controller;
// 2024.02.23 요구사항 확인

import org.apache.commons.mail.EmailException;
import org.nowr.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MailController {
	// 제작순서
	// 1. menu에다가 추가 -> 2. Controller 추가 (기존꺼 or 새로 만들기)
	// 3. jsp 만들기 -> 4. 화면 구성 -> 5. Service, repository, mybatis...
	
	@Autowired
	private MailService mailService;
	
	
	@GetMapping("/mail")
	public  String mail() {
		// 로그인 한 사용자만 접근 가능합니다.
		return "mail";
	}
	
	// jsp -> Controller -> Service 메일발송 (딱 Service 까지만 발송)
	@PostMapping("/mail") // 담는방법 1. dto써서 jsp꺼 다 받아오기 2.map써서 자동으로 받아오기 3.@requestparam으로 받기
	public String mail(@RequestParam("email") String email, @RequestParam("title") String title, @RequestParam("content") String content) throws EmailException {
		// System.out.println("email :" + email);
		// System.err.println("content :" + content);
		// System.out.println("title :" + title);
		mailService.sendTextMail(email, title, content);
		mailService.sendHTMLMail(email, title, content);
		return "redirect:/mail";
	}


}
