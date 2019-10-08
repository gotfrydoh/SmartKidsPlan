<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
	<title>List Groups</title>
	
	<!-- reference our style sheet -->

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Group Manager</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
		
			<!-- put new button: Add Child -->
		
			<input type="button" value="Add Group"
				   onclick="window.location.href='showFormForAdd'; return false;"
				   class="add-button"
			/>

			<!--  add a search box -->
			<form:form action="search" method="GET">
                Search group: <input type="text" name="theSearchName" />

				<input type="submit" value="Search" class="add-button" />
			</form:form>

			<!--  add our html table here -->
		
			<table>
				<tr>
					<th>Teacher Name</th>
					<th>Day of week</th>
					<th>Start Time</th>
					<th>End Time</th>
				</tr>
				
				<!-- loop over and print our customers -->
				<c:forEach var="tempGroup" items="${groups}">
					
					<tr>
						<td> ${tempGroup.teacher.lastName} ${tempGroup.teacher.firstName}</td>
						<td> ${tempGroup.dayOfWeek}</td>
						<td> ${tempGroup.startTime}</td>
						<td> ${tempGroup.endTime}</td>
						
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