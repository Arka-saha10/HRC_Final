package com.demo.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.DAO.*;
import com.demo.pojo.WinterInternshipPojo;
import com.google.gson.Gson;

public class AddServlet extends HttpServlet {
		private static final long serialVersionUID = 1L;
		
		public AddServlet() {
	        super();
	    }

		protected void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			doGet(request, response);
		}

		protected void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			
			boolean rowAdded = false;
			
			//String slNo = request.getParameter("slNo");
	    	String businessCode = request.getParameter("businessCode");
	    	String custNumber = request.getParameter("custNumber");
	    	String clearDate = request.getParameter("clearDate");
	    	String buisnessYear = request.getParameter("buisnessYear");
	    	String docId = request.getParameter("docId");
	    	String postingDate = request.getParameter("postingDate");
	    	String documentCreateDate = request.getParameter("documentCreateDate");
	    	String dueInDate = request.getParameter("dueInDate");
	    	String invoiceCurrency = request.getParameter("invoiceCurrency");
	    	String documentType = request.getParameter("documentType");
	    	String postingId = request.getParameter("postingId");
	    	String totalOpenAmount = request.getParameter("totalOpenAmount");
	    	String baselineCreateDate = request.getParameter("baselineCreateDate");
	    	String custPaymentTerms = request.getParameter("custPaymentTerms");
	    	String invoiceId = request.getParameter("invoiceId");
	    	
	    	
	      	
			
					
	    	WinterInternshipDAO ob = new WinterInternshipDAO();
	    	
	try {
				int temp = ob.fetchCount();
				temp=temp+1;
				String sl_no = String.valueOf(temp);
				
				//String appendQuery = "SELECT cust_number FROM winter_internship LEFT JOIN customer ON winter_internship.cust_number = customer.cust_number;";
				
				String queryAdd="INSERT INTO winter_internship (sl_no,business_code,cust_number,clear_date,buisness_year,doc_id,posting_date,document_create_date,due_in_date,invoice_currency,document_type,posting_id,total_open_amount,baseline_create_date,cust_payment_terms,invoice_id) VALUES ("+sl_no+",'"+businessCode+"','"+custNumber+"','"+clearDate+"','"+buisnessYear+"','"+docId+"','"+postingDate+"','"+documentCreateDate+"','"+dueInDate+"','"+invoiceCurrency+"','"+documentType+"','"+postingId+"','"+totalOpenAmount+"','"+baselineCreateDate+"','"+custPaymentTerms+"','"+invoiceId+"');";
		    	//queryAdd = queryAdd + appendQuery;
				System.out.println(queryAdd);
		    	rowAdded = ob.addWinterInternship(queryAdd);
		    	
		    	//sending response to frontend
				response.setStatus(200);
				response.setContentType("application/json");
				response.getWriter().println(new Gson().toJson(rowAdded));
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
			//response.sendRedirect("list");
			//TODO redirect response

			
		
	}
}
