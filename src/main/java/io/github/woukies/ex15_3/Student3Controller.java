package io.github.woukies.ex15_3;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ex15_3")
public class Student3Controller {
	@RequestMapping("/studentForm")
	public String studentForm() {
		return "/ex15_3/createPage";
	}

	// ���ε� �ּҷ� �̵��ϰ� �� ���εǸ鼭 ������ ����� ��
	@RequestMapping("/student/create")
	public String studentCreate(@Valid Student student, BindingResult result) {
		String page = "createDonePage";

		if (result.hasErrors()) {
			System.out.println("@@@### getFieldError(id) ===> " + result.getFieldError("id"));
			System.out.println("@@@### getFieldError(pw) ===> " + result.getFieldError("pw"));
			page = "createPage";
		}

		return "/ex15_3/" + page;
	}
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new StudentValidator());
	}
}
