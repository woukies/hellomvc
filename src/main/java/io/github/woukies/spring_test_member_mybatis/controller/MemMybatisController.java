package io.github.woukies.spring_test_member_mybatis.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import io.github.woukies.spring_test_member_mybatis.dao.IMemDao;
import io.github.woukies.spring_test_member_mybatis.dto.MemDto;

@Controller
@RequestMapping("/spring_test_member_mybatis")
public class MemMybatisController {
	@Autowired
	private SqlSession sqlSession;

	@RequestMapping("/login")
	public String memLogin() {
		return "/spring_test_member_mybatis/login";
	}

	@RequestMapping("/login_check")
	public String memLoginCheck(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);

		IMemDao dao = sqlSession.getMapper(IMemDao.class);
		MemDto dto = dao.doLogin(request.getParameter("mem_uid"));

		if (dto != null && dto.getMem_pwd().equals(request.getParameter("mem_pwd"))) {
			return "redirect:login_ok";
		} else {
			return "redirect:login";
		}
	}

	@RequestMapping("/login_ok")
	public String memLoginOk() {
		return "/spring_test_member_mybatis/login_ok";
	}

	@RequestMapping("/register")
	public String memRegister() {
		return "/spring_test_member_mybatis/register";
	}

	@RequestMapping("/register_check")
	public String registCheck(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);

		IMemDao dao = sqlSession.getMapper(IMemDao.class);
		int flag = dao.register(request.getParameter("mem_uid"), request.getParameter("mem_pwd"),
				request.getParameter("mem_name"));

		if (flag > 0) {
			return "redirect:login";
		} else {
			return "redirect:register";
		}
	}

}
