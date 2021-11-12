package io.github.woukies.spring_test_member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MemDao {
	DataSource dataSource;

	public MemDao() {
		try {
			// tomcat context.xml
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
		} catch (NamingException e) {
			e.printStackTrace();
		} finally {
		}
	}

	public boolean doLogin(String id, String pw) {
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		boolean isLogin = false;

		try {
			connection = dataSource.getConnection();
			pStatement = connection.prepareStatement("SELECT mem_uid, mem_pwd FROM mvc_member WHERE mem_uid = ?");
			pStatement.setString(1, id);
			resultSet = pStatement.executeQuery();
			if (resultSet.next()) {
				if (resultSet.getString("mem_pwd").equals(pw)) {
					isLogin = true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (pStatement != null) {
					pStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return isLogin;
	}
}
