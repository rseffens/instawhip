<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isErrorPage="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />

<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="/css/style.css">
<meta charset="ISO-8859-1">
<title>Insta-Whip</title>
</head>
<body background="https://res.cloudinary.com/dsujedvyp/image/upload/v1656457001/MyPhoto/Road_fqeud8.jpg" class="background">

	<div class="container p-2">
		<div class="d-flex justify-content-between mb-4">
			<div>
				<h1 class="hcolor"><a href="/dashboard" class="defaultInst">Insta-Whip</a></h1>
			</div>
			<div>
				<h1 class="mt-1 hcolor">Edit your ${car.make}</h1>
			</div>
			<div>
				<a href="/dashboard" class="mb-3 button btn btn-primary">Dashboard</a>
				<a href="/logout" class="mb-3 button btn btn-danger">Logout</a> 
			</div>
		</div>
		
		<div class="d-flex justify-content-between">
			<div class="whiteb m-1 p-2">
				<h3 class="mb-3 text-center">Preview of your Whips Information</h3>
				<div class="strongBorder p-2">
				<h4 class="text-center mb-5">Welcome to ${car.user.firstName}'s ${car.type}</h4>
					<div class="d-flex justify-content-around  class="w-55"">
						<div>
						<img src="${car.file}" class="img-thumbnail thumbnail2 p-2" />
						</div>
						<div class="m-2">
						<span class="text-center"><c:out value="${car.description}" /></span>
						<p class="mr-2">${car.type}</p>
						</div>
					</div>
				</div>
			</div>
			<div class="w-40 m-1 whiteb p-2">
				<form:form action="/cars/${car.id}/update" method="post"
					modelAttribute="car" class="form-group"
					enctype="multipart/form-data">
					<input type="hidden" name="_method" value="put">
					<div>
						<form:label path="year" class="bold">Year: </form:label>
						<form:input path="year" type="number" class="form-control"
							min="1900" max="2023" value="${car.year}" />
						<form:errors path="year" class="text-danger" />
					</div>
					<div class="form-group">
						<form:label path="make" class="bold">Make: </form:label>
						<form:input type="text" path="make" class="form-control"
							value="${car.make}" />
						<form:errors path="make" class="text-danger" />
					</div>
					<div class="form-group">
						<form:label path="model" class="bold">Model: </form:label>
						<form:input type="text" path="model" class="form-control"
							value="${car.model}" />

					</div>
					<div class="form-group">
						<form:label path="description" class="bold">Description: </form:label>
						<form:input type="text" path="description" class="form-control"
							value="${car.description}" />
						<form:errors path="description" class="text-danger" />
					</div>
					<div class="form-group">
						<form:label path="type" class="bold">Select Type From Dropdown: </form:label>
						<form:select path="type" name="type" value="${car.type}"
							class="form-control">
							<form:option value="Daily Whip" class="bold"> Daily Whip (default) </form:option>
							<form:option value="Weekend Whip" class="bold"> Weekend Whip </form:option>
							<form:option value="Project Whip" class="bold"> Project Whip </form:option>
						</form:select>
					</div>
					<form:hidden path="id" value="${car.id}"/>
					<div class="form-group">
						<form:label path="file" class="bold">Upload Photo:</form:label>
						<form:input type="file" path="file" class="form-control" />
					</div>
					<div class="d-flex justify-content-between">
					<div class="form-group mt-2">
						<button type="submit" class="btn btn-primary" class="text-danger">Submit</button>
					</div>
				</form:form>
					<div class="d-flex">
						<div class="p-2">
							<a href="/dashboard" class="btn btn-primary">Cancel</a>
						</div>
						<div class="mt-2">
						<form action="/cars/${id}/delete" method="post">
							<input type="hidden" name="_method" value="delete"> <input
								type="submit" value="Delete" class="btn btn-danger mr-3">
						</form>
						</div>
					</div>	
				</div>
			</div>
		</div>

<script type="text/javascript" src="/js/app.js"></script>
</body>
</html>