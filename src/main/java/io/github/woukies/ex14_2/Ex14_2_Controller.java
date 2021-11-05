package io.github.woukies.ex14_2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ex14_2")
public class Ex14_2_Controller {
	@RequestMapping("/index")
	public String index() {
		return "/ex14_2/index";
	}
	
	@RequestMapping("/studentView")
//	public String studentView(StudentInformation studentInformation) {
	public String studentView(@ModelAttribute("studentInfo") StudentInformation studentInformation) {
		return "/ex14_2/studentView";
	}
}
