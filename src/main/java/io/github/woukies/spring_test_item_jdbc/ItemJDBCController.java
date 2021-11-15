package io.github.woukies.spring_test_item_jdbc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import io.github.woukies.spring_test_item_jdbc.service.*;
import io.github.woukies.spring_test_item_jdbc.util.Constant;

@Controller
@RequestMapping("/spring_test_item_jdbc")
public class ItemJDBCController {
	ItemService service;
	
	public JdbcTemplate template;
	
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
		Constant.template = this.template;
	}
	
	@RequestMapping("/itemWrite")
	public String itemWrite() {
		return "/spring_test_item_jdbc/itemWrite";
	}
	
	@RequestMapping("/writeResult")
	public String writeResult(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		
		service = new ItemWriteService();
		service.execute(model);
		return "/spring_test_item_jdbc/writeResult";
	}
	
	@RequestMapping("/content_view")
	public String content_view(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		
		service = new ItemContentService();
		service.execute(model);
		
		return "/spring_test_item_jdbc/content_view";
	}
}
