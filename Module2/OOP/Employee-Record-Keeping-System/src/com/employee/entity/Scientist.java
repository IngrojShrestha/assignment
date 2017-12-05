package com.employee.entity;

public class Scientist extends Employee {
	int perks;

	public Scientist(Long emp_no, String firstName, String lastName, double salary, String type, int perks) {
		super(emp_no, firstName, lastName, salary, type);
		this.perks = perks;
	}

	public int getPerks() {
		return perks;
	}

	public void setPerks(int perks) {
		this.perks = perks;
	}

}
