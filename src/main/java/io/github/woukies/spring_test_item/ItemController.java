package io.github.woukies.spring_test_item;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/spring_test_item")
public class ItemController {
	ItemService command;
	
	@RequestMapping("/itemWrite")
	public String itemWrite() {
		return "/spring_test_item/itemWrite";
	}
	
	@RequestMapping("/writeResult")
	public String writeResult(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		
		command = new ItemWriteService();
		command.execute(model);
		return "/spring_test_item/writeResult";
	}
	
	@RequestMapping("/content_view")
	public String content_view(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		
		command = new ItemContentService();
		command.execute(model);
		
		return "/spring_test_item/content_view";
	}
}
