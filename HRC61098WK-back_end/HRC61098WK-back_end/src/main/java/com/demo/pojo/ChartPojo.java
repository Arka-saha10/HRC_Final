//CHART POJO
package com.demo.pojo;

public class ChartPojo {
    protected int id;  
    protected String business_name;
	protected String business_code;	
	protected int cust_count;
	protected double total_amount;
	protected String invoice_currency;
	protected int count_currency;
	
	public ChartPojo(int id, String invoice_currency, int count_currency) {
		super();
		this.id = id;
		this.invoice_currency = invoice_currency;
		this.count_currency = count_currency;
	}
	
	public ChartPojo(int id, String business_name,String business_code, int cust_count, double total_amount) {
		super();
		this.id = id;
		this.business_name = business_name;
		this.business_code = business_code;
		this.cust_count = cust_count;
		this.total_amount = total_amount;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBusiness_code() {
		return business_code;
	}
	public void setBusiness_code(String business_code) {
		this.business_code = business_code;
	}
	public String getBusiness_name() {
		return business_name;
	}
	public void setBusiness_name(String business_name) {
		this.business_name = business_name;
	}
	public int getCust_count() {
		return cust_count;
	}
	public void setCust_count(int cust_count) {
		this.cust_count = cust_count;
	}
	public double getTotal_amount() {
		return total_amount;
	}
	public void setTotal_amount(double total_amount) {
		this.total_amount = total_amount;
	}
	public int getCount_currency() {
		return count_currency;
	}
	public void setCount_currency(int count_currency) {
		this.count_currency = count_currency;
	}

		
}