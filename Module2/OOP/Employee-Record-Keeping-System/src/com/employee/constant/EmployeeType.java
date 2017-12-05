package com.employee.constant;

public enum EmployeeType {
	MANAGER("manager"), SCIENTIST("scientist");
	private String type;

	EmployeeType(String type) {
		this.type = type;
	}

	public String getName() {
		return type;
	}

}
