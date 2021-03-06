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

		String filename = "1-0-994.txt";

		String outputFileName = "output.txt";

		List<Company> companyList = getData(filename);

		storeDescription(companyList, outputFileName);

		displayCompany(companyList);

		displayFaxInformation(companyList);

		displayWebUrl(companyList);

	}

	public static List<Company> getData(String filename) {
		List<Company> companyList = new ArrayList<>();

		Gson gson = new Gson();

		File f = new File(filename);

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

		return companyList;
	}

	public static void storeDescription(List<Company> companyList, String outputFileName) {
		int i = 0;
		FileWriter file;
		try {
			file = new FileWriter(outputFileName);
			for (Company company : companyList) {

				file.write(company.getCompany() + ":" + company.getDescription());
				if (i++ != companyList.size() - 1) {
					file.write("\n");
				}
			}
			file.close();
			System.out.println("Successfully stored company description.");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Failed to store information.");
		}

	}

	public static void displayCompany(List<Company> companyList) {
		System.out.println("============= Company with keyPeople > 0 =============");
		for (Company company : companyList) {
			if (company.getKeyPeople().size() > 0) {
				System.out.println("company : " + company.getCompany());
			}
		}
	}

	public static void displayFaxInformation(List<Company> companyList) {
		System.out.println("============= Fax =============");
		for (Company company : companyList) {

			if (!company.getFax().equals("-")) {
				String fax = company.getFax().replaceAll("-", "");
				Long faxNo = Long.parseLong(fax);
				System.out.println("fax : " + faxNo);

			}
		}
	}

	public static void displayWebUrl(List<Company> companyList) {

		System.out.println("============= webUrl =============");

		for (Company company : companyList) {

			if (company.getWeburl() != null) {
				Pattern p = Pattern.compile("(www[0-9]?\\.)?(.*)\\.(.*)");

				Matcher m = p.matcher(company.getWeburl());
				if (m.matches()) {
					String url = m.group(2) + "." + m.group(3);

					// Remove everything after /
					Pattern p2 = Pattern.compile("/.*");
					url = p2.matcher(url).replaceAll("");

					// Remove sub domain
					if (count(url) > 1) {
						String regex = "^(\\w+\\.)";
						url = url.replaceAll(regex, "");
					}
					System.out.println("weburl : " + url);
				}

			}

		}
	}

	public static int count(String data) {
		int charCount = 0;
		for (int i = 0; i < data.length(); i++) {
			if (data.charAt(i) == '.') {
				charCount++;
			}
		}
		return charCount;
	}

}
