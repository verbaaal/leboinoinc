<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/custom.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Liste des annonces</h1>
	<table>
		<th>Titre</th>
		<th>description</th>
		<th>date de fin de l'annonce</th>
		<c:forEach var="a" items="${annonces}">
			<tr>
				<td><c:out value=" ${a.title } " /></td>
				<td><c:out value=" ${a.description } " /></td>
				<td><c:out value=" ${a.endingDate } " /></td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<c:if test="${previouspage >= 0}">
		<a href="/annoncelist?page=${previouspage}">Page Précédente </a>
	</c:if>
	<br>
	<a href="/annoncelist?page=${nextpage}">Page Suivante </a>
	<br>
	<a href="/annonce"> Ajouter une nouvelle annonce</a>
</body>
</html>