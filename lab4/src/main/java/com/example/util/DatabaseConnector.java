package com.example.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseConnector {
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DATABASE_URL =
            "jdbc:mysql://localhost:3306/julie_fliorko_db?useUnicode=true&serverTimezone=UTC&useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "julie";

    private static Connection DATABASE_CONNECTION;

    public DatabaseConnector() {
    }

    public static Connection getConnection() {
        try {
            Class.forName(JDBC_DRIVER);
            if (DATABASE_CONNECTION == null || DATABASE_CONNECTION.isClosed()) {
                DATABASE_CONNECTION = DriverManager.getConnection(
                        DATABASE_URL,
                        USERNAME,
                        PASSWORD
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return DATABASE_CONNECTION;
    }

}
