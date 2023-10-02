<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- "<b></b> is used to bold text" : can't print <b></b>  -->
	<h5>Regular print: ${sXml} </h5>
	
	<!-- "&lt;b&gt;&lt;/b&gt;"  -->
	<h5>Use helper: ${convXml}</h5>
	
	<!-- c:out can prevent cross-site attack  -->
	<h5>Use c:out : <c:out value="${sXml}" escapeXml="true"></c:out></h5> <!-- convert xml to text -->
	<h5>Use c:out : <c:out value="${sXml}" escapeXml="false"></c:out></h5> <!-- no  -->
	<h5>Use c:out : <c:out value="${valueThatNotExisted}" escapeXml="true" default="Just a null value"></c:out></h5>
</body>
</html>