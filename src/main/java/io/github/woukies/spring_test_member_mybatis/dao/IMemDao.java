package io.github.woukies.spring_test_member_mybatis.dao;

import io.github.woukies.spring_test_member_mybatis.dto.MemDto;

public interface IMemDao {
	public MemDto doLogin(String id);
	public int register(String id, String pw, String name);
}
