package io.github.woukies.spring_mvc_board.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import io.github.woukies.spring_mvc_board.command.BCommand;
import io.github.woukies.spring_mvc_board.command.BContentCommand;
import io.github.woukies.spring_mvc_board.command.BDeleteCommand;
import io.github.woukies.spring_mvc_board.command.BListCommand;
import io.github.woukies.spring_mvc_board.command.BModifyCommand;
import io.github.woukies.spring_mvc_board.command.BWriteCommand;

@Controller
@RequestMapping("/spring_mvc_board")
public class BController {
	BCommand command;

	@RequestMapping("/list")
	public String list(Model model) {
		System.out.println("@@@### list()");

		command = new BListCommand();
		command.execute(model);

		return "/spring_mvc_board/list";
	}

	@RequestMapping("/write_view")
	public String write_view() {
		System.out.println("@@@### write_view()");

		return "/spring_mvc_board/write_view";
	}

	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model) {
		System.out.println("@@@### write()");

		model.addAttribute("request", request);
		command = new BWriteCommand();
		command.execute(model);

		return "redirect:list";
	}

	@RequestMapping("/content_view")
	public String content_view(HttpServletRequest request, Model model) {
		System.out.println("@@@### content_view()");

		model.addAttribute("request", request);
		command = new BContentCommand();
		command.execute(model);

		return "/spring_mvc_board/content_view";
	}
	
	@RequestMapping(value = "/modify")
	public String modify(HttpServletRequest request, Model model) {
		System.out.println("@@@### modify()");
		
		model.addAttribute("request", request);
		command = new BModifyCommand();
		command.execute(model);
		
		return "redirect:list";
	}
	
	@RequestMapping(value = "/delete")
	public String delete(HttpServletRequest request, Model model) {
		System.out.println("@@@### delete()");
		
		model.addAttribute("request", request);
		command = new BDeleteCommand();
		command.execute(model);
		
		return "redirect:list";
	}
}
