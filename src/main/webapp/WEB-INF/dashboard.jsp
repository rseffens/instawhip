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

	<div class="container">
		<div class="d-flex justify-content-between borderbtm header p-2">
			<div>
				<h1 class="hcolor">Insta-Whip</h1>
			</div>
			<div>
				<h1 class="hcolor">Hello ${user.firstName}</h1>
			</div>	
			<div>
				<a href="/cars/new" class="btn btn-primary button ">Create a Post!</a>
				<a href="/dashboard" class=" button btn btn-primary ">Dashboard</a>
				<a href="/logout" class="button btn btn-danger button">Logout</a> 
			</div>
		</div>
		<div class="d-flex flex-wrap justify-content-around">
			<c:forEach var="cars" items="${car}">
			<div class="p-4">
					<div>
						<a href="/cars/${cars.id}"><img src="${cars.file}"
							class="img-thumbnail thumbnail icon" /></a><br />
					</div>
			</div>		
			</c:forEach>
		</div>

	</div>
	
	<script type="text/javascript" src="/js/app.js"></script>
</body>
</html>