package com.demo.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.DAO.WinterInternshipDAO;
import com.demo.pojo.WinterInternshipPojo;
import com.google.gson.Gson;

public class SearchServlet extends HttpServlet {
		private static final long serialVersionUID = 1L;

		public SearchServlet() {
	        super();
	        // TODO Auto-generated constructor stub
	    }

		protected void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			doGet(request, response);
		}

		protected void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			//Fetching customer from Request
			String custNumber = request.getParameter("custNumber");
			
			
			
					
	    	WinterInternshipDAO ob = new WinterInternshipDAO();
	    	List<WinterInternshipPojo> user = null;
	    	
			try {
				
				String que1="SELECT * FROM winter_internship WHERE cust_number=" +custNumber+";";
				user = ob.getWinterInternship(que1);
		    	System.out.println(que1);
				//generating Response for frontend
				response.setStatus(200);
				response.setContentType("application/json");
				response.getWriter().println(new Gson().toJson(user));
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
	    	
	    	
	    	//System.out.println(custNumber);
			//response.sendRedirect("list");
			//TODO redirect response

			
		
	}
}