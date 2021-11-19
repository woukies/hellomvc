package io.github.woukies.spring_mvc_board_mybatis.dao;

import java.util.ArrayList;

import io.github.woukies.spring_mvc_board_mybatis.dto.BDto;

public interface IBDao {
	public ArrayList<BDto> list();
	public void write(String bName, String bTitle, String bContent);
	public BDto contentView(String strID);
	public void modify(String bId, String bName, String bTitle, String bContent);
	public void delete(String bId);
}
