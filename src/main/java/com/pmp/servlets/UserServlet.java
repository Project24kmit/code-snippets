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
import com.pmp.services.UserService;
import com.pmp.sql.DatabaseConnector;

@WebServlet("/user")
public class UserServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	Connection dbconnection = DatabaseConnector.getDBConnection();
	UserService userService = new UserService(dbconnection);	
		
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				// temporary fix
		request.getRequestDispatcher("jsp/dummy.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if(request.getParameter("cart")!=null)
		{
			int userId = Integer.parseInt(request.getParameter("uid"));
			List<Order> orders = userService.getAllOrders(userId);
			request.setAttribute("orderList",orders);
			request.getRequestDispatcher("jsp/cart-page.jsp").forward(request,response);
			
		}

		else if(request.getParameter("checkout")!=null)
		{
			String amount = request.getParameter("amount");
			request.setAttribute("amount",amount);
			request.getRequestDispatcher("jsp/checkout.jsp").forward(request, response);
		}

		else if(request.getParameter("action").equals("buy"))
		{
			// get all order information
			// int userId=1;
			// userService.buyProduct();
			String amount = request.getParameter("amount");
			request.setAttribute("amount",amount);
			request.getRequestDispatcher("jsp/checkout.jsp").forward(request, response);	
		}

		else if(request.getParameter("action").equals("addToCart"))
		{
			// get all order information
			// int userId=1;
			// userService.buyProduct();
		}

		else if(request.getParameter("action").equals("deleteItem"))
		{
			int transactionId = Integer.parseInt(request.getParameter("tid"));
			userService.deleteTransaction(transactionId);
		} 

		else if(request.getParameter("action").equals("updateItem"))
		{
			int transactionId = Integer.parseInt(request.getParameter("tid"));
			int quantity = Integer.parseInt(request.getParameter("qty"));
			userService.updateTransaction(transactionId,quantity);
		}		

		
	}
}

