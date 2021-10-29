package io.github.woukies.q12_4;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/q12_4/portpolio")
@Controller
public class portpolioController {
	@RequestMapping("/airbnb")
	public String airbnb(Model model) {
		model.addAttribute("title", "숙소예약");
		return "/q12_4/portpolio/airbnb";
	}
	@RequestMapping("/universityManager")
	public String universityManager(Model model) {
		model.addAttribute("title", "학사관리");
		return "/q12_4/portpolio/universityManager";
	}
	@RequestMapping("/bookManager")
	public String bookManager(Model model) {
		model.addAttribute("title", "도서관리");
		return "/q12_4/portpolio/bookManager";
	}
}
