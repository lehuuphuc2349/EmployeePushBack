/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Employee;

/**
 *
 * @author Phucdz
 */
public class Manager {
	public static List<Employee> getAllEmployee() throws Exception{
		List<Employee> employeeList = new ArrayList<Employee>();
		Connection connection = controller.ConnectDatabaseMySQL.connectMySQLSever();
		String state = "Select * from Employee";
		Statement statement = connection.createStatement();
		ResultSet result = statement.executeQuery(state);
		while(result.next()) {
			employeeList.add(new Employee(result.getString(1) + result.getString(2) + result.getInt(3) + result.getInt(4) + result.getString(5)));
		}
		result.close();
		statement.close();
		connection.close();
		return employeeList;
	}
	public static Employee getEmployeeByID(String ID) throws Exception {
		Employee employee = null;
		Connection connection = controller.ConnectDatabaseMySQL.connectMySQLSever();
		String state = "Select * from Employee Where ID=?";
		PreparedStatement preparedStatement = connection.prepareStatement(state);
		preparedStatement.setString(1, ID);
		ResultSet result = preparedStatement.executeQuery();
		while(result.next()) {
			employee = new Employee(result.getString("ID") + result.getString("Name") + result.getInt("Gender") + result.getInt("Age") + result.getString("Address"));
		}
		result.close();
		preparedStatement.close();
		connection.close();
		return employee;
	}
	public static int InsertEmployee(Employee employee) throws Exception {
		if(getEmployeeByID(employee.getID()) == null) {
			Connection connection = controller.ConnectDatabaseMySQL.connectMySQLSever();
			String state = "Insert into Employee Values(?,?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(state);
			preparedStatement.setString(1, employee.getID());
			preparedStatement.setString(2, employee.getName());
			preparedStatement.setInt(3, employee.getGender());
			preparedStatement.setInt(4, employee.getAge());
			preparedStatement.setString(5, employee.getAddress());
			return preparedStatement.executeUpdate();
		}
		return 0;
	}
}
