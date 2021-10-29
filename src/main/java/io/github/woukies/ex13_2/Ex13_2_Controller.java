package io.github.woukies.ex13_2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Handles requests for the application home page.
 */
@Controller
public class Ex13_2_Controller {
	@RequestMapping("/ex13_2/board/checkId")
	public String checkId(@RequestParam("id") String id, @RequestParam("pw") String pw, Model model) {
		// @RequestParam 값 빠지면 400 에러
		model.addAttribute("identify", id);
		model.addAttribute("password", pw);
		return "/ex13_2/board/checkId";
	}
}
