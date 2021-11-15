package io.github.woukies.spring_test_member_jdbc.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import io.github.woukies.spring_test_member_jdbc.dao.MemDao;

public class MemLoginService implements MemService {

	@Override
	public int execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		MemDao dao = new MemDao();
		return dao.doLogin(request.getParameter("mem_uid"), request.getParameter("mem_pwd"));
	}
}
