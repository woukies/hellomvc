package io.github.woukies.ex14_1_1;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class Ex14_1_1_Controller {
	@RequestMapping("/ex14_1_1/index")
	public String goIndex() {
		return "/ex14_1_1/index";
	}
	
//	@RequestMapping("/ex14_1/student")
//	@RequestMapping(method = RequestMethod.GET, value = "/ex14_1/student")
	@RequestMapping(method = RequestMethod.GET, value = "/ex14_1_1/student")
	public String goStudent(HttpServletRequest httpServletRequest, Model model) {
		System.out.println("@@@### RequestMethod.GET");
		
		String id = httpServletRequest.getParameter("id");
		System.out.println("@@@### id ===> "+ id);
		model.addAttribute("studentId", id);
		
		return "/ex14_1_1/student/studentId";
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/ex14_1_1/student")
	public ModelAndView goStudent(HttpServletRequest httpServletRequest) {
		System.out.println("@@@### RequestMethod.POST");
		
		String id = httpServletRequest.getParameter("id");
		System.out.println("@@@### id ===> "+ id);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("studentId", id);
		mv.setViewName("/ex14_1_1/student/studentId");
		
		return mv;
	}
}
