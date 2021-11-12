package io.github.woukies.spring_mvc_board_jdbc.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import io.github.woukies.spring_mvc_board_jdbc.dao.BDao;

public class BContentService implements BService{
	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		BDao dao = new BDao();
		model.addAttribute("content_view", dao.contentView(request.getParameter("bId")));
	}
}
