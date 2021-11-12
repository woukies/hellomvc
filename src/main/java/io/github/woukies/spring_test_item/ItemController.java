package io.github.woukies.spring_test_item;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/spring_test_item")
public class ItemController {
	ItemService service;
	
	@RequestMapping("/itemWrite")
	public String itemWrite() {
		return "/spring_test_item/itemWrite";
	}
	
	@RequestMapping("/writeResult")
	public String writeResult(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		
		service = new ItemWriteService();
		service.execute(model);
		return "/spring_test_item/writeResult";
	}
	
	@RequestMapping("/content_view")
	public String content_view(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		
		service = new ItemContentService();
		service.execute(model);
		
		return "/spring_test_item/content_view";
	}
}
