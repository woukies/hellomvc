package io.github.woukies.spring_test_item_mybatis.dao;

import java.util.ArrayList;

import io.github.woukies.spring_test_item_mybatis.dto.ItemDto;

public interface IItemDao {
	public void write(String name, int price, String description);
	public ArrayList<ItemDto> list();
}
