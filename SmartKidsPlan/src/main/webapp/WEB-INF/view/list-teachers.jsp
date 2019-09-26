<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
	<title>List Teachers</title>
	
	<!-- reference our style sheet -->

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>TRM - Teachers Relationship Manager</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
		
			<!-- put new button: Add Child -->
		
			<input type="button" value="Add Teacher"
				   onclick="window.location.href='showFormForAdd'; return false;"
				   class="add-button"
			/>

			<!--  add a search box -->
			<form:form action="search" method="GET">
                Search teacher: <input type="text" name="theSearchName" />

				<input type="submit" value="Search" class="add-button" />
			</form:form>

			<!--  add our html table here -->
		
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>PESEL</th>
					<th>Action</th>
				</tr>
				
				<!-- loop over and print our customers -->
				<c:forEach var="tempTeacher" items="${teachers}">
					
					<!-- construct an update link with child id -->
					<c:url var="updateLink" value="/teacher/showFormForUpdate">
						<c:param name="teacherId" value="${tempTeacher.id }"/>
					</c:url>
					
					<!-- construct delete link with child id -->
					<c:url var="deleteLink" value="/teacher/delete">
						<c:param name="teacherId" value="${tempTeacher.id }" />
					</c:url>

					<tr>
						<td> ${tempTeacher.firstName}</td>
						<td> ${tempTeacher.lastName}</td>
						<td> ${tempTeacher.pesel}</td>
						<td>
							<!-- displaying the update link  -->
							<a href="${updateLink}">Update</a>
							|
						<a href="${deleteLink}"
							   onclick="if (!(confirm('Are you sure you want to delete this teacher?'))) return false">Delete</a>
						</td>
						
					</tr>
				
				</c:forEach>
						
			</table>
				
		</div>
	
	</div>
	

</body>

</html>