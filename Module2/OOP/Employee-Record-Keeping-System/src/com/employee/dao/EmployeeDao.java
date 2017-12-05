package com.employee.dao;

import java.util.List;

public interface EmployeeDao {
	public boolean add(String jsonObject);

	public List<String> displayAll();

	public boolean delete(Long empID);

	public String search(Long empID);

	public boolean update(Long empID, String employee);

	public boolean checkIfResourceAlreadyExist(Long empID);

}
