package com.pmp.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pmp.services.UserService;
import com.pmp.sql.DatabaseConnector;

@WebServlet("/user")
public class UserServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	Connection dbconnection;
	UserService userService = new UserService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				if(request.getSession().getAttribute("userId")!=null)
					request.getRequestDispatcher("jsp/user-home-page.jsp").forward(request, response);
				else
					request.getRequestDispatcher("jsp/home-page.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");
		if(action.equals("loginUser"))
			login(request,response);
		else if(action.equals("registerUser"))
			register(request,response);
	}

	private void register(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String address = request.getParameter("address");
		String mobile = request.getParameter("mobile");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		dbconnection = DatabaseConnector.getDBConnection();
		int result = userService.insertUserDetails(firstName,lastName,address,mobile,email,password,dbconnection);
		String message = "";
		
		if(result!=-1)
			message = result+"" ;
		else
			message = "Error";
        request.setAttribute("message", message);
		request.getRequestDispatcher("jsp/user-registration-page.jsp").forward(request, response);
	}

	private void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int userId = Integer.parseInt(request.getParameter("uid"));
		String password = request.getParameter("upassword");
		
		dbconnection = DatabaseConnector.getDBConnection();
		boolean isUserValid = userService.isUserValid(userId, password, dbconnection);
		if (isUserValid) 
		{
			request.getSession().setAttribute("userId", userId);
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
