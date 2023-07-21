package com.demo.pojo;

public class BusinessPojo {

	protected String businessCode;
	protected String businessName;
	
	public BusinessPojo(String businessCode, String businessName) {
		// TODO Auto-generated constructor stub
		this.businessCode = businessCode;
		this.businessName = businessName;
	}

	public String getbusinessCode() {
		return businessCode;
	}

	public void setbusinessCode(String businessCode) {
		this.businessCode = businessCode;
	}

	public String getbusinessName() {
		return businessName;
	}

	public void setbusinessName(String businessName) {
		this.businessName = businessName;
	}
	
	
}
