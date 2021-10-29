package io.github.woukies.ex13_3;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Handles requests for the application home page.
 */
@Controller
public class Ex13_3_Controller {
	/*
	@RequestMapping("/ex13_3/member/join")
	public String joinData(@RequestParam("name") String name, @RequestParam("id") String id,
			@RequestParam("pw") String pw, @RequestParam("email") String email, Model model) {
		Member member = new Member();
		member.setName(name);
		member.setId(id);
		member.setPw(pw);
		member.setEmail(email);
		
		model.addAttribute("member", member);
		return "/ex13_3/member/join";
	}
	*/
	
	@RequestMapping("/ex13_3/member/join")
	public String joinData(Member member) {
		return "/ex13_3/member/join";
	}
}
