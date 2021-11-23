package io.github.woukies.spring_test_item_mybatis_std.dao;

import java.util.ArrayList;
import java.util.HashMap;

import io.github.woukies.spring_test_item_mybatis_std.dto.ItemDto;

public interface IItemDao {
	public void write(HashMap<String, String> param);
	public ArrayList<ItemDto> list();
}
