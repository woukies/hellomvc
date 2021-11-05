package io.github.woukies.ex15_2;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ex15_2")
public class Student2Controller {
	@RequestMapping("/studentForm")
	public String studentForm() {
		return "/ex15_2/createPage";
	}

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

		return "/ex15_2/" + page;
	}
}
