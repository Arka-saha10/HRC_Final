package com.demo.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.DAO.WinterInternshipDAO;
import com.google.gson.Gson;



public class EditAgingBucket extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public EditAgingBucket() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		boolean rowUpdated = false;
		String agingBucket = request.getParameter("agingBucket");
		String docId = request.getParameter("docId");
//		String que1="UPDATE winter_internship SET aging_bucket ='"+ agingBucket+"' WHERE sl_no="+slNo+";";
//    	System.out.println(que1);
		WinterInternshipDAO ob = new WinterInternshipDAO();
		
//		response.setStatus(200);
//		response.setContentType("application/json");
//		response.getWriter().println(new Gson().toJson(true));
		try {
			
			String que1="UPDATE winter_internship SET aging_bucket ='"+ agingBucket+"' WHERE doc_id="+docId+";";
	    	System.out.println(que1);
	    	rowUpdated = ob.editWinterInternship(que1);
			response.setStatus(200);
			response.setContentType("application/json");
			response.getWriter().println(new Gson().toJson(rowUpdated));
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}