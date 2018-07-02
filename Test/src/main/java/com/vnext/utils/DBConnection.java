package com.vnext.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public static Connection getConnection(){
        String dbURL = "jdbc:sqlserver://localhost;databaseName=dbNhanVien;user=viethoang;password=hoang123";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(dbURL);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
