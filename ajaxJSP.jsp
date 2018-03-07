<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import = "java.sql.*"
%>

<%
	DriverManager.registerDriver(new com.mysql.jdbc.Driver());   
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Wtlab","root","manisha");
	
	String user = request.getParameter("user");
	String pwd  = request.getParameter("pass");
	
	Statement stmt = con.createStatement();
	ResultSet rs;
	rs = stmt.executeQuery("select * from log where username='"+user+"'"+" and password='"+pwd+"'");
	if(rs.next()){
		out.println("Valid Login");
	}
	else{
		out.println("Invalid Login");
	}
%>