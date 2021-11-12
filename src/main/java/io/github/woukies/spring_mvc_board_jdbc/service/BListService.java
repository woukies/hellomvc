package io.github.woukies.spring_mvc_board_jdbc.service;

import java.util.ArrayList;

import org.springframework.ui.Model;

import io.github.woukies.spring_mvc_board_jdbc.dao.BDao;
import io.github.woukies.spring_mvc_board_jdbc.dto.BDto;


public class BListService implements BService{
	@Override
	public void execute(Model model) {
		BDao dao = new BDao();
		ArrayList<BDto> dtos = dao.list();
		model.addAttribute("list", dtos);
	}
}
