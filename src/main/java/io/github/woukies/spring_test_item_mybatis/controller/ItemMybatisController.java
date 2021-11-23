package io.github.woukies.spring_test_item_mybatis.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import io.github.woukies.spring_test_item_mybatis.dao.IItemDao;

@Controller
@RequestMapping("/spring_test_item_mybatis")
public class ItemMybatisController {
	@Autowired
	private SqlSession sqlSession;

	@RequestMapping("/itemWrite")
	public String itemWrite() {
		return "/spring_test_item_mybatis/itemWrite";
	}

	@RequestMapping("/writeResult")
	public String writeResult(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);

		try {
			request.setCharacterEncoding("euc-kr");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		IItemDao dao = sqlSession.getMapper(IItemDao.class);
		dao.write(request.getParameter("name"), Integer.parseInt(request.getParameter("price")),
				request.getParameter("description"));

		return "/spring_test_item_mybatis/writeResult";
	}

	@RequestMapping("/content_view")
	public String content_view(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);

		IItemDao dao = sqlSession.getMapper(IItemDao.class);
		model.addAttribute("list", dao.list());

		return "/spring_test_item_mybatis/content_view";
	}
}
