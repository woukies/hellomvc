package io.github.woukies.ex14_3;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ex14_3")
public class RedirectController {
	@RequestMapping("/studentConfirm")
	public String studentRedirect(HttpServletRequest httpServletRequest) {
		String id = httpServletRequest.getParameter("id");

		if (id.equals("abc")) {
			return "redirect:studentOk";
		}
		return "redirect:studentNg";
	}

	@RequestMapping("/studentOk")
	public String studentOk() {
		return "/ex14_3/student/studentOk";
	}

	@RequestMapping("/studentNg")
	public String studentNg() {
		return "/ex14_3/student/studentNg";
	}
}
