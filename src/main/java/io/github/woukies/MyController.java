package io.github.woukies;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {
	@RequestMapping("/shopping2")
	public String shopping2() {
		return "shopping2";
	}
}
