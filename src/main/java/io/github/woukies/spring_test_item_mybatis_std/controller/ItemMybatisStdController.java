package io.github.woukies.spring_test_item_mybatis_std.controller;

import java.util.HashMap;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import io.github.woukies.spring_test_item_mybatis_std.service.IService;

@Controller
@RequestMapping("/spring_test_item_mybatis_std")
public class ItemMybatisStdController {
	@Autowired
	private SqlSession sqlSession;
	
	@Autowired
	private IService service;

	@RequestMapping("/itemWrite")
	public String itemWrite() {
		return "/spring_test_item_mybatis_std/itemWrite";
	}

	@RequestMapping("/writeResult")
	public String writeResult(@RequestParam HashMap<String, String> param, Model model) {
		service.write(param);

		return "/spring_test_item_mybatis_std/writeResult";
	}

	@RequestMapping("/content_view")
	public String content_view(@RequestParam HashMap<String, String> param, Model model) {
		model.addAttribute("list", service.list());

		return "/spring_test_item_mybatis_std/content_view";
	}
}
