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
import com.pmp.services.AdminService;
import com.pmp.sql.DatabaseConnector;

@WebServlet("/admin")
public class AdminServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	Connection dbconnection = DatabaseConnector.getDBConnection();
	AdminService adminService = new AdminService(dbconnection);	
		
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				// temporary fix
		try
		{		
			if(((String)request.getSession(false).getAttribute("adminId")).equals("100"))
				homePage(request,response);
		}
		catch(NullPointerException e)
		{
			request.getRequestDispatcher("jsp/admin-login.jsp").forward(request, response);
		}

	}

	protected void homePage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Dealer> requestList = adminService.dealerRequestList();
		request.setAttribute("requestList", requestList);
		request.getRequestDispatcher("jsp/admin-home-page.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

			String action = request.getParameter("action");
			boolean result;
			System.out.println(action);
			if(action.equals("adminLogin"))
			{
				String id = request.getParameter("admin");
				String pwd = request.getParameter("password");
				if (adminService.login(id,pwd)) 
				{
					request.getSession().setAttribute("adminId", id);
					// request.getSession().setAttribute("csrfToken", generateCSRFToken());
					// String sessionid = request.getSession().getId();
					response.setHeader("Set-Cookie", "ADMINID=" + id + ";");
					homePage(request, response);
				} 
				else
				{
					doGet(request,response);
				}
			}
			else if(action.equals("accept"))
			{
				int requestId = Integer.parseInt(request.getParameter("rid"));	
				result = adminService.acceptRequest(requestId);
			}
			else if(action.equals("reject"))	
			{
				int requestId = Integer.parseInt(request.getParameter("rid"));	
				result = adminService.rejectRequest(requestId);
			}
			else if(action.equals("getDealer"))	
			{
				int dealerId = Integer.parseInt(request.getParameter("did"));	
				Dealer dealer = adminService.getDealerRecord(dealerId);
				if(dealer==null)
					request.setAttribute("msg", "null");
				else				
					request.setAttribute("dealer", dealer);			
				request.getRequestDispatcher("jsp/unregister-dealer.jsp").forward(request, response);	
			}
			else if(action.equals("inbox"))
			{
				homePage(request,response);
			}
			else if(action.equals("unregister"))
			{
				request.getRequestDispatcher("jsp/unregister-dealer.jsp").forward(request, response);	
			}
			else if(action.equals("Unregister"))
			{
				String dealerId = request.getParameter("did");
				String reason = request.getParameter("reason");
				boolean success = adminService.unregisterDealer(Integer.parseInt(dealerId),reason);
				if(success)
					request.setAttribute("msg","unregistered");
				else
					request.setAttribute("msg","error");
				request.getRequestDispatcher("jsp/unregister-dealer.jsp").forward(request, response);	
			}
			else if (action.equals("viewDealers"))
			{
				List<Dealer> dealerList = adminService.getDealers();
				request.setAttribute("dealerList", dealerList);
				request.getRequestDispatcher("jsp/view-dealers.jsp").forward(request, response);	
			}
			else if(action.equals("overall"))
			{
				List<Order> salesList = adminService.getOverallSales();
				request.setAttribute("salesList",salesList);
				request.getRequestDispatcher("jsp/admin-overall-graph.jsp").forward(request,response);
			}
			else if(action.equals("dealerWise"))
			{
				request.getRequestDispatcher("jsp/admin-dealer-graph.jsp").forward(request,response);
			}
			else if(action.equals("dealerName"))
			{	
				int dealerId = Integer.parseInt(request.getParameter("did"));
				List<Order> salesList = adminService.getSalesDataPerDealer(dealerId);
				request.setAttribute("salesList",salesList);
				request.setAttribute("dealer",dealerId);
				request.getRequestDispatcher("jsp/admin-dealer-graph.jsp").forward(request,response);
			}
	}

	public static String generateCSRFToken() {
		String token = UUID.randomUUID().toString();
		return token;
	}
	
}
