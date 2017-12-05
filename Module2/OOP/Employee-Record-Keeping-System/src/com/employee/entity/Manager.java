package com.employee.entity;

public class Manager extends Employee {
	double reward;

	public Manager(Long emp_no, String firstName, String lastName, double salary, String type, double reward) {
		super(emp_no, firstName, lastName, salary, type);
		this.reward = reward;
	}

	public double getReward() {
		return reward;
	}

	public void setReward(double reward) {
		this.reward = reward;
	}

}
