package io.github.woukies.spring_test_member_mybatis_std.dao;

import java.util.HashMap;

import io.github.woukies.spring_test_member_mybatis_std.dto.MemDto;

public interface IMemDao {
	public MemDto doLogin(HashMap<String, String> param);
	public int register(HashMap<String, String> param);
}
