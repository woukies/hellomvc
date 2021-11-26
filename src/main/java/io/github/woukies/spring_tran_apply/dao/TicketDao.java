package io.github.woukies.spring_tran_apply.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import io.github.woukies.spring_tran_apply.dto.TicketDto;

public class TicketDao {
	JdbcTemplate template;
	PlatformTransactionManager transactionManager;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public void setTransactionManager(PlatformTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}

	public void buyTicket(final TicketDto dto) {
		TransactionDefinition definition = new DefaultTransactionDefinition();
		TransactionStatus status = transactionManager.getTransaction(definition);

		try {
			template.update(new PreparedStatementCreator() {

				@Override
				public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
					PreparedStatement preparedStatement = con
							.prepareStatement("INSERT INTO card (consumerid, amount) values (?, ?)");
					preparedStatement.setString(1, dto.getConsumerId());
					preparedStatement.setInt(2, dto.getAmount());

					return preparedStatement;
				}
			});

			template.update(new PreparedStatementCreator() {

				@Override
				public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
					PreparedStatement preparedStatement = con
							.prepareStatement("INSERT INTO ticket (consumerid, countnum) values (?, ?)");
					preparedStatement.setString(1, dto.getConsumerId());
					preparedStatement.setInt(2, dto.getAmount());

					return preparedStatement;
				}
			});
			
			transactionManager.commit(status);
		} catch (Exception e) {
			e.printStackTrace();
			transactionManager.rollback(status);
		}
	}
}
