<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<title>List Requests</title>
 <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
 <link rel="stylesheet" href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css">
 <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/list-caretakers.css" />


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
	
	
	
	<div class="container" id="table-container">
		<div id="toolbar">
				<button id="add-caretaker-btn" type="button" class="btn btn-outline-primary" onclick="window.location.href='showFormForAdd'; return false;">Add Request</button>
		</div>
	
		<table class="table table-striped table-bordered mydatatable" style="width: 100%">
			<thead>
				<tr>
					<th>Start Time</th>
					<th>End Time</th>
					<th>Date</th>
					<th>Caretaker</th>
					<th>Action</th>
				</tr>
			
			</thead>
			<tbody>
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
			</tbody>
			<tfoot>
					<tr>
					<th>Start Time</th>
					<th>End Time</th>
					<th>Date</th>
					<th>Caretaker</th>
					<th>Action</th>
				</tr>
			</tfoot>
		</table>
	</div>



<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

<script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js"></script>
<script>
	$('.mydatatable').DataTable({
		lengthMenu: [[50,100,250,-1],[50,100,250,"All"]],
	});
</script>

</body>

</html>