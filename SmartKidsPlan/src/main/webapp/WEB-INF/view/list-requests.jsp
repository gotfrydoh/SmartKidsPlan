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
			<h2>Request Manager</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
		
			<!-- put new button: Add Parent -->
		
			<input type="button" value="Add Request"
				   onclick="window.location.href='showFormForAdd'; return false;"
				   class="add-button"
			/>

			<!--  add a search box -->
			<form:form action="search" method="GET">
                Search request: <input type="text" name="theSearchName" />

				<input type="submit" value="Search" class="add-button" />
			</form:form>

			<!--  add our html table here -->
		
			<table>
				<tr>
					<th>Start Time</th>
					<th>End Time</th>
					<th>Date</th>
					<th>Caretaker</th>
					<th>Action</th>
				</tr>
				
				<!-- loop over and print our customers -->
				<c:forEach var="tempRequest" items="${requests}">
					
					<!-- construct an update link with child id -->
					<c:url var="updateLink" value="/request/showFormForUpdate">
						<c:param name="requestId" value="${tempRequest.id }"/>
					</c:url>
					
					<!-- construct delete link with child id -->
					<c:url var="deleteLink" value="/request/delete">
						<c:param name="requestId" value="${tempRequest.id }" />
					</c:url>


					<tr>
						<td> ${tempRequest.startTime}</td>
						<td> ${tempRequest.endTime}</td>
						<td> ${tempRequest.dateOfAttendance}</td>
						<td> ${tempRequest.caretaker.firstName} ${tempRequest.caretaker.lastName}</td>
						<td>
							<!-- displaying the update link  -->
							<a href="${updateLink}">Update</a>
							|
						<a href="${deleteLink}"
							   onclick="if (!(confirm('Are you sure you want to delete this caretaker?'))) return false">Delete</a>
						</td>
						
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