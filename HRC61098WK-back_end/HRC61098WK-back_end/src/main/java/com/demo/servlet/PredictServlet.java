package com.demo.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.DAO.WinterInternshipDAO;
import com.google.gson.Gson;


public class PredictServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   public PredictServlet() {
        super();
        
    }

	
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//Fetching slNo from Request
		String slNo = request.getParameter("slNo");
		WinterInternshipDAO ob = new WinterInternshipDAO();
    	
		List<Long> docId = new ArrayList<>();
    	
    	
		String que1="SELECT doc_id FROM winter_internship WHERE sl_no IN("+slNo+") and clear_date = '0000-00-00';";
		System.out.println(que1);
		docId = ob.fetchDocID(que1);
		//generating response to frontend
		response.setStatus(200);
		response.setContentType("application/json");
		response.getWriter().println(new Gson().toJson(docId));
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}