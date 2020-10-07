/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Scanner;

/**
 *
 * @author Phucdz
 */
public class Employee {
	enum gender {
		man,woman,other;
	}
	private String ID;
	private String Name;
	private int Gender;
	private int Age;
	private String Address;

	public Employee() {
	}

	public Employee(String ID, String Name, int Gender, int Age, String Address) {
		this.ID = ID;
		this.Name = Name;
		this.Gender = Gender;
		this.Age = Age;
		this.Address = Address;
	}

	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	public String getName() {
		return Name;
	}

	public void setName(String Name) {
		this.Name = Name;
	}

	public int getGender() {
		return Gender;
	}

	public void setGender(int Gender) {
		this.Gender = Gender;
	}

	public int getAge() {
		return Age;
	}

	public void setAge(int Age) {
		this.Age = Age;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String Address) {
		this.Address = Address;
	}
	public void InputFomation() throws Exception {
		Scanner input = new Scanner(System.in);
		System.out.println("Input ID:");
		ID = input.next();
		System.out.println("Input Name:");
		Name = input.next();
		System.out.println("Input Gender:");
		Gender = input.nextInt();
		System.out.println("Input Age:");
		Age = input.nextInt();
		System.out.println("Input Address:");
		Address = input.nextLine();
	}
	public void ShowInfo() throws Exception{
		System.out.println("ID: " + ID);
		System.out.println("Name: " + Name);
		System.out.println("Gender: " + Gender);
		System.out.println("Age: " + Age);
		System.out.println("Address: " + Address);
	}
	
}
