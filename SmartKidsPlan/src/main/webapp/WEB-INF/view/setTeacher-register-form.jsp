<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>

<head>
<title>Save Register</title>

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Register Manager</h2>
		</div>
	</div>

	<div id="container">
		<h3>Save Register</h3>

		<form:form action="saveRegister" modelAttribute="register" method="POST">

			<!-- need to associate this data with group id -->
			<form:hidden path="id" />
			<form:hidden path="name" />
			<form:hidden path="description" />
			<form:hidden path="startTime" />
			<form:hidden path="endTime" />
			<form:hidden path="dateOfAttendance" />
			<table>
				<tbody>
					
					<tr>
						<td><label>Set Teacher to current Register:</label></td>
						<td>
						
							<form:select path="teacher.id">
								<c:forEach var="tempTeacher" items="${teachers}">
									<form:option value="${tempTeacher.id}" label="${tempTeacher.firstName} ${tempTeacher.lastName}" />
								</c:forEach>
									<form:option value="0" label="Brak nauczyciela" />
								
							</form:select></td>
					</tr>


					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>


				</tbody>
			</table>


		</form:form>

		<div style=""></div>

		<p>
			<a href="${pageContext.request.contextPath}/register/list">Back to
				List</a>
		</p>

	</div>

</body>

</html>