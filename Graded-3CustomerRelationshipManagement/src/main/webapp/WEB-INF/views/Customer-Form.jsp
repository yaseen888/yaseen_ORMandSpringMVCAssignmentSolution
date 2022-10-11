<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">

<title>Save Customer</title>
</head>

<body>

	<div class="container">

		<h1 style="text-align: center; background-color: Teal;">Customer
			Relationship Management</h1>
		<hr>
		<br> <br>

		<p class="h4 mb-4">Save Customer</p>

		<form action="/Graded-3CustomerRelationshipManagement/customer/save"
			method="POST">

			<!-- Add hidden form field to handle update -->
			<input type="hidden" name="id" value="${Customer.id}" />



			<div class="form-inline">

				First Name:&nbsp; &nbsp; <input type="text" name="FirstName"
					value="${Customer.firstName}">

			</div>
			<br>


			<div class="form-inline">

				Last Name:&nbsp; &nbsp; <input type="text" name="LastName"
					value="${Customer.lastName}">

			</div>
			<br>

			<div class="form-inline">

				E-mail:&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; <input type="text"
					name="Email" value="${Customer.email}">

			</div>
			<br>

			<button type="submit" class="btn btn-info col-2">Save</button>

		</form>

		<hr>
		<a href="/Graded-3CustomerRelationshipManagement/customer/list">Back
			to List</a>

	</div>
</body>
</html>