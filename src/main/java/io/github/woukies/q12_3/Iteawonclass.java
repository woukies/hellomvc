package io.github.woukies.q12_3;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Iteawonclass {
	@RequestMapping("/q12_3/actor")
	public String actor(Model model) {
		model.addAttribute("name", "박새로이");
		return "/q12_3/actor";
	}

	@RequestMapping("/q12_3/actress")
	public String actress(Model model) {
		model.addAttribute("name", "조이서");
		return "/q12_3/actress";
	}
}
