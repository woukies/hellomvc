package io.github.woukies.spring_mvc_board_std.controller;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import io.github.woukies.spring_mvc_board_std.service.BService;

@Controller
@RequestMapping("/spring_mvc_board_std")
public class BSTDController {

	@Autowired
	private SqlSession sqlSession;

	@Autowired
	private BService service;

	@RequestMapping("/list")
	public String list(Model model) {
		System.out.println("@@@### list()");

		model.addAttribute("list", service.list());

		return "/spring_mvc_board_std/list";
	}

	@RequestMapping("/write_view")
	public String write_view() {
		System.out.println("@@@### write_view()");

		return "/spring_mvc_board_std/write_view";
	}

	@RequestMapping("/write")
	public String write(@RequestParam HashMap<String, String> param, Model model) {
		System.out.println("@@@### write()");

		service.write(param);

		return "redirect:list";
	}

	@RequestMapping("/content_view")
	public String content_view(@RequestParam HashMap<String, String> param, Model model) {
		System.out.println("@@@### content_view()");

		model.addAttribute("content_view", service.contentView(param));

		return "/spring_mvc_board_std/content_view";
	}

	@RequestMapping(value = "/modify")
	public String modify(@RequestParam HashMap<String, String> param, Model model) {
		System.out.println("@@@### modify()");

		service.modify(param);

		return "redirect:list";
	}

	@RequestMapping(value = "/delete")
	public String delete(@RequestParam HashMap<String, String> param, Model model) {
		System.out.println("@@@### delete()");

		service.delete(param);

		return "redirect:list";
	}
}
