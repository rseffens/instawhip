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
		<div class="d-flex justify-content-between borderbtm header p-2 mb-5">
			<div>
				<h1 class="hcolor"><a href="/dashboard" class="defaultInst">Insta-Whip</a></h1>
			</div>
			<div>
				<h1 class="nameColor"> Hello ${user.firstName} </h1>
			</div>	
			<div>
				<a href="/dashboard" class=" button btn btn-primary ">Dashboard</a>
				<a href="/logout" class="button btn btn-danger button">Logout</a> 
			</div>
		</div>
		<h1 class="text-center mb-5 hcolor">Welcome to ${car.user.firstName}'s
			${car.type}</h1>
		<div class="d-flex justify-content-between">
			<div class="mr-2">
				<a href="/cars/${car.id}/photo"><img src="${car.file}" class="img-thumbnail thumbnail1 whiteb" /></a>
			</div>
			<div class="descMinWidth  text-center center  whiteb">
				<h4 >Whip Description:</h4>			
				<div>
					<span class="align-bottom bold"><c:out value="${car.description}" /></span>
				</div>
			</div>
			<c:if test="${uuid == car.user.id }">
				<div class="center">
					<a href="/cars/${car.id}/edit" class="button btn btn-primary">Edit</a>
				</div>
			</c:if>
		</div>

		<div class="d-flex justify-content-between mt-4">
			
			
			<div class="  text-center whiteb p-2 thumbnail1">
				<h4 class="text-center">Rate the Whip</h4>
				<form:form action="/cars/${car.id}/rate" method="post" modelAttribute="rating"
				class="form-group">
				<c:if test="${uuid != car.user.id }">
				<div>
					<form:label path="score" class="bold text-center">Select Rating: </form:label><br>
						<input type="number" name="score" id="score" min="1" max="10" step="1" value="10" class="text-center"/>
				</div>
				<div class="form-group mt-2">
					<button type="submit" class="btn btn-primary ">Submit Rating</button>	
				</div>
				</c:if>
				<div class="mt-2">	
					<h5>Average Rating:
					<c:choose>
						<c:when test="${car.getRatings().size() >0}">
							(<c:out value="${car.getScore()}"/>/<c:out value="${car.getRatings().size()}"/>)
						</c:when>
						<c:otherwise>
							<c:out value="(No Ratings Yet)"/> 
						</c:otherwise>
					</c:choose>
					</h5>
					<p>Average Rating on Left / Total Votes on Right</p>
				</div>
				</form:form>					
			<c:if test="${uuid == car.user.id}">
				<p class="text-center bold">Whip's Owner Can't Rate</p>
			</c:if>
			</div>
		
			<div class="descMinWidth  text-center  center whiteb p-2">
				<h3 class="text-center">Any Comments or Recommendations for the Whip Holder?</h3>
			<c:if test="${uuid == car.user.id}">
				<p class="text-center bold">Whip's Owner Can't Comment</p>
			</c:if>	
			<c:if test="${uuid != car.user.id }">
			<form:form action="/cars/${car.id}/createReview" method="post" modelAttribute="review">
				<div class="form-group">
					<form:label path="content"> </form:label>
					<form:input type="text" path="content" class="form-control" />
					<form:errors path="content" class="text-danger" />
				</div>
				<div class="form-group">
					<button type="submit" class="btn btn-primary mt-2">Submit</button>
				</div>

			</form:form>
			</c:if>	
			</div>	
			<c:if test="${uuid == car.user.id }">
				<div class="center">
					<p>edit</p>
				</div>
			</c:if>
		</div>
		<div class="whiteb mt-4">
			<table class="table justify-content between">
				<tbody>
					<tr>
						<th>Poster:</th>
						<th class="text-center">Comment:</th>
						<th class="text-right">Time Posted</th>
					</tr>
					<c:forEach var="review" items="${car.reviews}">
						<tr>
							<td><c:out value="${review.user.firstName} ${review.user.lastName}" /></td>
							<td class="text-center"><c:out value="${review.content}" /></td>
							<td class="text-left"><c:out value="${review.createdAt}"/></td>
			
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>





	<script type="text/javascript" src="/js/app.js"></script>
</body>
</html>