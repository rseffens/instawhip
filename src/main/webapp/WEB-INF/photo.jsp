<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isErrorPage="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="/css/main.css"/>
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
				<h1 class="hcolor"><a href="/dashboard" class="defaultInst">Insta-Whip</a></h1>
			</div>
			<div>
				<h1 class="hcolor">Hello ${user.firstName}</h1>
			</div>	
			<div>
				<a href="/dashboard" class=" button btn btn-primary ">Dashboard</a>
				<a href="/logout" class="button btn btn-danger button">Logout</a> 
			</div>
		</div>
		<div class="mt-4 d-flex justify-content-center">
			<a href="/cars/${car.id}" class= "btn btn-primary button whiteb bold blackFont">Return to Whip</a>
		</div>
		<div  class="mt-3 d-flex justify-content-around">
				<img src="${car.file}" class="w-50 rounded mx-auto d-block">			
		</div>
	</div>


<script type="text/javascript" src="/js/app.js"></script>
</body>
</html>