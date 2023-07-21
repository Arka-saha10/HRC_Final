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

public class DeleteServlet extends HttpServlet{
	
		private static final long serialVersionUID = 1L;

		public DeleteServlet() {
	        super();
	        // TODO Auto-generated constructor stub
	    }
		
		protected void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			doGet(request, response);
		}

		protected void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			//getting the slNo from Request
			String slNo = request.getParameter("slNo");

			WinterInternshipDAO user = new WinterInternshipDAO();
			try {
				String que="DELETE FROM winter_internship WHERE sl_no IN("+slNo+");";
				System.out.println(que);
				boolean rowDeleted = user.deleteWinterInternship(que);
				//Generating the response
				response.setStatus(200);
				response.setContentType("application/json");
				response.getWriter().println(new Gson().toJson(rowDeleted));
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
		}
}