<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/custom.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Nouvelle annonce</h3>
	<div id="erreurDiv">
		<p name="error" id="error" >
			${error}
		</p>
	</div>
	<form action="/addannonce" method="POST">
		Titre : 
		<br>
		<input type="text" name="title" id="title" value="${title}"/>
		<br>
		Description :
		<br>
		<textarea name="description" id="description" rows="20" cols="50">${description}</textarea>
		<br>
		Date fin annonce :
		<br> 
		<input type="date" name="endingDate" id="endingDate" value="${date}" />
		<br>
		<input type="submit" />
	</form>
	<a href="/annoncelist?page=0">Afficher toutes les annonces</a>
    </body>
</html>



