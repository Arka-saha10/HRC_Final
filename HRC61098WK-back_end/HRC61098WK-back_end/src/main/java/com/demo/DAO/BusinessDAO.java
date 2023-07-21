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



public class BusinessDAO {
	
	private static final String INSERT_SQL = "INSERT INTO business (business_code, business_name) VALUES (?, ?)";
	private static final String DELETE_SQL = "DELETE FROM business where business_code = ?";
	private static final String UPDATE_SQL = "UPDATE business SET business_name = ? WHERE business_code = ?";
    private static final String SELECT_ALL = "SELECT * FROM business";
    private static final String SELECT_BY_ID = "SELECT * FROM business WHERE business_code = ?";
	
	public BusinessDAO() {
		
	}
	

//	public List<BusinessPojo> listAllBusiness() throws SQLException {
//    List<BusinessPojo> listBusiness = new ArrayList<>();
//	
//    	//TO - DO ---> Create Sql injection
//    	//String sql = "SELECT * FROM business";
//    
//    	connect();
//     
//    	Statement statement = jdbcConnection.createStatement();
//    	ResultSet resultSet = statement.executeQuery(SELECT_ALL);
//    
//    	while (resultSet.next()) {
//    		String businessCode = resultSet.getString("business_code");
//    		String businessName = resultSet.getString("business_name");
//       
//    		//Here we're declaring a table of name myBusiness of BusinessPojo class
//    		BusinessPojo myBusiness = new BusinessPojo(businessCode, businessName);
//    		listBusiness.add(myBusiness);
//    	}
//	
//    	resultSet.close();
//    	statement.close();
//     
//    	disconnect();
//    
//    	return listBusiness;
//    	
//	}
	
	
	//ADD method signature
	public void addBusiness(BusinessPojo business) throws SQLException {
		System.out.println(INSERT_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection con = DatabaseConnection.createConnect();
				PreparedStatement st = con.prepareStatement(INSERT_SQL)) {
			
			st.setString(1, business.getbusinessCode());
	        st.setString(2, business.getbusinessName());
			
			System.out.println(st);
			st.executeUpdate();
			con.close();
		} 	
		catch (SQLException e) {
			printSQLException(e);
		}
	}

	
	//EDIT method signature
	public boolean editBusiness(BusinessPojo business) throws SQLException {
		boolean rowUpdated = false;
		try (Connection con = DatabaseConnection.createConnect();
				PreparedStatement st = con.prepareStatement(UPDATE_SQL);) {
			st.setString(1, business.getbusinessName());
	        st.setString(2, business.getbusinessCode());

			rowUpdated = st.executeUpdate() > 0;
			con.close();
		}
		catch (SQLException e) {
			printSQLException(e);
		}
		return rowUpdated;
	}
	
	//DELETE method signature
	public boolean deleteBusiness(BusinessPojo business) throws SQLException {
		boolean rowDeleted = false;
		try (Connection con = DatabaseConnection.createConnect();
				PreparedStatement st = con.prepareStatement(DELETE_SQL);) {
			st.setString(1, business.getbusinessCode());
			rowDeleted = st.executeUpdate() > 0;
			con.close();
		}
		catch (SQLException e) {
			printSQLException(e);
		}
		return rowDeleted;
	}
	
	//FETCH API
//	public BusinessPojo getBusiness(String businessCode) throws SQLException {
//		BusinessPojo business = null;
//        String sql = "SELECT * FROM business WHERE business_code = ?";
//         
//        connect();
//         
//        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
//        statement.setString(1, businessCode);
//         
//        ResultSet resultSet = statement.executeQuery();
//         
//        if (resultSet.next()) {
//        	String businessName = resultSet.getString("business_name");
//             
//        	business = new BusinessPojo(businessCode, businessName);
//        }
//         
//        resultSet.close();
//        statement.close();
//        disconnect();
//        return business;
//    }
	
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
