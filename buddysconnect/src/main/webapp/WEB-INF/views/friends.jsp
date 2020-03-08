<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Of Users</title>
<link href="${contextPath}/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${contextPath}/css/common.css" rel="stylesheet">
</head>
<body>
<div>
	<form:form method="users" modelAttribute="friendsForm" class="">
	<table>
		<thead>
			<tr>
				<th>Post Content</th>
				<th>Image</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${posts}" var="post">
				<tr>
					<td>${post.content}</td>
					<td>${post.imagePath}</td>
					<td><input type="button" name="like" Value="Like"></td> 
					<td><c:url value="/editPost/${post.postId}">Edit</c:url></td>
					<td><input type="button" name="delete" Value="Delete"></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</form:form>
</div>	
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="${contextPath}/js/bootstrap.min.js"></script>
</body>
</html>