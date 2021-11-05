package io.github.woukies.ex15_1;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ex15_1")
public class StudentController {
	@RequestMapping("/studentForm")
	public String studentForm() {
		return "/ex15_1/createPage";
	}
	
	
	// 경로가 한번씩 더 붙음, why?
	@RequestMapping("/student/create")
	public String studentCreate(Student student, BindingResult result) {
		String page = "createDonePage";

		StudentValidator validator = new StudentValidator();
		validator.validate(student, result);

		if (result.hasErrors()) {
			System.out.println("@@@### getFieldError(id) ===> " + result.getFieldError("id"));
			System.out.println("@@@### getFieldError(pw) ===> " + result.getFieldError("pw"));
			page = "createPage";
		}

		return "/ex15_1/" + page;
	}
}
