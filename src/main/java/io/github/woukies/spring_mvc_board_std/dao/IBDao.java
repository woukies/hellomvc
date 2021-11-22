package io.github.woukies.spring_mvc_board_std.dao;

import java.util.ArrayList;
import java.util.HashMap;

import io.github.woukies.spring_mvc_board_std.dto.BDto;

public interface IBDao {
	public ArrayList<BDto> list();
	public void write(HashMap<String, String> param);
	public BDto contentView(HashMap<String, String> param);
	public void modify(HashMap<String, String> param);
	public void delete(HashMap<String, String> param);
}
