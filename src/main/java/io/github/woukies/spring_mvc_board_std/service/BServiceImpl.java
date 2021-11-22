package io.github.woukies.spring_mvc_board_std.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.woukies.spring_mvc_board_std.dao.IBDao;
import io.github.woukies.spring_mvc_board_std.dto.BDto;

@Service("BService")
public class BServiceImpl implements BService {
	@Autowired
	private SqlSession sqlSession;

	@Override
	public ArrayList<BDto> list() {
		System.out.println("@@@### BServiceImpl.list()");
		
		IBDao dao = sqlSession.getMapper(IBDao.class);
		return dao.list();
	}

	@Override
	public void write(HashMap<String, String> param) {
		System.out.println("@@@### BServiceImpl.write()");
		
		IBDao dao = sqlSession.getMapper(IBDao.class);
		dao.write(param);
	}

	@Override
	public BDto contentView(HashMap<String, String> param) {
		System.out.println("@@@### BServiceImpl.contentView()");

		IBDao dao = sqlSession.getMapper(IBDao.class);
		return dao.contentView(param);
	}

	@Override
	public void modify(HashMap<String, String> param) {
		System.out.println("@@@### BServiceImpl.modify()");

		IBDao dao = sqlSession.getMapper(IBDao.class);
		dao.modify(param);
	}

	@Override
	public void delete(HashMap<String, String> param) {
		System.out.println("@@@### BServiceImpl.delete()");
		
		IBDao dao = sqlSession.getMapper(IBDao.class);
		dao.delete(param);		
	}

}
