package com.employee.controller;

import java.io.File;
import java.util.List;
import java.util.Scanner;

import com.employee.constant.EmployeeType;
import com.employee.constant.WebResourceConstant;
import com.employee.dao.EmployeeDao;
import com.employee.dao.EmployeeDaoImpl;
import com.employee.entity.Manager;
import com.employee.entity.Scientist;
import com.google.gson.Gson;

public class EmployeeService {
	static Scanner in = new Scanner(System.in);

	private static EmployeeDao infoDao = new EmployeeDaoImpl();

	static Long empno;
	static String fname;
	static String lname;
	static double salary;
	static String employeeObj;
	static boolean success;
	static String emp;
	static Gson gson = new Gson();

	public static void action(Integer option) {
		switch (option) {
		case 0:
			break;
		case 1:
			// Add Employee
			System.out.println("Select Employee Type: manager or scientist ");
			String employee = in.next();

			System.out.println("Enter employee ID : ");
			empno = in.nextLong();

			boolean employeeExist = false;

			File f = new File("employee.txt");
			if (f.exists())
				employeeExist = infoDao.checkIfResourceAlreadyExist(empno);

			if (!employeeExist) {
				System.out.println("Enter employee first name");
				fname = in.next();

				System.out.println("Enter employee last name");
				lname = in.next();

				System.out.println("Enter Salary");
				salary = in.nextDouble();

				// add manager
				if (employee.equalsIgnoreCase("manager")) {
					System.out.println("Enter reward");
					int reward = in.nextInt();

					Manager manager = new Manager(empno, fname, lname, salary, EmployeeType.MANAGER.getName(), reward);

					employeeObj = gson.toJson(manager);

				} else { // add scientist
					System.out.println("Enter perks");
					int perks = in.nextInt();
					Scientist scientist = new Scientist(empno, fname, lname, salary, EmployeeType.SCIENTIST.getName(),
							perks);
					employeeObj = gson.toJson(scientist);
				}
				success = infoDao.add(employeeObj);

				if (success)
					System.out.println(WebResourceConstant.ADD_SUCCESS);
				else
					System.out.println(WebResourceConstant.ADD_FAILED);
			} else {
				System.out.println(WebResourceConstant.RECORD_ALREADY_EXIST);
			}
			displayMenu();
			break;
		case 2:
			// Update Employee
			System.out.println("Enter the Employee ID: ");
			empno = in.nextLong();
			emp = infoDao.search(empno);

			if (emp != null) {
				String[] tokens = emp.split(",");
				System.out.println(
						"----------------------------------------------------------------------------------------");
				System.out.println("Emp_ID\tFName\tLName\t\tSalary\t\tReward\t\tPerk\t\tType");
				System.out.println(
						"----------------------------------------------------------------------------------------");

				if (tokens[tokens.length - 1].equals("manager")) {

					System.out.println(tokens[0] + "\t" + tokens[1] + "\t" + tokens[2] + "\t\t" + tokens[3] + "\t"
							+ "\t" + tokens[4] + "\t\t" + "-" + "\t\t" + tokens[5]);

					System.out.println("Enter employee first name");
					fname = in.next();

					System.out.println("Enter employee last name");
					lname = in.next();

					System.out.println("Enter Salary");
					salary = in.nextInt();

					System.out.println("Enter reward");
					double reward = in.nextDouble();

					Manager manager = new Manager(empno, fname, lname, salary, EmployeeType.MANAGER.getName(), reward);

					employeeObj = gson.toJson(manager);

				} else {
					System.out.println(tokens[0] + "\t" + tokens[1] + "\t" + tokens[2] + "\t\t" + tokens[3] + "\t\t"
							+ "-" + "\t\t" + tokens[4] + "\t\t" + tokens[5]);

					System.out.println("Enter employee first name");
					fname = in.next();

					System.out.println("Enter employee last name");
					lname = in.next();

					System.out.println("Enter Salary");
					salary = in.nextDouble();

					System.out.println("Enter perks");
					int perks = in.nextInt();

					Scientist scientist = new Scientist(empno, fname, lname, salary, EmployeeType.SCIENTIST.getName(),
							perks);
					employeeObj = gson.toJson(scientist);

				}

				success = infoDao.update(empno, employeeObj);
				if (success)
					System.out.println(WebResourceConstant.UPDATE_SUCCESS);
				else
					System.out.println(WebResourceConstant.UPDATE_FAILED);

			} else {
				System.out.println(WebResourceConstant.RECORD_NOT_FOUND);
			}

			displayMenu();
			break;
		case 3:
			// Delete Employee
			System.out.println("Enter the Employee ID: ");
			empno = in.nextLong();
			emp = infoDao.search(empno);
			if (emp != null) {
				boolean success = infoDao.delete(empno);
				if (success)
					System.out.println(WebResourceConstant.DELETE_SUCCESS);
				else
					System.out.println(WebResourceConstant.DELETE_FAILED);
			} else {
				System.out.println(WebResourceConstant.RECORD_NOT_FOUND);
			}

			displayMenu();
			break;
		case 4:
			// View All Employee
			List<String> employeeList = infoDao.displayAll();
			if (employeeList.size() > 0) {
				System.out.println(
						"----------------------------------------------------------------------------------------");
				System.out.println("Emp_ID\tFName\tLName\t\tSalary\t\tReward\t\tPerk\t\tType");
				System.out.println(
						"----------------------------------------------------------------------------------------");

				for (String emp : employeeList) {
					String[] tokens = emp.split(",");
					if (tokens[tokens.length - 1].equals("manager")) {
						System.out.println(tokens[0] + "\t" + tokens[1] + "\t" + tokens[2] + "\t\t" + tokens[3] + "\t"
								+ "\t" + tokens[4] + "\t\t" + "-" + "\t\t" + tokens[5]);

					} else {
						System.out.println(tokens[0] + "\t" + tokens[1] + "\t" + tokens[2] + "\t\t" + tokens[3] + "\t\t"
								+ "-" + "\t\t" + tokens[4] + "\t\t" + tokens[5]);
					}

				}
			} else {
				System.out.println(WebResourceConstant.RECORD_NOT_FOUND);
			}
			displayMenu();
			break;
		case 5:
			// Search Employee
			System.out.println("Enter the Employee ID: ");
			empno = in.nextLong();
			emp = infoDao.search(empno);

			if (emp != null) {
				String[] tokens = emp.split(",");

				System.out.println(
						"----------------------------------------------------------------------------------------");
				System.out.println("Emp_ID\tFName\tLName\t\tSalary\t\tReward\t\tPerk\t\tType");
				System.out.println(
						"----------------------------------------------------------------------------------------");

				if (tokens[tokens.length - 1].equals("manager")) {
					System.out.println(tokens[0] + "\t" + tokens[1] + "\t" + tokens[2] + "\t\t" + tokens[3] + "\t"
							+ "\t" + tokens[4] + "\t\t" + "-" + "\t\t" + tokens[5]);

				} else {
					System.out.println(tokens[0] + "\t" + tokens[1] + "\t" + tokens[2] + "\t\t" + tokens[3] + "\t\t"
							+ "-" + "\t\t" + tokens[4] + "\t\t" + tokens[5]);
				}
			} else {
				System.out.println(WebResourceConstant.RECORD_NOT_FOUND);
			}
			displayMenu();
			break;
		default:
			System.out.println("Please enter appropriate action");
			break;
		}
	}

	public static void displayMenu() {
		System.out.println();
		System.out.println("========== Employee Record Keeping System =========");
		System.out.println("0. Exit");
		System.out.println("1. Add Employee");
		System.out.println("2. Update Employee");
		System.out.println("3. Delete Employee");
		System.out.println("4. Display all Employee");
		System.out.println("5. Search Employee");

		System.out.println("Please select the menu (0 - 5) : ");

	}

}
