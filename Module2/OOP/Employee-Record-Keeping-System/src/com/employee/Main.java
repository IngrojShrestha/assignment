package com.employee;

import java.util.Scanner;

import com.employee.controller.EmployeeService;

public class Main {

	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		// Display the menu
		EmployeeService.displayMenu();
		Integer option = -1;
		while (option != 0) {

			// menu option
			option = in.nextInt();
			EmployeeService.action(option);
		}

	}
}