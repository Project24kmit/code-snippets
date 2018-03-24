package com.pmp.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.util.UUID;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pmp.elements.*;
import com.pmp.services.*;
import com.pmp.sql.DatabaseConnector;

@WebServlet("/graph")
public class graphServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	Connection dbconnection = DatabaseConnector.getDBConnection();
	graphService gService = new graphService(dbconnection);	
		
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				// temporary fix
		request.getRequestDispatcher("jsp/dum2.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if(request.getParameter("graph")!=null)
		{
			int dealerId = Integer.parseInt(request.getParameter("did"));
			String date = request.getParameter("date");
			List<Product> salesList = gService.getDateWiseSalesData(dealerId,date);
			request.setAttribute("salesList",salesList);
			request.getRequestDispatcher("jsp/graph.jsp").forward(request,response);
			
		}

		if(request.getParameter("line")!=null)
		{
			int dealerId = Integer.parseInt(request.getParameter("did"));
			int productId = Integer.parseInt(request.getParameter("pid"));

			
			List<Order> salesList = gService.getAnnualSalesData(dealerId,productId);
			request.getRequestDispatcher("jsp/graph1.jsp").forward(request,response);
			
		}

		if(request.getParameter("pie")!=null)
		{
			int dealerId = Integer.parseInt(request.getParameter("did"));

			
			List<Product> salesList = gService.getSalesData(dealerId);
			request.setAttribute("salesList",salesList);
			request.getRequestDispatcher("jsp/graph2.jsp").forward(request,response);
			
		}
		
	}
}

