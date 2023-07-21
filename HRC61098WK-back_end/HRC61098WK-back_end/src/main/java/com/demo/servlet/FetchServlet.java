package com.demo.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.DAO.WinterInternshipDAO;
import com.demo.pojo.WinterInternshipPojo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;



public class FetchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public FetchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int pageNo = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("size"));
		String query = request.getParameter("query");
		if(!(query == null || "".contentEquals(query))) {
			query = "where "+ query;
			System.out.println(query);
		}
		int start = (pageNo - 1)*pageSize;
		
		String q1 = "SELECT * FROM winter_internship "+query+";";
		System.out.println(q1);
		WinterInternshipDAO user = new WinterInternshipDAO();
		try {
			//Fetch all rows
			List<WinterInternshipPojo> ob = user.listAllWinterInternship(start,pageSize);
			response.setStatus(200);
			response.setContentType("application/json");
			response.getWriter().println(new Gson().toJson(ob));
			
			//Advance Search
//			WinterInternshipPojo ob1 = user.getWinterInternship2(q1);
//			response.setStatus(200);
//			response.setContentType("application/json");
//			response.getWriter().println(new Gson().toJson(ob1));
			
			//Gson gson = new GsonBuilder().setPrettyPrinting().create();
			//String jsonStr = gson.toJson(ob);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	
	
}