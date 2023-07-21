package com.demo.pojo;

public class CustomerPojo {
	protected long custNumber;
	protected String nameCustomer;
	
	public CustomerPojo(long custNumber, String nameCustomer) {
		// TODO Auto-generated constructor stub
		this.custNumber = custNumber;
		this.nameCustomer = nameCustomer;
	}

	public long getcustNumber() {
		return custNumber;
	}

	public void setcustNumber(long custNumber) {
		this.custNumber = custNumber;
	}

	public String getnameCustomer() {
		return nameCustomer;
	}

	public void setnameCustomer(String nameCustomer) {
		this.nameCustomer = nameCustomer;
	}
	
	
}
