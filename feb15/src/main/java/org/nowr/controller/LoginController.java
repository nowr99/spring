package org.nowr.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.mail.EmailException;
import org.nowr.dto.LoginDTO;
import org.nowr.dto.MemberDTO;
import org.nowr.service.LoginService;
import org.nowr.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;

	@Autowired
	private Util util;

	// 로그인만들기 24-02-20
	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@PostMapping("/login")
	public String login(HttpServletRequest request) {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		// System.out.println("id : " + id + " / pw : " + pw);

		LoginDTO loginDTO = new LoginDTO();
		loginDTO.setId(id);
		loginDTO.setPw(pw);

		LoginDTO login = loginService.login(loginDTO);
		if (login.getCount() == 1 && login.getMcount() < 5) {
			if (login.getPw().equals(loginDTO.getPw())) { // 비밀번호 비교

				// 세션만들기
				HttpSession session = request.getSession();
				session.setAttribute("mid", id);
				session.setAttribute("mname", login.getMname());
				// 해당 id의 mcount를 0으로 만들기
				loginService.mcountReset(loginDTO);
				return "redirect:/index";
			} else {
				// mcountUP
				loginService.mcountUp(loginDTO);
				return "redirect:/login?count=" + login.getMcount();
			}
		} else if (login.getMcount() < 5) {
			return "redirect:/login?count=" + login.getMcount();
		} else {
			// 잘못된 로그인일때 로그인 창으로 이동, 5번 시도 시 잠그기
			// 해당 id의 mcount를 +1 시키기
			loginService.mcountUp(loginDTO);
			return "redirect:/login?login=1024";
		}

	}

	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("mid") != null) {
			session.removeAttribute("mid");
		}
		if (session.getAttribute("mname") != null) {
			session.removeAttribute("mname");
		}
		session.invalidate(); // 이거 꼭 확인하기.

		return "redirect:/login";
	}

	// myinfo 들어가면 인증번호 보내기 24.02.21
	@GetMapping("/myInfo@{id}")
	public String myInfo(@PathVariable("id") String id) throws EmailException {
		// System.out.println("id :" + id);
		// 로그인 했나 검사 후 실행
		if (util.getSession().getAttribute("mid") != null) {

			// 인증요청 -> ajax용으로 만들꺼임
			//loginService.myInfo();

			return "myinfo";
		} else {
		
		return "redirect:/login";
	}

}
}