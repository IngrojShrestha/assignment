package com.employee.entity;

public class Employee {

	private Long emp_no;
	private String firstName;
	private String lastName;
	private double salary;
	private String type;

	public Employee(Long emp_no, String firstName, String lastName, double salary, String type) {
		this.emp_no = emp_no;
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
		this.type = type;
	}

	public Long getEmp_no() {
		return emp_no;
	}

	public void setEmp_no(Long emp_no) {
		this.emp_no = emp_no;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
