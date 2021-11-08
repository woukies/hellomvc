package io.github.woukies.spring_test_item;

import java.util.ArrayList;

import org.springframework.ui.Model;

public class ItemContentService implements ItemService {

	@Override
	public void execute(Model model) {
		ItemDao dao = new ItemDao();

		ArrayList<ItemDto> dtos = dao.list();
		model.addAttribute("list", dtos);
	}
}
