<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
	<title>List Customers</title>
	
	<!-- reference our style sheet -->

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Children of particular parent</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
		
		

			<!--  add our html table here -->
		
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>PESEL</th>
					<th>Date of birth</th>
				</tr>
				
				<!-- loop over and print our customers -->
				<c:forEach var="tempChild" items="${caretakerChildren}">
					<tr>
						<td> ${tempChild.firstName}</td>
						<td> ${tempChild.lastName}</td>
						<td> ${tempChild.pesel}</td>
						<td> ${tempChild.dateOfBirth}</td>
					</tr>
				
				</c:forEach>
						
			</table>
				
		</div>
	
	</div>
	

</body>

</html>