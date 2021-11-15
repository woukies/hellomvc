package io.github.woukies.spring_test_member_jdbc.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;

import io.github.woukies.spring_test_member_jdbc.util.Constant;

public class MemDao {
	JdbcTemplate template;

	public MemDao() {
		template = Constant.template;
	}

	public int doLogin(final String id, final String pw) {
		String query = "SELECT mem_uid, mem_pwd FROM mvc_member WHERE mem_uid = ?";

		return template.query(query, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, id);
			}
		}, new ResultSetExtractor<Integer>() {
			@Override
			public Integer extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					if (rs.getString("mem_pwd").equals(pw)) {
						return 1;
					} else { // 비번x
						return 0;
					}
				} else { // 아이디x
					return -1;
				}
			}
		}).intValue();
	}

	public int register(final String id, final String pw, final String name) {
		String query = "INSERT INTO mvc_member VALUES(?, ?, ?)";

		return template.update(query, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, id);
				ps.setString(2, pw);
				ps.setString(3, name);
			}
		});
	}
}
