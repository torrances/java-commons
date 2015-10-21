package com.trimc.blogger.commons.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.trimc.blogger.commons.LogManager;

/**
 * 	Purpose
 * 	Prepared Statement Utils
 *
 */
public class PreparedStatementUtils {

	public static LogManager logger = new LogManager(PreparedStatementUtils.class);

	public static void handle(PreparedStatement insert, Connection con) {
		try {

			if (null != insert) insert.close();
			con.setAutoCommit(true);

		} catch (SQLException e) {
			e.printStackTrace();
			logger.error("Failed to Gracefully Exit Bulk Insert", e);
		}
	}

	public static void handle(SQLException e, Connection con) {
		logger.error("PreparedStatement insert Failed", e);
		if (null == con) return;

		try {

			logger.warn("Transaction is being rolled back");
			con.rollback();

		} catch (SQLException inner) {
			inner.printStackTrace();
			logger.error("Failed to Rollback Transaction", inner);
		}
	}
}
