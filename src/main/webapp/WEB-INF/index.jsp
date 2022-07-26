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

<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="/css/style.css">
<meta charset="ISO-8859-1">
<title>InstaWhip</title>
</head>
<body background="https://res.cloudinary.com/dsujedvyp/image/upload/v1656457001/MyPhoto/Road_fqeud8.jpg" class="background">
<div class="container p-2">
	<h1 class="text-center hcolor mb-5">Insta-Whip</h1>

	<div class="d-flex justify-content-between">
		<div class="register col-5 whiteb p-2">
			<form:form action="/register" method="post" modelAttribute="newUser" class="form-group">
				<h2  class="bold">Register</h2>
				<div class="form-group">
					<form:label path="firstName" class="bold">First Name: </form:label>
					<form:input type="text" path="firstName" class="form-control"/>
					<form:errors path="firstName" class="text-danger"/>
				</div>
				<div class="form-group">
					<form:label path="lastName" class="bold">Last Name: </form:label>
					<form:input type="text" path="lastName" class="form-control"/>
					<form:errors path="lastName" class="text-danger"/>
				</div>
				<div class="form-group">
					<form:label path="email" class="bold">Email: </form:label>
					<form:input type="email" path="email" class="form-control"/>
					<form:errors path="email" class="text-danger"/>
				</div>				
				<div class="form-group">
					<form:label path="password" class="bold">Password: </form:label>
					<form:input type="password" path="password" class="form-control"/>
					<form:errors path="password" class="text-danger"/>
				</div>
				<div class="form-group mb-2">
					<form:label path="confirmPassword" class="bold">Confirm Password: </form:label>
					<form:input type="password" path="confirmPassword" class="form-control"/>
					<form:errors path="confirmPassword" class="text-danger"/>
				</div>
				<input type="submit" value="Register" class="btn btn-primary" />
			</form:form>
		</div>
		<div class="login col-5 whiteb p-2">
			<form:form action="/login" method="post" modelAttribute="newLogin">
				<h2 class="bold">Login</h2>
				<div class="form-group">
					<form:label path="email" class="bold">Email: </form:label>
					<form:input type="email" path="email" class="form-control"/>
					<form:errors path="email" class="text-danger"/>
				</div>				
				<div class="form-group mb-2">
					<form:label path="password"  class="bold">Password: </form:label>
					<form:input type="password" path="password" class="form-control"/>
					<form:errors path="password" class="text-danger"/>
				</div>			
				<input type="submit" value="Login" class="btn btn-primary"/>			
			</form:form> 
		</div>
	</div>
	<h3 class="text-danger"><c:out value="${error}"/></h3>
</div>

<script type="text/javascript" src="/js/app.js"></script>
</body>
</html>