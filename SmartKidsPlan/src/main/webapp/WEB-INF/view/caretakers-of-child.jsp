<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
	<title>List Caretakers</title>
	
	<!-- reference our style sheet -->

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Caretakers of particular child </h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
		

			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>PESEL</th>
					<th>Phone number</th>
				</tr>
				
				
				<c:forEach var="tempCaretaker" items="${caretakersOfChild}">
					

					<tr>
						<td> ${tempCaretaker.firstName}</td>
						<td> ${tempCaretaker.lastName}</td>
						<td> ${tempCaretaker.pesel}</td>
						<td> ${tempCaretaker.phoneNumber}</td>
						
					</tr>
				
				</c:forEach>
						
			</table>
				
		</div>
	
	</div>
	

</body>

</html>