<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
	<title>List Registers</title>
	
	<!-- reference our style sheet -->

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Register Manager</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
		
		
			<input type="button" value="Add Register"
				   onclick="window.location.href='showFormForAdd'; return false;"
				   class="add-button"
			/>
			
			<input type="button" value="Update list"
				   onclick="window.location.href='updateList'; return false;"
				   class="add-button"
			/>
			
			<input type="button" value="Set Teachers"
				   onclick="window.location.href='setTeachersExtraHours'; return false;"
				   class="add-button"
			/>

			<!--  add a search box -->
			<form:form action="search" method="GET">
                Search register: <input type="text" name="theSearchName" />

				<input type="submit" value="Search" class="add-button" />
			</form:form>

			<!--  add our html table here -->
		
			<table>
				<tr>
					<th>Name</th>
					<th>Description</th>
					<th>Start Time</th>
					<th>End Time</th>
					<th>Date</th>
					<th>Teacher</th>
					<th>Action</th>
				</tr>
				
				<!-- loop over and print our customers -->
				<c:forEach var="tempRegister" items="${registers}">
					
					<!-- construct an update link with child id -->
					<c:url var="updateLink" value="/register/showFormForUpdate">
						<c:param name="registerId" value="${tempRegister.id }"/>
					</c:url>
					
					<!-- construct delete link with child id -->
					<c:url var="deleteLink" value="/register/delete">
						<c:param name="registerId" value="${tempRegister.id }" />
					</c:url>

					<c:url var="addTeacherLink" value="/register/showFormForAddTeacher">
						<c:param name="registerId" value="${tempRegister.id }" />
					</c:url>
					
					<c:url var="requestsLink" value="/register/requests">
						<c:param name="registerId" value="${tempRegister.id }" />
					</c:url>

					<tr>
						<td> ${tempRegister.name}</td>
						<td> ${tempRegister.description}</td>
						<td> ${tempRegister.startTime}</td>
						<td> ${tempRegister.endTime}</td>
						<td> ${tempRegister.dateOfAttendance}</td>
						<td> ${tempRegister.teacher.firstName} ${tempRegister.teacher.lastName}</td>
						<td>
							<!-- displaying the update link  -->
							<a href="${updateLink}">Update</a>
							|
						<a href="${deleteLink}"
							   onclick="if (!(confirm('Are you sure you want to delete this caretaker?'))) return false">Delete</a>
							|
							<a href="${addTeacherLink}">Set Teacher</a>
							|
							<a href="${requestsLink}">Requests</a>
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