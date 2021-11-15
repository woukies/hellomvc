package io.github.woukies.spring_test_item_jdbc.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;

import io.github.woukies.spring_test_item_jdbc.dto.ItemDto;
import io.github.woukies.spring_test_item_jdbc.util.Constant;

public class ItemDao {
	JdbcTemplate template = null;

	public ItemDao() {
		template = Constant.template;
	}

	public void write(final String name, final int price, final String description) {
		String query = "INSERT INTO item ( name, price, description ) VALUES ( ?, ?, ? )";
		template.update(query, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, name);
				ps.setInt(2, price);
				ps.setString(3, description);
			}
		});
	}

	public ArrayList<ItemDto> list() {
		String query = "SELECT name, price, description FROM item";
		return (ArrayList<ItemDto>) template.query(query, new BeanPropertyRowMapper(ItemDto.class));
	}
}
