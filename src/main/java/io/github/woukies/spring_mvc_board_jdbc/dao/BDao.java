package io.github.woukies.spring_mvc_board_jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import io.github.woukies.spring_mvc_board_jdbc.dto.BDto;

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

	public ArrayList<BDto> list() {
		ArrayList<BDto> dtos = new ArrayList<BDto>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;

		try {
			connection = dataSource.getConnection();
			pStatement = connection.prepareStatement(
					"SELECT bid, bname, btitle, bcontent, bdate, bhit FROM mvc_board ORDER BY bid DESC");
			resultSet = pStatement.executeQuery();

			while (resultSet.next()) {
				BDto dto = new BDto(resultSet.getInt("bid"), resultSet.getString("bname"),
						resultSet.getString("btitle"), resultSet.getString("bcontent"), resultSet.getTimestamp("bdate"),
						resultSet.getInt("bhit"));

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

	public void write(String bName, String bTitle, String bContent) {
		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = dataSource.getConnection();
			pStatement = connection.prepareStatement(
					"INSERT INTO mvc_board ( bid, bname, btitle, bcontent, bhit ) VALUES ( mvc_board_seq.NEXTVAL, ?, ?, ?, 0 )");
			pStatement.setString(1, bName);
			pStatement.setString(2, bTitle);
			pStatement.setString(3, bContent);

			int rn = pStatement.executeUpdate();
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

	public BDto contentView(String strID) {
		upHit(strID);

		BDto dto = null;
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;

		try {
			connection = dataSource.getConnection();
			pStatement = connection
					.prepareStatement("SELECT bid, bname, btitle, bcontent, bdate, bhit FROM mvc_board WHERE bid = ?");
			pStatement.setInt(1, Integer.parseInt(strID));
			resultSet = pStatement.executeQuery();

			while (resultSet.next()) {
				dto = new BDto(resultSet.getInt("bid"), resultSet.getString("bname"), resultSet.getString("btitle"),
						resultSet.getString("bcontent"), resultSet.getTimestamp("bdate"), resultSet.getInt("bhit"));
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

		return dto;
	}

	private void upHit(String bId) {
		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = dataSource.getConnection();
			pStatement = connection.prepareStatement("UPDATE mvc_board SET bhit = bhit + 1 WHERE bId = ?");
			pStatement.setInt(1, Integer.parseInt(bId));

			int rn = pStatement.executeUpdate();
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

	public void modify(String bId, String bName, String bTitle, String bContent) {
		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = dataSource.getConnection();
			pStatement = connection
					.prepareStatement("UPDATE mvc_board SET bname = ?, btitle = ?, bcontent = ? WHERE bId = ?");
			pStatement.setString(1, bName);
			pStatement.setString(2, bTitle);
			pStatement.setString(3, bContent);
			pStatement.setInt(4, Integer.parseInt(bId));

			int rn = pStatement.executeUpdate();
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
	
	public void delete(String bId) {
		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = dataSource.getConnection();
			pStatement = connection
					.prepareStatement("DELETE FROM mvc_board WHERE bId = ?");
			pStatement.setInt(1, Integer.parseInt(bId));

			int rn = pStatement.executeUpdate();
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
}
