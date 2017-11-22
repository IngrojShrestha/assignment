package com.gson.assignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.gson.Gson;

public class JsonToJava {
	public static void main(String[] args) throws IOException {
		List<Company> companyList = new ArrayList<>();

		Gson gson = new Gson();

		File f = new File("1-0-994.txt");

		Scanner in;
		try {
			in = new Scanner(f);
			while (in.hasNextLine()) {

				String data = in.nextLine();
				String data_formatted = data.substring(data.indexOf(",") + 1);
				Company company = gson.fromJson(data_formatted, Company.class);
				companyList.add(company);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		FileWriter file = new FileWriter("output.txt");
		int i = 0;
		for (Company company : companyList) {

			file.write(company.getCompany() + ":" + company.getDescription());
			if (i++ != companyList.size() - 1) {
				file.write("\n");
			}

			if (company.getKeyPeople().size() > 0) {
				System.out.println("company : " + company.getCompany());
				if (!company.getFax().equals("-")) {
					String fax = company.getFax().replaceAll("-", "");
					Long faxNo = Long.valueOf(fax);
					System.out.println("fax : " + faxNo);

				}

				if (company.getWeburl() != null) {
					Pattern p = Pattern.compile("www.(.*)\\.(.*)");
					Matcher m = p.matcher(company.getWeburl());
					if (m.matches()) {
						System.out.println("weburl : " + m.group(1) + "." + m.group(2));
					}

				}

				System.out.println();

			}

		}
		file.close();

	}
}
