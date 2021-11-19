package io.github.woukies.spring_mvc_board_mybatis.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import io.github.woukies.spring_mvc_board_mybatis.dao.IBDao;
import io.github.woukies.spring_mvc_board_mybatis.util.Constant;

@Controller
@RequestMapping("/spring_mvc_board_mybatis")
public class BMybatisController {

	public JdbcTemplate template;

	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
		Constant.template = this.template;
	}

	@Autowired
	private SqlSession sqlSession;

	@RequestMapping("/list")
	public String list(Model model) {
		System.out.println("@@@### list()");

		IBDao dao = sqlSession.getMapper(IBDao.class);
		model.addAttribute("list", dao.list());

		return "/spring_mvc_board_mybatis/list";
	}

	@RequestMapping("/write_view")
	public String write_view() {
		System.out.println("@@@### write_view()");

		return "/spring_mvc_board_mybatis/write_view";
	}

	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model) {
		System.out.println("@@@### write()");

		try {
			request.setCharacterEncoding("euc-kr");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		IBDao dao = sqlSession.getMapper(IBDao.class);
		dao.write(request.getParameter("bName"), request.getParameter("bTitle"), request.getParameter("bContent"));

		return "redirect:list";
	}

	@RequestMapping("/content_view")
	public String content_view(HttpServletRequest request, Model model) {
		System.out.println("@@@### content_view()");

		IBDao dao = sqlSession.getMapper(IBDao.class);
		model.addAttribute("content_view", dao.contentView(request.getParameter("bId")));

		return "/spring_mvc_board_mybatis/content_view";
	}

	@RequestMapping(value = "/modify")
	public String modify(HttpServletRequest request, Model model) {
		System.out.println("@@@### modify()");

		try {
			request.setCharacterEncoding("euc-kr");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		IBDao dao = sqlSession.getMapper(IBDao.class);
		dao.modify(request.getParameter("bId"), request.getParameter("bName"), request.getParameter("bTitle"),
				request.getParameter("bContent"));

		return "redirect:list";
	}

	@RequestMapping(value = "/delete")
	public String delete(HttpServletRequest request, Model model) {
		System.out.println("@@@### delete()");

		IBDao dao = sqlSession.getMapper(IBDao.class);
		dao.delete(request.getParameter("bId"));

		return "redirect:list";
	}
}
