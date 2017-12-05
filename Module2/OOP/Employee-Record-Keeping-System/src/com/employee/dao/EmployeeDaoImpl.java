package com.employee.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.employee.entity.Manager;
import com.employee.entity.Scientist;
import com.google.gson.Gson;

public class EmployeeDaoImpl implements EmployeeDao {
	Scanner in = new Scanner(System.in);
	private BufferedReader br;
	private BufferedWriter bw;
	private Gson gson = new Gson();

	@Override
	public boolean add(String jsonObject) {

		try {
			bw = new BufferedWriter(new FileWriter("employee.txt", true));
			if (jsonObject.contains("manager")) {
				Manager employee = gson.fromJson(jsonObject, Manager.class);

				bw.write(employee.getEmp_no().toString() + "," + employee.getFirstName() + "," + employee.getLastName()
						+ "," + employee.getSalary() + "," + employee.getReward() + "," + employee.getType());
			} else {
				Scientist employee = gson.fromJson(jsonObject, Scientist.class);
				bw.write(employee.getEmp_no() + "," + employee.getFirstName() + "," + employee.getLastName() + ","
						+ employee.getSalary() + "," + employee.getPerks() + "," + employee.getType());
			}

			bw.flush();
			bw.newLine();
			bw.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public List<String> displayAll() {

		List<String> employeeList = new ArrayList<>();
		try {
			br = new BufferedReader(new FileReader("employee.txt"));

			String record;
			while ((record = br.readLine()) != null) {

				employeeList.add(record);
			}

			br.close();
			return employeeList;

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public boolean delete(Long empID) {

		String record;
		File temp = new File("employee_temp.txt");
		File db = new File("employee.txt");

		try {
			br = new BufferedReader(new FileReader(db));
			bw = new BufferedWriter(new FileWriter(temp));
			while ((record = br.readLine()) != null) {
				String[] tokens = record.split(",");
				if (Long.valueOf(tokens[0]).equals(empID)) {
					continue;
				}
				bw.write(record);
				bw.flush();
				bw.newLine();
			}

			br.close();
			bw.close();
			db.delete();
			temp.renameTo(db);
			return true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public String search(Long empID) {
		try {
			br = new BufferedReader(new FileReader("employee.txt"));

			String record;
			while ((record = br.readLine()) != null) {
				String[] tokens = record.split(",");
				if (Long.valueOf(tokens[0]).equals(empID)) {
					return record;
				}
			}
			br.close();
			return null;

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public boolean update(Long empID, String jsonObject) {

		File db = new File("employee.txt");
		File temp_db = new File("employee_temp.txt");

		try {
			br = new BufferedReader(new FileReader(db));
			bw = new BufferedWriter(new FileWriter(temp_db));

			String record;

			while ((record = br.readLine()) != null) {
				String[] tokens = record.split(",");

				if (Long.valueOf(tokens[0]).equals(empID)) {
					if (jsonObject.contains("manager")) {
						Manager employee = gson.fromJson(jsonObject, Manager.class);

						bw.write(employee.getEmp_no().toString() + "," + employee.getFirstName() + ","
								+ employee.getLastName() + "," + employee.getSalary() + "," + employee.getReward() + ","
								+ employee.getType());
					} else {
						Scientist employee = gson.fromJson(jsonObject, Scientist.class);
						bw.write(employee.getEmp_no() + "," + employee.getFirstName() + "," + employee.getLastName()
								+ "," + employee.getSalary() + "," + employee.getPerks() + "," + employee.getType());
					}
				} else
					bw.write(record);
				bw.flush();
				bw.newLine();
			}
			bw.close();
			br.close();
			db.delete();
			temp_db.renameTo(db);
			return true;

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean checkIfResourceAlreadyExist(Long empID) {
		try {
			br = new BufferedReader(new FileReader("employee.txt"));

			String record;
			while ((record = br.readLine()) != null) {
				String[] tokens = record.split(",");
				if (Long.valueOf(tokens[0]).equals(empID)) {
					return true;
				}
			}
			br.close();
			return false;

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
}
