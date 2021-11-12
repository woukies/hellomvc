package io.github.woukies.spring_test_member.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import io.github.woukies.spring_test_member.service.MemLoginService;
import io.github.woukies.spring_test_member.service.MemService;

@Controller
@RequestMapping("/spring_test_member")
public class MemController {
	MemService service;
	
	@RequestMapping("/login")
	public String memLogin() {
		return "/spring_test_member/login";
	}

	@RequestMapping("/login_ok") //loginCheck
	public String memLoginOk(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		
		service = new MemLoginService();
		service.execute(model);
		/* 
		 *  ** 다른 방법 **
		 * 1: 성공, 0: 비번x, -1: 아이디x
		 * int flag = service.execute(model);
		 * 1 >> return redirect:login_ok;
		 * else >> return redirect: login;
		 * ** 여기는 중간 단계가 되어야 함(loginCheck)
		 * ** 추가로 @RequestMapping("/login_ok") 생성
		 */
		
		return "/spring_test_member/login_ok";
	}
}
