package io.github.woukies.spring_test_item_mybatis_std.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.woukies.spring_test_item_mybatis_std.dao.IItemDao;
import io.github.woukies.spring_test_item_mybatis_std.dto.ItemDto;

@Service("IService")
public class IServiceImpl implements IService{
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void write(HashMap<String, String> param) {
		IItemDao dao = sqlSession.getMapper(IItemDao.class);
		dao.write(param);
	}

	@Override
	public ArrayList<ItemDto> list() {
		IItemDao dao = sqlSession.getMapper(IItemDao.class);
		return dao.list();
	}

}
