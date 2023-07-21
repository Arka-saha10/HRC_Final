package com.demo.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.demo.DbConnection.DatabaseConnection;
import com.demo.pojo.BusinessPojo;
import com.demo.pojo.CustomerPojo;

public class CustomerDAO {
	
	private static final String INSERT_SQL = "INSERT INTO customer (cust_number, name_customer) VALUES (?, ?)";
	private static final String DELETE_SQL = "DELETE FROM customer where cust_number = ?";
	private static final String UPDATE_SQL = "UPDATE business SET name_customer = ? WHERE cust_number = ?";
    private static final String SELECT_ALL = "SELECT * FROM customer";
    private static final String SELECT_BY_ID = "SELECT * FROM customer WHERE cust_number = ?";
			
	public CustomerDAO() {
		
	}
		
	
//	public List<CustomerPojo> listAllCustomer() throws SQLException {
//	List<CustomerPojo> listCustomer = new ArrayList<>();
//		
//	   	//TO - DO ---> Create Sql injection
//	   	String sql = "SELECT * FROM customer";
//	   
//	   	connect();
//	     
//	   	Statement statement = jdbcConnection.createStatement();
//	   	ResultSet resultSet = statement.executeQuery(sql);
//	   
//	   	while (resultSet.next()) {
//	   		long custNumber = resultSet.getLong("cust_number");
//	   		String nameCustomer = resultSet.getString("name_customer");
//	       
//	   		//Here we're declaring a table of name myBusiness of BusinessPojo class
//	   		CustomerPojo myCustomer = new CustomerPojo(custNumber, nameCustomer);
//	   		listCustomer.add(myCustomer);
//	  	}
//			
//	   	resultSet.close();
//	   	statement.close();
//		     
//	   	disconnect();
//		    
//	   	return listCustomer;    	
//	}
	
	//ADD method signature
	public void addCustomer(CustomerPojo customer) throws SQLException {
		System.out.println(INSERT_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection con = DatabaseConnection.createConnect();
				PreparedStatement st = con.prepareStatement(INSERT_SQL)) {
			
			st.setLong(1, customer.getcustNumber());
		    st.setString(2, customer.getnameCustomer());
			
			System.out.println(st);
			st.executeUpdate();
			con.close();
		} 	
		catch (SQLException e) {
			printSQLException(e);
		}
	}

		
	//EDIT method signature
	public boolean editCustomer(CustomerPojo customer) throws SQLException {
		boolean rowUpdated = false;
		try (Connection con = DatabaseConnection.createConnect();
				PreparedStatement st = con.prepareStatement(UPDATE_SQL);) {
			st.setString(1, customer.getnameCustomer());
		    st.setLong(2, customer.getcustNumber());
			rowUpdated = st.executeUpdate() > 0;
			con.close();
		}
		catch (SQLException e) {
			printSQLException(e);
		}
		return rowUpdated;
	}
		
	//DELETE method signature
	public boolean deleteCustomer(CustomerPojo customer) throws SQLException {
		boolean rowDeleted = false;
		try (Connection con = DatabaseConnection.createConnect();
				PreparedStatement st = con.prepareStatement(DELETE_SQL);) {
			st.setLong(1, customer.getcustNumber());
			rowDeleted = st.executeUpdate() > 0;
			con.close();
		}
		catch (SQLException e) {
			printSQLException(e);
		}
		return rowDeleted;
	}
	
//	//FETCH API
//	public CustomerPojo getCustomer(long custNumber) throws SQLException {
//		CustomerPojo customer = null;
//	    String sql = "SELECT * FROM customer WHERE cust_number = ?";
//		         
//	    connect();
//		         
//	    PreparedStatement statement = jdbcConnection.prepareStatement(sql);
//	    statement.setLong(1, custNumber);
//		         
//	    ResultSet resultSet = statement.executeQuery();
//		         
//	    if (resultSet.next()) {
//	    	String nameCustomer = resultSet.getString("name_customer");
//		             
//	    	customer = new CustomerPojo(custNumber, nameCustomer);
//	    }
//		         
//	    resultSet.close();
//	    statement.close();
//		         
//	    return customer;
//	}
		
	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}

}
