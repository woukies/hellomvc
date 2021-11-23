package io.github.woukies.spring_test_member_mybatis_std.service;

import java.util.HashMap;

public interface MemService {
	public int doLogin(HashMap<String, String> param);
	public int register(HashMap<String, String> param);
}
