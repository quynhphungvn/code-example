<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, quynh.training.servlet_jsp.model.Department"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style><%@include file="./style.css"%></style>
<body>
	<!-- Scriplet -->
	<%
		List<Department> departments = (List<Department>) request.getAttribute("departments");
		for (Department d : departments)
			out.print("<p>Department Name: " + d.getName() + "</p>");
		int nestedCount = 0;
	%>
	<!-- Expression -->
	<h5>Nested Count: </h5><%= ++nestedCount %>
	<hr/>
	<!-- function -->
	<%!
		int countRequest = 0;
		public void resetCountRequest() {
				countRequest = 0;
		}
	%>
	<h5>Request number: <%= ++countRequest %></h5>
	<%
		if (countRequest == 5) 
			resetCountRequest();
	%>
	<script><%@include file="./script.js" %></script>
</body>
</html>