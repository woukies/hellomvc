package io.github.woukies.spring_mvc_board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class BDao {
	DataSource dataSource;

	public BDao() {
		try {
			// tomcat context.xml
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
		} catch (NamingException e) {
			e.printStackTrace();
		} finally {

		}
	}

	public void write(String bName, String bTitle, String bContent) {
		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = dataSource.getConnection();
			pStatement = connection.prepareStatement("INSERT INTO mvc_board ( bid, bname, btitle, bcontent, bhit ) VALUES ( mvc_board_seq.NEXTVAL, ?, ?, ?, 0 )");
			pStatement.setString(1, bName);
			pStatement.setString(2, bTitle);
			pStatement.setString(3, bContent);
			
			int rn = pStatement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {

		}
	}
}
