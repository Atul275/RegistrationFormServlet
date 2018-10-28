<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<title>Log Out Page</title>
<body>You are successfully logged out.!
<%
  session.invalidate();
  response.sendRedirect("login.jsp");
%>
</body>