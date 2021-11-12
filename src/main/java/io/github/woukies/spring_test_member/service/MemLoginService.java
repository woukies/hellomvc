package io.github.woukies.spring_test_member.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import io.github.woukies.spring_test_member.dao.MemDao;

public class MemLoginService implements MemService {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		MemDao dao = new MemDao();
		boolean isLogin = dao.doLogin(request.getParameter("mem_uid"), request.getParameter("mem_pwd"));
		model.addAttribute("isLogin", isLogin);
	}
}
