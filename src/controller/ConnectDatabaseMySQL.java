/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Phucdz
 */
public class ConnectDatabaseMySQL {
	public static Connection connectMySQLSever() throws Exception {
		String DB_URL = "jdbc:mysql://localhost:3306/learnMySQL";
		String username = "root";
		String password = "root";
		Connection connection = DriverManager.getConnection(DB_URL, username, password);
		return connection;
	}
}
