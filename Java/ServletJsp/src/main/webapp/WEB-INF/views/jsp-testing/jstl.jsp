<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import= "	java.util.List,
					java.util.ArrayList,
					quynh.training.servlet_jsp.model.Department,
					quynh.training.servlet_jsp.model.Employee,
					quynh.training.servlet_jsp.model.Role" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>JSTL</title>
  <style><%@include file="./style.css" %></style>
</head>
<body>
	<!-- EL -->
	<h5> Department[0]'s name: ${departments.get(0).name}</h5>
	
	<!-- JSTL core -->
	<c:if test="${departments != null}">
		<c:forEach var="dept" items="${departments}">
	         <p>Dept: <c:out value = "${dept.name}"/><p>
	    </c:forEach>
	</c:if>
	
	<!-- JSTL format -->
	<c:set var = "balance" value = "120000.2309" />
	<p>Currency in USA :
         <fmt:setLocale value = "en_US"/>
         <fmt:formatNumber value = "${balance}" type = "currency"/>
     </p>
     
     <!-- Fragment -->
     <h5>fragment include: </h5>
     <%@ include file="./fragment.jsp" %>
	<script><%@ include file="./script.js" %></script>
</body>