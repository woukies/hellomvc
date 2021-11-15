package io.github.woukies.spring_test_item_jdbc.service;

import java.util.ArrayList;

import org.springframework.ui.Model;

import io.github.woukies.spring_test_item_jdbc.dao.ItemDao;
import io.github.woukies.spring_test_item_jdbc.dto.ItemDto;

public class ItemContentService implements ItemService {

	@Override
	public void execute(Model model) {
		ItemDao dao = new ItemDao();

		ArrayList<ItemDto> dtos = dao.list();
		model.addAttribute("list", dtos);
	}
}
