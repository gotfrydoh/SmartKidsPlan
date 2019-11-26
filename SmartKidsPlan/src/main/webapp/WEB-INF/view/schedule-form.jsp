<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>

<head>
<title>Save Request</title>
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/caretaker-form.css">



</head>

<body>
	<!-- Navigation -->
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container">
			<a class="navbar-brand" href="${pageContext.request.contextPath}">SmartKidsPlan</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarResponsive" aria-controls="navbarResponsive"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item active"><a class="nav-link"
						href="${pageContext.request.contextPath}">Home <span
							class="sr-only">(current)</span>
					</a></li>
					<li class="nav-item"><a class="nav-link"
						href="${pageContext.request.contextPath}/teacher/list">Teachers</a>
					</li>
					<li class="nav-item"><a class="nav-link"
						href="${pageContext.request.contextPath}/caretaker/list">Caretakers</a>
					</li>
					<li class="nav-item"><a class="nav-link"
						href="${pageContext.request.contextPath}/register/list">Registers</a>
					</li>
					<li class="nav-item"><a class="nav-link"
						href="${pageContext.request.contextPath}/request/list">Requests</a>
					</li>
					<li class="nav-item"><a class="nav-link"
						href="${pageContext.request.contextPath}/schedule/list">Schedules</a>
					</li>
				</ul>
			</div>
		</div>
	</nav>



	<form:form action="saveSchedule" modelAttribute="schedule"
		method="POST" class="main-form needs-validation"
		novalidate="novalidate">

		<!-- need to associate this data with customer id -->
		<form:hidden path="id" />
		<div class="form-group">
			<label for="name">Name</label>
			<form:input type="text" name="name" id="name" class="form-control"
				path="name" required="required" />
			<div class="invalid-feedback">Please enter valid name</div>
		</div>
		<div class="form-group">
			<label for="name">Description</label>
			<form:input type="text" name="description" id="description"
				class="form-control" path="description" required="required" />
			<div class="invalid-feedback">Please enter valid description</div>
		</div>
		<div class="row">
			<div class="col">
				<div class="form-group">
					<label for="starttime">Start Time</label>
					<form:input type="text" name="starttime" id="starttime"
						class="form-control" path="startTime" required="required" />
					<div class="invalid-feedback">Please enter valid start time</div>
					<small>Time format HH:MM</small>
				</div>
			</div>
			<div class="col">
				<div class="form-group">
					<label for="name">End Time</label>
					<form:input type="text" name="endtime" id="endtime"
						class="form-control" path="endTime" required="required" />
					<div class="invalid-feedback">Please enter valid end time</div>
					<small>Time format HH:MM</small>
				</div>
			</div>
		</div>

		<div class="form-group">
			<label for="dayofweek">Day of week</label>
			<form:select name="dayofweek" id="dayofweek" class="form-control"
				path="dayOfWeek">
				<form:option value="2" label="Monday" />
				<form:option value="3" label="Tuesday" />
				<form:option value="4" label="Wednesday" />
				<form:option value="5" label="Thursday" />
				<form:option value="6" label="Friday" />
			</form:select>
		</div>
		<div class="form-group">
			<label for="teacher">Teacher</label>
			<form:select name="teacher" path="teacher.id" id="teacher"
				class="form-control">
				<c:forEach var="tempTeacher" items="${teachers}">
					<form:option value="${tempTeacher.id}"
						label="${tempTeacher.firstName} ${tempTeacher.lastName}" />
				</c:forEach>
			</form:select>
		</div>

		<button type="submit" class="btn btn-primary">Submit</button>
		<a class="btn btn-primary"
			href="${pageContext.request.contextPath}/schedule/list" role="button">Back
			to list</a>



	</form:form>



	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>


	<script>
		var form = document.querySelector('.needs-validation');

		form.addEventListener('submit', function(event) {
			if (form.checkValidity() === false) {
				event.preventDefault();
				event.stopPropagation();
			}
			form.classList.add('was-validated');
		})
	</script>

</body>

</html>
