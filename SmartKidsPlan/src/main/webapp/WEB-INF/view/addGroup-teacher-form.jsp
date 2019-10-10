<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<title>Add Group to teacher</title>

<!-- reference our style sheet -->

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Teacher's Groups</h2>
		</div>
	</div>

	<div id="container">

		<div id="content">



			<!--  add our html table here -->

			<table>
				<tr>
					<th>Day of week</th>
					<th>Start Time</th>
					<th>End Time</th>
					<th>Action</th>
				</tr>

				<!-- loop over and print our customers -->
				<c:forEach var="tempGroup" items="${teacherGroups}">

					<c:url var="removeGroupFromTeacherLink"
						value="/teacher/removeGroupFromTeacher">
						<c:param name="teacherId" value="${tempGroup.teacher.id }" />
						<c:param name="groupId" value="${tempGroup.id}" />
					</c:url>

					<tr>
						<td>${tempGroup.dayOfWeek}</td>
						<td>${tempGroup.startTime}</td>
						<td>${tempGroup.endTime}</td>

						<td>
							<!-- displaying the delete link  --> <a
							href="${removeGroupFromTeacherLink}"
							onclick="if (!(confirm('Are you sure you want to delete this group from this particular teacher?'))) return false">Remove</a>

						</td>
					</tr>

				</c:forEach>

			</table>

			<div style=""></div>

			<div id="wrapper">
				<div id="header">
					<h2>All available groups</h2>
				</div>
			</div>

			<table>
				<tr>
					<th>Day of week</th>
					<th>Start Time</th>
					<th>End Time</th>
					<th>Action</th>
				</tr>


				<!-- loop over and print our children -->
				<c:forEach var="tempGroup" items="${allGroups}">


					<c:url var="addGroupToTeacherLink"
						value="/teacher/addGroupToTeacher">
						<c:param name="teacherId" value="${theTeacher.id }" />
						<c:param name="groupId" value="${tempGroup.id}" />
					</c:url>

					<tr>
						<td>${tempGroup.dayOfWeek}</td>
						<td>${tempGroup.startTime}</td>
						<td>${tempGroup.endTime}</td>
						<td>
							<!-- displaying the update link  --> <a
							href="${addGroupToTeacherLink}"
							onclick="if (!(confirm('Are you sure you want to add this group to this particular teacher?'))) return false">Add</a>

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