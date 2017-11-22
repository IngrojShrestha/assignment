package com.gson.assignment;

import java.util.List;

public class Company {
	private String company;
	private String industry;
	private String subIndustry;
	private String sector;
	private String description;
	private String phone;
	private String fax;
	private String weburl;
	private List<KeyPeople> keyPeople;

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getSubIndustry() {
		return subIndustry;
	}

	public void setSubIndustry(String subIndustry) {
		this.subIndustry = subIndustry;
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getWeburl() {
		return weburl;
	}

	public void setWeburl(String weburl) {
		this.weburl = weburl;
	}

	public List<KeyPeople> getKeyPeople() {
		return keyPeople;
	}

	public void setKeyPeople(List<KeyPeople> keyPeople) {
		this.keyPeople = keyPeople;
	}

}
