package io.github.woukies.spring_test_item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ItemDao {
	DataSource dataSource;

	public ItemDao() {
		try {
			// tomcat context.xml
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
		} catch (NamingException e) {
			e.printStackTrace();
		} finally {
		}
	}

	public void write(String name, int price, String description) {
		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = dataSource.getConnection();
			pStatement = connection
					.prepareStatement("INSERT INTO item ( name, price, description ) VALUES ( ?, ?, ? )");
			pStatement.setString(1, name);
			pStatement.setInt(2, price);
			pStatement.setString(3, description);

			pStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
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
	}

	public ArrayList<ItemDto> list() {
		ArrayList<ItemDto> dtos = new ArrayList<ItemDto>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;

		try {
			connection = dataSource.getConnection();
			pStatement = connection.prepareStatement("SELECT name, price, description FROM item");
			resultSet = pStatement.executeQuery();

			while (resultSet.next()) {
				ItemDto dto = new ItemDto(resultSet.getString("name"), resultSet.getInt("price"),
						resultSet.getString("description"));

				dtos.add(dto);
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

		return dtos;
	}
}
