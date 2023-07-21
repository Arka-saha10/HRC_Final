package com.demo.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.DAO.WinterInternshipDAO;
import com.demo.pojo.WinterInternshipPojo;
import com.google.gson.Gson;

public class AdvanceSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public AdvanceSearchServlet() {
        super();
        
    }

	
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
    	WinterInternshipDAO ob = new WinterInternshipDAO();
    	List<WinterInternshipPojo> user = null;
    	String query = request.getParameter("query");
		if(!(query == null || "".contentEquals(query))) {
			query = "where "+ query;
			System.out.println(query);
		}
		
		
		String q1 = "SELECT * FROM winter_internship "+query+";";
    	
		try {
			
			//calling the method of Advanced Search from WinterInternshipDAO
			user = ob.getWinterInternship(q1);
	    	System.out.println(q1);
	    	//generating response
			response.setStatus(200);
			response.setContentType("application/json");
			response.getWriter().println(new Gson().toJson(user));
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
    	
    	

		
	
}

}