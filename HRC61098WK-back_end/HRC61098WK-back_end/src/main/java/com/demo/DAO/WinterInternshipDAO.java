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

import com.demo.pojo.WinterInternshipPojo;
public class WinterInternshipDAO {
	
	private static final String INSERT_SQL = "INSERT INTO winter_internship (sl_no, business_code, cust_number, clear_date, buisness_year, doc_id, posting_date, document_create_date, document_create_date1, due_in_date, invoice_currency, document_type, posting_id,	area_business, total_open_amount, baseline_create_date, cust_payment_terms, invoice_id, isOpen, aging_bucket, is_deleted) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String DELETE_SQL = "DELETE FROM winter_internship where sl_no = ?";
	private static final String UPDATE_SQL = "UPDATE winter_internship SET business_name = ?,cust_number WHERE sl_no = ?";
    
	
	private static final String SELECT_ALL = "SELECT * FROM winter_internship LIMIT ?,?";
    private static final String SELECT_BY_customerID = "SELECT * FROM winter_internship WHERE cust_number = ?";
    private static final String SEARCH_ADVANCE = "SELECT * FROM winter_internship WHERE buisness_year = ?, cust_number = ?, invoice_id = ?, doc_id = ?";
    private static final String COUNT_QUERY = "SELECT count(*) FROM winter_internship" ;
    
	public WinterInternshipDAO() {}
	
	
	//FETCH API method
	public List<WinterInternshipPojo> listAllWinterInternship(int start,int pageSize) throws SQLException {
	    List<WinterInternshipPojo> listWinterInternship = new ArrayList<>();
		// try-with-resource statement will auto close the connection.
		try (Connection con = DatabaseConnection.createConnect(); PreparedStatement st = con.prepareStatement(SELECT_ALL);) {
			
				System.out.println(st);
				st.setInt(1,start);
				st.setInt(2, pageSize);
				ResultSet resultSet = st.executeQuery();
				
			
				while (resultSet.next()) {
			    	int slNo = resultSet.getInt("sl_no");
			    	int id = resultSet.getInt("sl_no");
			    	String businessCode = resultSet.getString("business_code");
			    	long custNumber = resultSet.getLong("cust_number");
			    	String clearDate = resultSet.getString("clear_date");
			    	int buisnessYear = resultSet.getInt("buisness_year");
			    	long docId = resultSet.getLong("doc_id");
			    	String postingDate = resultSet.getString("posting_date");
			    	String documentCreateDate = resultSet.getString("document_create_date");
			    	String documentCreateDate1 = resultSet.getString("document_create_date1");
			    	String dueInDate = resultSet.getString("due_in_date");
			    	String invoiceCurrency = resultSet.getString("invoice_currency");
			    	String documentType = resultSet.getString("document_type");
			    	int postingId = resultSet.getInt("posting_id");
			    	String areaBusiness = resultSet.getString("area_business");
			    	double totalOpenAmount = resultSet.getDouble("total_open_amount");
			    	String baselineCreateDate = resultSet.getString("baseline_create_date");
			    	String custPaymentTerms = resultSet.getString("cust_payment_terms");
			    	long invoiceId = resultSet.getLong("invoice_id");
			    	int isOpen = resultSet.getInt("isOpen");
			    	String agingBucket = resultSet.getString("aging_bucket");
			    	int isDeleted = resultSet.getInt("is_deleted");
			    	agingBucket = (agingBucket==null?"NA":agingBucket);
			    	//Here we're declaring a table of name myBusiness of BusinessPojo class
			    	WinterInternshipPojo myWinterInternship = new WinterInternshipPojo(slNo, businessCode, custNumber, clearDate, buisnessYear, docId, postingDate,
			    			documentCreateDate, documentCreateDate1, dueInDate, invoiceCurrency, documentType, postingId,
			    			areaBusiness, totalOpenAmount, baselineCreateDate, custPaymentTerms, invoiceId, isOpen, agingBucket,
			    			isDeleted);
			    	myWinterInternship.setId(id);
			    	listWinterInternship.add(myWinterInternship);
			    }
				
				
			System.out.println(st);
			//st.executeUpdate();
			resultSet.close();
			con.close();
		} 	
		catch (SQLException e) {
			printSQLException(e);
		}
		return listWinterInternship;//returning the rows from the database
	}
	
	//ADD API method
	public boolean addWinterInternship(String queryAdd) throws SQLException {
		
		boolean rowAdded = false;
		// try-with-resource statement will auto close the connection.
		try (Connection con = DatabaseConnection.createConnect();
				PreparedStatement st = con.prepareStatement(queryAdd);) {
			
			rowAdded = st.executeUpdate() > 0;
			con.close();
		} 	
		catch (SQLException e) {
			printSQLException(e);
		}
		//returning true if added successfully else false
		return rowAdded;
	}
	
	//EDIT API method
	public boolean editWinterInternship(String query) throws SQLException {
		boolean rowUpdated = false;
		try (Connection con = DatabaseConnection.createConnect();
				PreparedStatement st = con.prepareStatement(query);){
	
			rowUpdated = st.executeUpdate() > 0;
			con.close();
		}
		catch (SQLException e) {
			printSQLException(e);
		}
		//returning true if edited successfully else false
		return rowUpdated;
	}
	
	//DELETE API method
	public boolean deleteWinterInternship(String query1) throws SQLException {
		boolean rowDeleted = false;
		try (Connection con = DatabaseConnection.createConnect();
				PreparedStatement st = con.prepareStatement(query1);) {
			
			rowDeleted = st.executeUpdate() > 0;
			con.close();
		}
		catch (SQLException e) {
			printSQLException(e);
		
		
		}
		//returning true if deleted successfully else false
		return rowDeleted;
	}
	
	
	//SEARCH API method
	public List<WinterInternshipPojo> getWinterInternship(String query3) throws SQLException {
		List<WinterInternshipPojo> listSearch = new ArrayList<>();
		//WinterInternshipPojo winterInternship = null;
		try (Connection con = DatabaseConnection.createConnect();
				PreparedStatement st = con.prepareStatement(query3);){
			
				
				ResultSet resultSet = st.executeQuery();
		    //storing the searched data by customer number     
			while (resultSet.next()) {
		    		int slNo = resultSet.getInt("sl_no");
		    		int id = resultSet.getInt("sl_no");
		    		String businessCode = resultSet.getString("business_code");
		    		long custNumber = resultSet.getLong("cust_number");
			    	String clearDate = resultSet.getString("clear_date");
			    	int buisnessYear = resultSet.getInt("buisness_year");
			    	long docId = resultSet.getLong("doc_id");
			    	String postingDate = resultSet.getString("posting_date");
			    	String documentCreateDate = resultSet.getString("document_create_date");
			    	String documentCreateDate1 = resultSet.getString("document_create_date1");
			    	String dueInDate = resultSet.getString("due_in_date");
			    	String invoiceCurrency = resultSet.getString("invoice_currency");
			    	String documentType = resultSet.getString("document_type");
			    	int postingId = resultSet.getInt("posting_id");
			    	String areaBusiness = resultSet.getString("area_business");
			    	double totalOpenAmount = resultSet.getDouble("total_open_amount");
			    	String baselineCreateDate = resultSet.getString("baseline_create_date");
			    	String custPaymentTerms = resultSet.getString("cust_payment_terms");
			    	long invoiceId = resultSet.getLong("invoice_id");
			    	int isOpen = resultSet.getInt("isOpen");
			    	String agingBucket = resultSet.getString("aging_bucket");
			    	int isDeleted = resultSet.getInt("is_deleted");
			    	agingBucket = (agingBucket==null?"NA":agingBucket);
			    	
			    	WinterInternshipPojo myWinterInternship = new WinterInternshipPojo(slNo, businessCode, custNumber, clearDate, buisnessYear, docId, postingDate,documentCreateDate, documentCreateDate1, dueInDate, invoiceCurrency, documentType, postingId,areaBusiness, totalOpenAmount, baselineCreateDate, custPaymentTerms, invoiceId, isOpen, agingBucket,isDeleted);
			    	myWinterInternship.setId(id);
			    	//Storing the searched data in a list
			    	listSearch.add(myWinterInternship);
			         
		   		
			    }
			resultSet.close();
	   		st.close();
			
			}
			catch (SQLException e) {
				printSQLException(e);
			}    
			//returning the final list
	    	return listSearch;
	}
	
	
	
	//ADVANCE SEARCH API method
	public List<WinterInternshipPojo> getWinterInternship1(String query3) throws SQLException {
		List<WinterInternshipPojo> listSearch = new ArrayList<>();
		//WinterInternshipPojo winterInternship = null;
		try (Connection con = DatabaseConnection.createConnect();
				PreparedStatement st = con.prepareStatement(query3);){
			
				
				
				
		         
				ResultSet resultSet = st.executeQuery();
			//storing the Advanced Searched data by DocumentID,InvoiceID,Customer Number,Business Year 
			while (resultSet.next()) {
		    		int slNo = resultSet.getInt("sl_no");
		    		int id = resultSet.getInt("sl_no");
		    		String businessCode = resultSet.getString("business_code");
		    		long custNumber = resultSet.getLong("cust_number");
			    	String clearDate = resultSet.getString("clear_date");
			    	int buisnessYear = resultSet.getInt("buisness_year");
			    	long docId = resultSet.getLong("doc_id");
			    	String postingDate = resultSet.getString("posting_date");
			    	String documentCreateDate = resultSet.getString("document_create_date");
			    	String documentCreateDate1 = resultSet.getString("document_create_date1");
			    	String dueInDate = resultSet.getString("due_in_date");
			    	String invoiceCurrency = resultSet.getString("invoice_currency");
			    	String documentType = resultSet.getString("document_type");
			    	int postingId = resultSet.getInt("posting_id");
			    	String areaBusiness = resultSet.getString("area_business");
			    	double totalOpenAmount = resultSet.getDouble("total_open_amount");
			    	String baselineCreateDate = resultSet.getString("baseline_create_date");
			    	String custPaymentTerms = resultSet.getString("cust_payment_terms");
			    	long invoiceId = resultSet.getLong("invoice_id");
			    	int isOpen = resultSet.getInt("isOpen");
			    	String agingBucket = resultSet.getString("aging_bucket");
			    	int isDeleted = resultSet.getInt("is_deleted");
			    	agingBucket = (agingBucket==null?"NA":agingBucket);
			             
			    	WinterInternshipPojo myWinterInternship = new WinterInternshipPojo(slNo, businessCode, custNumber, clearDate, buisnessYear, docId, postingDate,documentCreateDate, documentCreateDate1, dueInDate, invoiceCurrency, documentType, postingId,areaBusiness, totalOpenAmount, baselineCreateDate, custPaymentTerms, invoiceId, isOpen, agingBucket,isDeleted);
			    	myWinterInternship.setId(id);
			    	//storing advanced search data in a list
			    	listSearch.add(myWinterInternship);
			         
		   		
			    }
			resultSet.close();
	   		st.close();
			
			}
			catch (SQLException e) {
				printSQLException(e);
			}      
			//returning the advanced search Data
	    	return listSearch;
	}
	
	
	//FETCH COUNT API method
	public int fetchCount() {
		int count = 0;
		try (Connection con = DatabaseConnection.createConnect(); PreparedStatement st = con.prepareStatement(COUNT_QUERY);) {
			
			ResultSet resultSet = st.executeQuery();
			resultSet.next();
			 count = 
			resultSet.getInt(1);
			 //st.executeUpdate();
			 resultSet.close();
			 con.close();
		} 	
		catch (SQLException e) {
			printSQLException(e);
		}
		//returning the total number of datas in database
		return count;
	}
	
	//FETCH DOC-ID FOR PREDICT BUTTON
		public List<Long> fetchDocID(String query) {
			//long docId = 0;
			List<Long> docId = new ArrayList<>();
			try (Connection con = DatabaseConnection.createConnect(); PreparedStatement st = con.prepareStatement(query);) {
				
				ResultSet resultSet = st.executeQuery();
				while(resultSet.next()){
					//storing the docid for prediction
					docId.add(resultSet.getLong("doc_id"));
					}
				
				 
				 con.close();
			} 	
			catch (SQLException e) {
				printSQLException(e);
			}
			return docId;
		}
		
		//EDIT AGING BUCKET METHOD ---> FOR UPDATING Aging bucket from PREDICT button
		public boolean editAgingBucket(String query) throws SQLException {
			boolean rowUpdated = false;
			try (Connection con = DatabaseConnection.createConnect();
					PreparedStatement st = con.prepareStatement(query);){
		
				rowUpdated = st.executeUpdate() > 0;
				con.close();
			}
			catch (SQLException e) {
				printSQLException(e);
			}
			return rowUpdated;
		}
	
	
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