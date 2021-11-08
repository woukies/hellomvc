package io.github.woukies.spring_mvc_board.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import io.github.woukies.spring_mvc_board.dao.BDao;

public class BContentCommand implements BCommand {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		BDao dao = new BDao();
		model.addAttribute("content_view", dao.contentView(request.getParameter("bId")));
	}
}
