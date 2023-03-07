<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="com.techpalle.model.StudentDetails"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">Student Details</h1>
<table border="1" cellspacing="0" align="center">
		<tr>
				<th>Student ID</th>
				<th>Student Name</th>
				<th>Student Email</th>
				<th>Student Password</th>
				<th>Student State</th>
		</tr>
		
		<%
				ArrayList<StudentDetails> s=(ArrayList<StudentDetails>) request.getAttribute("showAll");
				for(StudentDetails item:s)
				{
					out.print("<tr>");
					out.print("<td>"+item.getSid()+"</td>");
					out.print("<td>"+item.getName()+"</td>");
					out.print("<td>"+item.getEmail()+"</td>");
					out.print("<td>"+item.getPassword()+"</td>");
					out.print("<td>"+item.getState()+"</td>");
					out.print("</tr>");
				}
		%>

</table>

</body>
</html>