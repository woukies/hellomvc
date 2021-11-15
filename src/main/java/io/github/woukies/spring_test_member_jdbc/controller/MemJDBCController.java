package io.github.woukies.spring_test_member_jdbc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import io.github.woukies.spring_test_member_jdbc.service.MWriteService;
import io.github.woukies.spring_test_member_jdbc.service.MemLoginService;
import io.github.woukies.spring_test_member_jdbc.service.MemService;
import io.github.woukies.spring_test_member_jdbc.util.Constant;

@Controller
@RequestMapping("/spring_test_member_jdbc")
public class MemJDBCController {
	MemService service;
	JdbcTemplate template;

	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
		Constant.template = this.template;
	}

	@RequestMapping("/login")
	public String memLogin() {
		return "/spring_test_member_jdbc/login";
	}

	@RequestMapping("/login_check")
	public String memLoginOk(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);

		service = new MemLoginService();
		int flag = service.execute(model);

		if (flag == 1) {
			return "redirect:login_ok";
		} else {
			return "redirect:login";
		}
	}

	@RequestMapping("/login_ok")
	public String memLoginOk() {
		return "/spring_test_member_jdbc/login_ok";
	}

	@RequestMapping("/register")
	public String memRegister(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);

		service = new MWriteService();
		int flag = service.execute(model);

		if (flag > 0) {
			return "redirect:login";
		} else {
			return "/spring_test_member_jdbc/register";
		}
	}

}
