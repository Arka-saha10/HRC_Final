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

public class EditServlet extends HttpServlet {
		private static final long serialVersionUID = 1L;

		public EditServlet() {
	        super();
	        // TODO Auto-generated constructor stub
	    }


		protected void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			doGet(request, response);
		}

		protected void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			
			boolean rowUpdated = false;
			//fetching slno,invoice currency, customer payment terms from URL
			String slNo = request.getParameter("slNo");

	    	String invoiceCurrency = request.getParameter("invoiceCurrency");

	    	String custPaymentTerms = request.getParameter("custPaymentTerms");

	      	
			
					
	    	WinterInternshipDAO ob = new WinterInternshipDAO();
	    	
	    	
	    	
	    	
			try {
				
				String que1="UPDATE winter_internship SET invoice_currency='"+ invoiceCurrency+"', cust_payment_terms ='"+ custPaymentTerms+"' WHERE sl_no="+slNo+";";
		    	System.out.println(que1);
		    	rowUpdated = ob.editWinterInternship(que1);
		    	
		    	//sending response to frontend
				response.setStatus(200);
				response.setContentType("application/json");
				response.getWriter().println(new Gson().toJson(rowUpdated));
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
			//response.sendRedirect("list");
			//TODO redirect response

			
		
	}
}