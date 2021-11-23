package io.github.woukies.spring_test_member_mybatis_std.controller;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import io.github.woukies.spring_test_member_mybatis_std.service.MemService;

@Controller
@RequestMapping("/spring_test_member_mybatis_std")
public class MemMybatisStdController {
	// servlet-context.xml, pom.xml	
	
	@Autowired
	private SqlSession sqlSession;
	
	@Autowired
	private MemService service;

	@RequestMapping("/login")
	public String memLogin() {
		return "/spring_test_member_mybatis_std/login";
	}

	@RequestMapping("/login_check")
	public String memLoginCheck(@RequestParam HashMap<String, String> param, Model model) {
		if (service.doLogin(param) == 1) {
			return "redirect:login_ok";
		} else {
			return "redirect:login";
		}
	}

	@RequestMapping("/login_ok")
	public String memLoginOk() {
		return "/spring_test_member_mybatis_std/login_ok";
	}

	@RequestMapping("/register")
	public String memRegister() {
		return "/spring_test_member_mybatis_std/register";
	}

	@RequestMapping("/register_check")
	public String registCheck(@RequestParam HashMap<String, String> param, Model model) {
		if (service.register(param) == 1) {
			return "redirect:login";
		} else {
			return "redirect:register";
		}
	}

}
