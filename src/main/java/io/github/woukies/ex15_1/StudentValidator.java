package io.github.woukies.ex15_1;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class StudentValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Student.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		System.out.println("@@@### validate()");
		Student student = (Student) target;

		String id = student.getId();
		if (id == "" || id.trim().isEmpty()) {
			System.out.println("@@@### id is null or empty");
			errors.reject("id", "trouble");
		}

		String pw = student.getPw();
		if (pw == "" || pw.trim().isEmpty()) {
			System.out.println("@@@### pw is null or empty");
			errors.reject("pw", "trouble");
		}

	}
}
