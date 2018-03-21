package com.pmp.sql;

import static com.pmp.constants.PMPConstants.DB_CLASS;
import static com.pmp.constants.PMPConstants.DB_PASSWORD;
import static com.pmp.constants.PMPConstants.DB_URL;
import static com.pmp.constants.PMPConstants.DB_USER;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
	private static Connection dbConnectionInstance;

	private DatabaseConnector() {
	}

	public static synchronized Connection getDBConnection() {
		try {
			if (dbConnectionInstance == null) {
				Class.forName(DB_CLASS);
				dbConnectionInstance = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			}
		} catch (ClassNotFoundException ex) {
			System.out.println("Error: unable to load driver class!");
			System.exit(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dbConnectionInstance;
	}

}
