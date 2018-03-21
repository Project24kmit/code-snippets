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

import com.pmp.elements.Dealer;
import com.pmp.services.AdminService;
import com.pmp.sql.DatabaseConnector;

@WebServlet("/admin")
public class AdminServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	Connection dbconnection = DatabaseConnector.getDBConnection();
	AdminService adminService = new AdminService(dbconnection);	
		
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("jsp/admin-login.jsp").forward(request, response);

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

			if(action.equals("adminLogin"))
			{
				String id = request.getParameter("admin");
				String pwd = request.getParameter("password");
				if (adminService.login(id,pwd)) 
				{
					request.getSession().setAttribute("adminId", id);
					// request.getSession().setAttribute("csrfToken", generateCSRFToken());
					// String sessionid = request.getSession().getId();
					response.setHeader("Set-Cookie", "JSESSIONID=" + sessionid + ";");
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
			else if(action.equals("unregisterDealer"))
			{
				int dealerId = Integer.parseInt(request.getParameter("did"));	
				boolean success = adminService.unregisterDealer(dealerId);
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
	}

	public static String generateCSRFToken() {
		String token = UUID.randomUUID().toString();
		return token;
	}
	
}
