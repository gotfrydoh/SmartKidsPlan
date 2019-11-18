<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
	<title>List Requests</title>
	
	<!-- reference our style sheet -->

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Requests of particular register</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
		
			<!-- put new button: Add Parent -->
		

			<!--  add our html table here -->
		
			<table>
				<tr>
					<th>Start Time</th>
					<th>End Time</th>
					<th>Date</th>
					<th>Caretaker</th>
				</tr>
				
				<!-- loop over and print our customers -->
				<c:forEach var="tempRequest" items="${requests}">
					
			

					<tr>
						<td> ${tempRequest.startTime}</td>
						<td> ${tempRequest.endTime}</td>
						<td> ${tempRequest.dateOfAttendance}</td>
						<td> ${tempRequest.caretaker.firstName} ${tempRequest.caretaker.lastName}</td>
						
						
					</tr>
				
				</c:forEach>
						
			</table>
				
		</div>
	
	</div>
	<p>
		<a href="${pageContext.request.contextPath}">Dashboard</a>
	</p>

</body>

</html>