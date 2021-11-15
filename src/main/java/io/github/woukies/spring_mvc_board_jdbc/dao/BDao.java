package io.github.woukies.spring_mvc_board_jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;

import io.github.woukies.spring_mvc_board_jdbc.dto.BDto;
import io.github.woukies.spring_mvc_board_jdbc.util.Constant;

public class BDao {
	DataSource dataSource;
	JdbcTemplate template = null;

	public BDao() {
		/*
		 * try { // tomcat context.xml Context context = new InitialContext();
		 * dataSource = (DataSource) context.lookup("java:comp/env/jdbc/oracle"); }
		 * catch (NamingException e) { e.printStackTrace(); }
		 */

		template = Constant.template;
	}

	public ArrayList<BDto> list() {
		String query = "SELECT bid, bname, btitle, bcontent, bdate, bhit FROM mvc_board ORDER BY bid DESC";

		return (ArrayList<BDto>) template.query(query, new BeanPropertyRowMapper(BDto.class));

		/*
		 * ArrayList<BDto> dtos = new ArrayList<BDto>(); Connection connection = null;
		 * PreparedStatement pStatement = null; ResultSet resultSet = null;
		 * 
		 * try { connection = dataSource.getConnection(); pStatement =
		 * connection.prepareStatement(
		 * "SELECT bid, bname, btitle, bcontent, bdate, bhit FROM mvc_board ORDER BY bid DESC"
		 * ); resultSet = pStatement.executeQuery();
		 * 
		 * while (resultSet.next()) { BDto dto = new BDto(resultSet.getInt("bid"),
		 * resultSet.getString("bname"), resultSet.getString("btitle"),
		 * resultSet.getString("bcontent"), resultSet.getTimestamp("bdate"),
		 * resultSet.getInt("bhit"));
		 * 
		 * dtos.add(dto); } } catch (Exception e) { e.printStackTrace(); } finally { try
		 * { if (resultSet != null) { resultSet.close(); } if (pStatement != null) {
		 * pStatement.close(); } if (connection != null) { connection.close(); } } catch
		 * (Exception e2) { e2.printStackTrace(); } }
		 * 
		 * return dtos;
		 */
	}

	public void write(final String bName, final String bTitle, final String bContent) {
		template.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				String query = "INSERT INTO mvc_board ( bid, bname, btitle, bcontent, bhit ) VALUES ( mvc_board_seq.NEXTVAL, ?, ?, ?, 0 )";
				PreparedStatement pStatement = con.prepareStatement(query);
				pStatement.setString(1, bName);
				pStatement.setString(2, bTitle);
				pStatement.setString(3, bContent);
				return pStatement;
			}
		});

		/*
		 * Connection connection = null; PreparedStatement pStatement = null; try {
		 * connection = dataSource.getConnection(); pStatement =
		 * connection.prepareStatement(
		 * "INSERT INTO mvc_board ( bid, bname, btitle, bcontent, bhit ) VALUES ( mvc_board_seq.NEXTVAL, ?, ?, ?, 0 )"
		 * ); pStatement.setString(1, bName); pStatement.setString(2, bTitle);
		 * pStatement.setString(3, bContent);
		 * 
		 * int rn = pStatement.executeUpdate(); } catch (Exception e) {
		 * e.printStackTrace(); } finally { try { if (pStatement != null) {
		 * pStatement.close(); } if (connection != null) { connection.close(); } } catch
		 * (Exception e2) { e2.printStackTrace(); } }
		 */
	}

	public BDto contentView(String strID) {
		upHit(strID);
		String query = "SELECT bid, bname, btitle, bcontent, bdate, bhit FROM mvc_board WHERE bid = " + strID;
		return template.queryForObject(query, new BeanPropertyRowMapper<BDto>(BDto.class));
		/*
		 * BDto dto = null; Connection connection = null; PreparedStatement pStatement =
		 * null; ResultSet resultSet = null;
		 * 
		 * try { connection = dataSource.getConnection(); pStatement = connection
		 * .prepareStatement("SELECT bid, bname, btitle, bcontent, bdate, bhit FROM mvc_board WHERE bid = ?"
		 * ); pStatement.setInt(1, Integer.parseInt(strID)); resultSet =
		 * pStatement.executeQuery();
		 * 
		 * while (resultSet.next()) { dto = new BDto(resultSet.getInt("bid"),
		 * resultSet.getString("bname"), resultSet.getString("btitle"),
		 * resultSet.getString("bcontent"), resultSet.getTimestamp("bdate"),
		 * resultSet.getInt("bhit")); } } catch (Exception e) { e.printStackTrace(); }
		 * finally { try { if (resultSet != null) { resultSet.close(); } if (pStatement
		 * != null) { pStatement.close(); } if (connection != null) {
		 * connection.close(); } } catch (Exception e2) { e2.printStackTrace(); } }
		 * 
		 * return dto;
		 */
	}

	private void upHit(final String bId) {
		String query = "UPDATE mvc_board SET bhit = bhit + 1 WHERE bId = ?";
		template.update(query, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, Integer.parseInt(bId));
			}
		});

		/*
		 * Connection connection = null; PreparedStatement pStatement = null; try {
		 * connection = dataSource.getConnection(); pStatement = connection.
		 * prepareStatement("UPDATE mvc_board SET bhit = bhit + 1 WHERE bId = ?");
		 * pStatement.setInt(1, Integer.parseInt(bId));
		 * 
		 * int rn = pStatement.executeUpdate(); } catch (Exception e) {
		 * e.printStackTrace(); } finally { try { if (pStatement != null) {
		 * pStatement.close(); } if (connection != null) { connection.close(); } } catch
		 * (Exception e2) { e2.printStackTrace(); } }
		 */
	}

	public void modify(final String bId, final String bName, final String bTitle, final String bContent) {
		String query = "UPDATE mvc_board SET bname = ?, btitle = ?, bcontent = ? WHERE bId = ?";
		template.update(query, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, bName);
				ps.setString(2, bTitle);
				ps.setString(3, bContent);
				ps.setInt(4, Integer.parseInt(bId));
			}
		});

		/*
		 * Connection connection = null; PreparedStatement pStatement = null; try {
		 * connection = dataSource.getConnection(); pStatement = connection
		 * .prepareStatement("UPDATE mvc_board SET bname = ?, btitle = ?, bcontent = ? WHERE bId = ?"
		 * ); pStatement.setString(1, bName); pStatement.setString(2, bTitle);
		 * pStatement.setString(3, bContent); pStatement.setInt(4,
		 * Integer.parseInt(bId));
		 * 
		 * int rn = pStatement.executeUpdate(); } catch (Exception e) {
		 * e.printStackTrace(); } finally { try { if (pStatement != null) {
		 * pStatement.close(); } if (connection != null) { connection.close(); } } catch
		 * (Exception e2) { e2.printStackTrace(); } }
		 */
	}

	public void delete(final String bId) {
		String query = "DELETE FROM mvc_board WHERE bId = ?";
		template.update(query, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, Integer.parseInt(bId));
			}
		});
		/*
		 * Connection connection = null; PreparedStatement pStatement = null; try {
		 * connection = dataSource.getConnection(); pStatement =
		 * connection.prepareStatement("DELETE FROM mvc_board WHERE bId = ?");
		 * pStatement.setInt(1, Integer.parseInt(bId));
		 * 
		 * int rn = pStatement.executeUpdate(); } catch (Exception e) {
		 * e.printStackTrace(); } finally { try { if (pStatement != null) {
		 * pStatement.close(); } if (connection != null) { connection.close(); } } catch
		 * (Exception e2) { e2.printStackTrace(); } }
		 */
	}
}
