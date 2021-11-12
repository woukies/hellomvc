package io.github.woukies.spring_mvc_board_jdbc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import io.github.woukies.spring_mvc_board_jdbc.service.BService;
import io.github.woukies.spring_mvc_board_jdbc.service.BContentService;
import io.github.woukies.spring_mvc_board_jdbc.service.BDeleteService;
import io.github.woukies.spring_mvc_board_jdbc.service.BListService;
import io.github.woukies.spring_mvc_board_jdbc.service.BModifyService;
import io.github.woukies.spring_mvc_board_jdbc.service.BWriteService;

@Controller
@RequestMapping("/spring_mvc_board_jdbc")
public class BJDBCController {
	BService service;

	@RequestMapping("/list")
	public String list(Model model) {
		System.out.println("@@@### list()");

		service = new BListService();
		service.execute(model);

		return "/spring_mvc_board_jdbc/list";
	}

	@RequestMapping("/write_view")
	public String write_view() {
		System.out.println("@@@### write_view()");

		return "/spring_mvc_board_jdbc/write_view";
	}

	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model) {
		System.out.println("@@@### write()");

		model.addAttribute("request", request);
		service = new BWriteService();
		service.execute(model);

		return "redirect:list";
	}

	@RequestMapping("/content_view")
	public String content_view(HttpServletRequest request, Model model) {
		System.out.println("@@@### content_view()");

		model.addAttribute("request", request);
		service = new BContentService();
		service.execute(model);

		return "/spring_mvc_board_jdbc/content_view";
	}
	
	@RequestMapping(value = "/modify")
	public String modify(HttpServletRequest request, Model model) {
		System.out.println("@@@### modify()");
		
		model.addAttribute("request", request);
		service = new BModifyService();
		service.execute(model);
		
		return "redirect:list";
	}
	
	@RequestMapping(value = "/delete")
	public String delete(HttpServletRequest request, Model model) {
		System.out.println("@@@### delete()");
		
		model.addAttribute("request", request);
		service = new BDeleteService();
		service.execute(model);
		
		return "redirect:list";
	}
}
