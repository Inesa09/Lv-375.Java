package com.softserve.edu.items.db;

import java.sql.Driver;
import java.sql.SQLException;

public final class DataSourceRepository {
	private final static String FAILED_JDBC_DRIVER = "Failed to Create JDBC Driver";

	private DataSourceRepository() {
	}

	public static DataSource getDefault() {
		return getMySqlLocalHost();
	}

	public static DataSource getMySqlLocalHost() {
		Driver sqlDriver;
		try {
			sqlDriver = new com.mysql.jdbc.Driver();
			//sqlDriver = new com.mysql.cj.jdbc.Driver();
		} catch (SQLException e) {
			// TODO Develop Custom Exceptions
			throw new RuntimeException(FAILED_JDBC_DRIVER);
		}
		return new DataSource(sqlDriver,
				"jdbc:mysql://localhost:3306/lv375?useSSL=false",
				System.getenv().get("MY_SQL_LOGIN"),
				System.getenv().get("MY_SQL_PASSWORD"));
	}

	public static DataSource getSybaseLocalHost() {
		return new DataSource(new net.sourceforge.jtds.jdbc.Driver(),
				"jdbc:jtds:sqlserver://CLASS02/lv326;instance=SQLEXPRESS;",
				"login", "password");
	}

}