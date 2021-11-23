package io.github.woukies.spring_test_item_mybatis_std.service;

import java.util.ArrayList;
import java.util.HashMap;

import io.github.woukies.spring_test_item_mybatis_std.dto.ItemDto;

public interface IService {
	public void write(HashMap<String, String> param);
	public ArrayList<ItemDto> list();
}
