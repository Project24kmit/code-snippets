package com.pmp.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pmp.services.DealerService;
import com.pmp.sql.DatabaseConnector;

@WebServlet("/dealer")
public class DealerServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	Connection dbconnection;
	DealerService dealerService = new DealerService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				if(request.getSession().getAttribute("dealerId")!=null)
					request.getRequestDispatcher("jsp/dealer-home-page.jsp").forward(request, response);
				else
					request.getRequestDispatcher("jsp/home-page.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");
		if(action.equals("loginDealer"))
			login(request,response);
		else if(action.equals("registerDealer"))
			register(request,response);
	}

	private void register(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String address = request.getParameter("address");
		String mobile = request.getParameter("mobile");
		String email = request.getParameter("email");
		
		dbconnection = DatabaseConnector.getDBConnection();
		int result = dealerService.insertDealerDetails(firstName,lastName,address,mobile,email,dbconnection);
		String message = "";

		if(result!=-1)
			message = result+"" ;
		else
			message = "Error";
        request.setAttribute("message", message);
		request.getRequestDispatcher("jsp/dealer-registration-page.jsp").forward(request, response);
	}

	private void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int dealerId = Integer.parseInt(request.getParameter("did"));
		String password = request.getParameter("dpassword");
		
		dbconnection = DatabaseConnector.getDBConnection();
		boolean isDealerValid = dealerService.isDealerValid(dealerId, password, dbconnection);
		
		if (isDealerValid) 
		{
			request.getSession().setAttribute("dealerId", dealerId);
			request.getSession().setAttribute("csrfToken", generateCSRFToken());
			String sessionid = request.getSession().getId();
			response.setHeader("Set-Cookie", "JSESSIONID=" + sessionid + ";");
			doGet(request, response);
		} 
		else 
		{
			request.setAttribute("error", "Invalid credientials");
			request.getRequestDispatcher("jsp/home-page.jsp").forward(request, response);

		}
	}

	public static String generateCSRFToken() {
		String token = UUID.randomUUID().toString();
		return token;
	}

}
