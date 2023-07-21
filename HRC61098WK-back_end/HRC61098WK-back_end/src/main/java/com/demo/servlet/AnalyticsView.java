package com.demo.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.pojo.ChartPojo;
import com.google.gson.Gson;

/**
 * Servlet implementation class AnalyticsView
 */
@WebServlet("/AnalyticsView")
public class AnalyticsView extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AnalyticsView() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			HashMap<Object, Object> Response = new HashMap<Object, Object>();
			ArrayList<ChartPojo> BusinessData = new ArrayList<ChartPojo>();
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/grey_goose", "root","codingisgod@10");
			String query ="SELECT ROW_NUMBER() OVER (ORDER BY b.business_name) AS id , b.business_name , w.business_code , COUNT(cust_number) AS cust_count, SUM(total_open_amount) AS total_amount FROM winter_internship w,business b WHERE w.business_code=b.business_code AND ";
			
			if(request.getParameter("clear_date1") != null && !request.getParameter("clear_date1").equals("null") && request.getParameter("clear_date2") != null && !request.getParameter("clear_date2").equals("null")) {
				query += " (w.clear_date >'"+request.getParameter("clear_date1")+"' AND "+"w.clear_date<'"+request.getParameter("clear_date2")+"') AND";
			}
			if(request.getParameter("due_in_date1") != null && !request.getParameter("due_in_date1").equals("null") && request.getParameter("due_in_date2") != null && !request.getParameter("due_in_date2").equals("null")) {
				query += " (w.due_in_date >'"+request.getParameter("due_in_date1")+"' AND "+"w.due_in_date<'"+request.getParameter("due_in_date2")+"') AND";
			}
			if(request.getParameter("baseline_create_date1") != null && !request.getParameter("baseline_create_date1").equals("null") && request.getParameter("baseline_create_date2") != null && !request.getParameter("baseline_create_date1").equals("null")) {
				query += " (w.baseline_create_date >'"+request.getParameter("baseline_create_date1")+"' AND "+"w.baseline_create_date<'"+request.getParameter("baseline_create_date2")+"') AND";
			}
			if(request.getParameter("invoice_currency") != null && !request.getParameter("invoice_currency").equals("null")) {
				query += " (invoice_currency='"+request.getParameter("invoice_currency")+"') AND";
			}

			int len = query.length();
			String query1 = query.substring(0, len - 4);
			query1 += " GROUP BY w.business_code";
			PreparedStatement ps = con.prepareStatement(query1);
			System.out.println(query1);
			ResultSet rs = ps.executeQuery();

			

			while (rs.next()) {
				int id = rs.getInt("id");
            	String business_name=rs.getString("business_name");
    	        String business_code=rs.getString("business_code");
    	        int cust_count=rs.getInt("cust_count");
    	        double total_amount=rs.getDouble("total_amount");

    	        BusinessData.add(new ChartPojo (id,business_name,business_code,cust_count,total_amount));
            }
			Response.put("users", BusinessData);
			Gson gson = new Gson();
			String jsonResponse = gson.toJson(Response);
			
			// CORS Policy... issue
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.getWriter().append(jsonResponse);

		} catch (Exception e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}