package io.github.woukies;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
//@RequestMapping("board")
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}

	@RequestMapping("/board/view")
	public String view() {
		return "board/view";
	}

	@RequestMapping("/board/title")
	public String title(Model model) {
		model.addAttribute("id", 30);
		return "board/title";
	}

	@RequestMapping("/board/reply")
	public ModelAndView replay() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("id", "gildong");
		mv.setViewName("board/reply");
		return mv;
	}

	@RequestMapping("/shopping")
	public String shopping() {
		return "shopping";
	}

	@RequestMapping("/board/write")
	public String write(Model model) {
		model.addAttribute("id", "aaa");
		return "board/write";
	}

	@RequestMapping("/q12_1/board/content")
	public String content() {
		return "/q12_1/board/content";
	}

	@RequestMapping("/q12_1a/car/tesla")
	public String car() {
		return "/q12_1a/car/tesla";
	}

	@RequestMapping("/q12_2/trot/student")
	public String student(Model model) {
		model.addAttribute("id", "youngwoong");
		return "/q12_2/trot/student";
	}

	@RequestMapping("/q12_2/trot/admin")
	public ModelAndView admin() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("id", "boom");
		mv.setViewName("/q12_2/trot/admin");
		return mv;
	}
}
