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
<link rel="stylesheet" type="text/css" href="/css/style.css">

<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<meta charset="ISO-8859-1">
<title>Insta-Whip</title>
</head>
<body background="https://res.cloudinary.com/dsujedvyp/image/upload/v1656457001/MyPhoto/Road_fqeud8.jpg" class="background">

	<div class="container">
		<div class="d-flex justify-content-between borderbtm header p-2 mb-4">
			<div>
				<h1 class="hcolor"><a href="/dashboard" class="defaultInst">Insta-Whip</a></h1>
			</div>
			<div>
				<h1 class="nameColor">Post Your Whip</h1>
			</div>	
			<div>
				<a href="/dashboard" class=" button btn btn-primary ">Dashboard</a>
				<a href="/logout" class="button btn btn-danger button">Logout</a> 
			</div>
		</div>
		<div class="d-flex justify-content-center">
			<div class="w-50 whiteb p-2">
				<form:form action="/cars/create" method="post" modelAttribute="car"
					class="form-group" enctype="multipart/form-data">
					<div>
						<form:label path="year" class="bold">Year: </form:label>
						<form:input path="year" type="number" class="form-control"
							min="1900" max="2023" />
						<form:errors path="year" class="text-danger" />
					</div>
					<div class="form-group">
						<form:label path="make" class="bold">Make: </form:label>
						<form:input type="text" path="make" class="form-control" />
						<form:errors path="make" class="text-danger" />
					</div>
					<div class="form-group">
						<form:label path="model" class="bold">Model: </form:label>
						<form:input type="text" path="model" class="form-control" />
						<form:errors path="model" class="text-danger" />
					</div>
					<div class="form-group">
						<form:label path="description" class="bold">Description: </form:label>
						<form:input type="text" path="description" class="form-control" />
						<form:errors path="description" class="text-danger" />
					</div>
					<div>
						<form:label path="type" class="bold">Select Type From Dropdown: </form:label>
						<form:select path="type" name="type" value="${car.type}" class="form-control">
							<form:option value="Daily Whip" class="bold"> Daily Whip (default) </form:option>
							<form:option value="Weekend Whip" class="bold"> Weekend Whip </form:option>
							<form:option value="Project Whip" class="bold"> Project Whip </form:option>
						</form:select>							
					</div>
					<div class="form-group">
						<form:label path="file"  class="bold">Upload a Photo</form:label>
						<form:input type="file" path="file" id="inpFile" class="form-control" />
						<p>*Photo Required</p>
					</div>
					<div class="form-group mt-2">
						<a href="/dashboard" class="btn btn-primary">Cancel</a>
						<button type="submit" class="btn btn-primary" class="text-danger">Submit</button>
					</div>
				</form:form>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="/js/app.js"></script>
</body>
</html>