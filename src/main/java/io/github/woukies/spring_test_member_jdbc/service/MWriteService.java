package io.github.woukies.spring_test_member_jdbc.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import io.github.woukies.spring_test_member_jdbc.dao.MemDao;

public class MWriteService implements MemService {
	@Override
	public int execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");

		MemDao dao = new MemDao();

		String id = request.getParameter("mem_uid");
		String pw = request.getParameter("mem_pwd");
		String name = request.getParameter("mem_name");
		if (id != null && pw != null && name != null) {
			return dao.register(id, pw, name);
		} else {
			return -1;
		}
	}
}
