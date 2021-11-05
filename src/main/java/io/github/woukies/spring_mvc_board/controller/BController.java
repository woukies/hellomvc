package io.github.woukies.spring_mvc_board.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import io.github.woukies.spring_mvc_board.command.BCommand;
import io.github.woukies.spring_mvc_board.command.BWriteCommand;

@Controller
@RequestMapping("/spring_mvc_board")
public class BController {
	BCommand command;
	
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
		
		return ""; ///spring_mvc_board/write
	}
}
