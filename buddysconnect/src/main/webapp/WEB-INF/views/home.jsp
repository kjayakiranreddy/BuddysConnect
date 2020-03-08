<%@page import="org.springframework.ui.Model"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
body {
	background-color: lightblue;
}

article {
	display: inline-block;
	vertical-align: top;
	margin: 10px;
	padding: 10px;
	border: 1px solid Olive;
	border-radius: 15px;
	width: 30%;
	text-align: left;
}
</style>
<body>

	<h1>Welcome ${name}</h1>
	<a href="/logout">logout</a>
	<form class="form-inline" id="searchForm" name="searchForm"
		action="posts" method="post">
		<input class="form-control mr-sm-2" type="search"
			onkeyup="searchUser(this)" placeholder="Search" aria-label="Search">
		<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
		<div class="Container">
<!-- 			<article>
				<img alt="" src=".../images/man.png"> <input type="button"
					name="friendReq" id="friendReq"> <input type="button"
					name="messages" id="messages"> <input type="button"
					name="notification" id="notification"> <input type="button"
					name="feed" id="feed">
			</article> -->
			<article>
			<a href="friends">Users</a>
			</article>
			<article>
				<h2>Friends</h2>
				<table>
					<thead>
						<tr>
							<th>Friend</th>
							<th>Status</th>
						</tr>
					</thead>
					<tbody>
				<%-- <c:forEach items="${listFriends}" var="friend">
					<tr>
				    
				     <td>${friend.relatedUserEmail}</td>  
				     <td>${friend.status}</td>
				   
					
					</tr>
				</c:forEach> --%>
				</tbody>
				</table>
			</article>
			<article>
				<h2>Post a Comment</h2>
				<a href="postPage">Post</a>
			</article>
			<article>
				<h2>Your Posts</h2>
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
			</article>
		</div>
	</form>
</body>
</html>