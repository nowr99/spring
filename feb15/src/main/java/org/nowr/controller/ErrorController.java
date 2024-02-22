package org.nowr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorController {

@GetMapping("/error") 
	public String error() {
		return "error/error"; //  /WEB-INF/views/error/error.jsp
	}
}
// /error 잡기
