/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.Employee;

/**
 *
 * @author Phucdz
 */
public class EmployeeManagement {

	enum Gender {
		Man, Woman, Other;
	}

	static void ShowMenu() {
		System.out.println("1. ADD NEW EMPLOYEE");
		System.out.println("2. SEARCH BY EMPLOYEE ID");
		System.out.println("3. UPDATE EMPLOYEE");
		System.out.println("4. DELETE EMPLOYEE");
		System.out.println("5. SHOW ALL EMPLOYEE");
		System.out.println("6. EXIT PROGRAM");
	}

	public static void InsertEmployee() throws Exception {
		Employee employee = new Employee();
		employee.InputFomation();
		Scanner input = new Scanner(System.in);
		do {
			if (controller.Manager.getEmployeeByID(employee.getID()) != null) {
				System.out.println("ID EXIST, PLEASE INPUT AGAIN");
				employee.setID(input.nextLine());
			} else {
				break;
			}
		} while (true);
		int result = controller.Manager.InsertEmployee(employee);
		if (result == 0) {
			System.out.println("ID EXIST");
		} else {
			System.out.println("Success..!!");
		}
	}


	public static void DeleteEmployee() throws Exception {
		Employee employee = new Employee();
		Scanner input = new Scanner(System.in);
		employee.InputID();
		do {
			if (controller.Manager.getEmployeeByID(employee.getID()) == null) {
				System.out.println("Input Again");
				employee.setID(input.nextLine());
			} else {
				break;
			}
		} while (true);
		int result = controller.Manager.DeleteEmployee(employee);
		if (result == 0) {
			System.out.println("ID Not EXIST");
		} else {
			System.out.println("Success..");
		}
	}

	public static void ConvertGender(int gender) throws Exception {
		switch (gender) {
			case 1:
				System.out.println(Gender.Man);
				break;
			case 2:
				System.out.println(Gender.Woman);
				break;
			case 3:
				System.out.println(Gender.Other);
				break;
			default:
				System.out.println(Gender.Other);
				break;
		}
	}

	public static void SearchEmployee() throws Exception {	
		Employee employee = new Employee();
		employee.InputID();
		Employee result = controller.Manager.getEmployeeByID(employee.getID());
		result.toString();
	}

	public static void ShowEmployee() throws Exception {
		List<Employee> listEmployees = controller.Manager.getAllEmployee();
		for (int i = 0; i < listEmployees.size(); i++) {
			System.out.println("Employee: " + (i+1));
			System.out.println("ID: " + listEmployees.get(i).getID());
			System.out.println("Name: " + listEmployees.get(i).getName());
			ConvertGender(listEmployees.get(i).getGender());
			System.out.println("Age: " + listEmployees.get(i).getAge());
			System.out.println("Address: " + listEmployees.get(i).getAddress());
			System.out.println("");
		}
	}

	public static void main(String[] args) throws Exception {
		String choose = null;
		Scanner input = new Scanner(System.in);
		ShowMenu();
		while (true) {
			choose = input.nextLine();
			switch (choose) {
				case "1":
					InsertEmployee();
					break;
				case "2":
					SearchEmployee();
					break;
				case "4":
					DeleteEmployee();
					break;
				case "5":
					ShowEmployee();
					break;
				case "6":
					System.out.println("Thanks!!");
					System.exit(0);
					break;
				default:
					System.out.println("Error");
					break;
			}
			ShowMenu();
		}

	}
}
