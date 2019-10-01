<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<title>List Customers</title>

<!-- reference our style sheet -->

<link type="text/css" rel="stylesheet"
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
					
					<c:url var="removeChildFromCaretakerLink" value="/caretaker/removeChildFromCaretaker">
						<c:param name="childId" value="${tempChild.id }" />
						<c:param name="caretakerId" value="${theCaretakerId.id}" />
					</c:url>
					
					<tr>
						<td>${tempChild.firstName}</td>
						<td>${tempChild.lastName}</td>
						<td>${tempChild.pesel}</td>
						<td>${tempChild.dateOfBirth}</td>
						<td>
							<!-- displaying the delete link  -->
							<a href="${removeChildFromCaretakerLink}" onclick="if (!(confirm('Are you sure you want to delete this child from this particular caretaker?'))) return false">Remove</a>
					
						</td>
					</tr>

				</c:forEach>

			</table>

			<div style=""></div>

			<div id="wrapper">
				<div id="header">
					<h2>All Children</h2>
				</div>
			</div>

			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>PESEL</th>
					<th>Date of birth</th>
					<th>Action</th>
				</tr>
				
				
				<!-- loop over and print our children -->
				<c:forEach var="tempChild" items="${availableChildren}">
				
				
					
					<!-- construct delete link with child id -->
					<c:url var="addChildToCaretakerLink" value="/caretaker/addChildToCaretaker">
						<c:param name="childId" value="${tempChild.id }" />
						<c:param name="caretakerId" value="${theCaretakerId.id}" />
					</c:url>

					<tr>
						<td> ${tempChild.firstName}</td>
						<td> ${tempChild.lastName}</td>
						<td> ${tempChild.pesel}</td>
						<td> ${tempChild.dateOfBirth}</td>
						<td>
							<!-- displaying the update link  -->
							<a href="${addChildToCaretakerLink}" onclick="if (!(confirm('Are you sure you want to add this child to this particular caretaker?'))) return false">Add</a>
					
						</td>
						
					</tr>
				
				</c:forEach>
				
			</table>


		</div>

	</div>





</body>

</html>