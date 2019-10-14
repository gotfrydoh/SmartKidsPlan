<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>

<head>
<title>Save Group</title>

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Group Manager</h2>
		</div>
	</div>

	<div id="container">
		<h3>Save Group</h3>

		<form:form action="saveGroup" modelAttribute="group" method="POST">

			<!-- need to associate this data with group id -->
			<form:hidden path="id" />
			
			<table>
				<tbody>
					<tr>
						<td><label>Day of week:</label></td>
						<td><form:select path="dayOfWeek">
								<form:option value="0" label="Monday" />
								<form:option value="1" label="Tuesday" />
								<form:option value="2" label="Wednesday" />
								<form:option value="3" label="Thursday" />
								<form:option value="4" label="Friday" />
							</form:select></td>
					</tr>

					<tr>
						<td><label>Start Time:</label></td>
						<td><form:input path="startTime" /></td>
					</tr>

					<tr>
						<td><label>End Time:</label></td>
						<td><form:input path="endTime" /></td>
					</tr>

					<tr>
						<td><label>Teacher:</label></td>
						<td>
						
							<form:select path="teacher.id">
								<c:forEach var="tempTeacher" items="${teachers}">
									<form:option value="${tempTeacher.id}" label="${tempTeacher.firstName} ${tempTeacher.lastName}" />
								</c:forEach>
								
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
			<a href="${pageContext.request.contextPath}/group/list">Back to
				List</a>
		</p>

	</div>

</body>

</html>
