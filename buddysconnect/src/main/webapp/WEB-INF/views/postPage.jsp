<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="ISO-8859-1">
<title>Create a Post</title>

<link href="${contextPath}/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${contextPath}/css/common.css" rel="stylesheet">
</head>
<body>
<div>
	<form:form method="post" modelAttribute="postForm" class="" enctype="multipart/form-data">
			<h2 class="form-signin-heading">Create a Post</h2>
			<spring:bind path="imagePath">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:input type="file" path="imagePath" class="form-control"
						placeholder="Upload Files" autofocus="true"></form:input>
					<form:errors path="imagePath"></form:errors>
				</div>
			</spring:bind>
			<spring:bind path="content">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:input type="text" path="content" class="form-control"
						placeholder="" autofocus="true"></form:input>
					<form:errors path="content"></form:errors>
				</div>
			</spring:bind>
			<button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
		</form:form>
		</div>
		
		<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="${contextPath}/js/bootstrap.min.js"></script>
</body>
</html>