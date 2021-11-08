package io.github.woukies.spring_test_item;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public class ItemWriteService implements ItemService{

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		ItemDao dao = new ItemDao();
		String name = request.getParameter("name");
		int price = Integer.parseInt(request.getParameter("price"));
		String description = request.getParameter("description");
		dao.write(name, price, description);
	}
}
