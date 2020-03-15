<%@page import="org.springframework.ui.Model"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/home.css" />
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.7.1.min.js"></script>
<script src="/js/home.js" type="text/javascript"></script>
<meta charset="ISO-8859-1">
<title>View Friend Profile Here</title>
</head>
<body>
	<div id="main-container" >
		<header id="header">
			<section >
				<a href="/" style="color: white"><img src="/images/user.png" width="30" />Click to My profile</a>
			</section>

		</header>
	</div>
	<div>
	<div class="container">
		<article>
			<h2>Friends</h2>
			<table>
				<thead>
					<tr>
						<th>Friend</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${friendsList}" var="friend">
						<tr>
							<td>${friend}</td>
							<td><a href="/viewFriendProfile/${friend}">View Profile</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</article>
		<h2>Your Posts</h2>
		<c:forEach items="${posts}" var="post">
			<div class="posts${post.postId}">
				<span class="userName">${post.user.name}</span> <span
					id="creation_date">${post.postDate}</span> <img
					src="/images/${post.imagePath}" width="50px" height="50px"> <span
					class="post_content">${post.content}</span>
				<div class="dropdown">
					<div class="dropbtn">
						<img src="/images/setting.png" height="10px" width="10px">
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
</div>
</body>
</html>