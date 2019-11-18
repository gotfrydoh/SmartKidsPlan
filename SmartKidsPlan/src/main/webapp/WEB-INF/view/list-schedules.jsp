<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
	<title>List Schedules</title>
	
	<!-- reference our style sheet -->

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Schedules Manager</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
		
		
			<input type="button" value="Add Schedule"
				   onclick="window.location.href='showFormForAdd'; return false;"
				   class="add-button"
			/>
			

			<!--  add a search box -->
			<form:form action="search" method="GET">
                Search schedule: <input type="text" name="theSearchName" />

				<input type="submit" value="Search" class="add-button" />
			</form:form>

			<!--  add our html table here -->
		
			<table>
				<tr>
					<th>Name</th>
					<th>Description</th>
					<th>Start Time</th>
					<th>End Time</th>
					<th>Day of week</th>
					<th>Teacher</th>
					<th>Action</th>
				</tr>
				
				<!-- loop over and print our customers -->
				<c:forEach var="tempSchedule" items="${schedules}">
					
					<!-- construct an update link with child id -->
					<c:url var="updateLink" value="/schedule/showFormForUpdate">
						<c:param name="scheduleId" value="${tempSchedule.id }"/>
					</c:url>
					
					<!-- construct delete link with child id -->
					<c:url var="deleteLink" value="/schedule/delete">
						<c:param name="scheduleId" value="${tempSchedule.id }" />
					</c:url>



					<tr>
						<td> ${tempSchedule.name}</td>
						<td> ${tempSchedule.description}</td>
						<td> ${tempSchedule.startTime}</td>
						<td> ${tempSchedule.endTime}</td>
						<td> ${tempSchedule.dayOfWeek}</td>
						<td> ${tempSchedule.teacher.firstName} ${tempSchedule.teacher.lastName}</td>
						<td>
							<!-- displaying the update link  -->
							<a href="${updateLink}">Update</a>
							|
						<a href="${deleteLink}"
							   onclick="if (!(confirm('Are you sure you want to delete this schedule?'))) return false">Delete</a>
							
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