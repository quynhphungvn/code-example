<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Welcome author: <%= getServletConfig().getInitParameter("Author") %></h2>

<%!
	public void jspInit() {
		ServletConfig sConfig = getServletConfig();
		String authorName = sConfig.getInitParameter("Author");
		ServletContext ctx = getServletContext();
		ctx.setAttribute("authorName", authorName);
	}
%>
Hello Author: <%= application.getAttribute("authorName") %>
</body>
</html>