package io.github.woukies.spring_test_member_mybatis_std.service;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.woukies.spring_test_member_mybatis_std.dao.IMemDao;
import io.github.woukies.spring_test_member_mybatis_std.dto.MemDto;

@Service("MemService")
public class MemServiceImpl implements MemService {
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int doLogin(HashMap<String, String> param) {
		IMemDao dao = sqlSession.getMapper(IMemDao.class);
		int isLogin = -1;
		String inputUid = param.get("mem_uid");
		String inputPwd = param.get("mem_pwd");

		if (inputUid == null || inputPwd == null) {
			isLogin = -2; // 아이디, 비번 입력 없음
		} else {
			MemDto dto = dao.doLogin(param);

			if (dto == null) {
				isLogin = -1; // 아이디 없음
			} else if (!dto.getMem_pwd().equals(inputPwd)) {
				isLogin = 0; // 비번 틀림
			} else {
				isLogin = 1;
			}
		}

		return isLogin;
	}

	@Override
	public int register(HashMap<String, String> param) {
		IMemDao dao = sqlSession.getMapper(IMemDao.class);
		return dao.register(param);
	}

}
