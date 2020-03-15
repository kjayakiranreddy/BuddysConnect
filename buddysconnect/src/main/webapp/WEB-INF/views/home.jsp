<%@page import="org.springframework.ui.Model"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:th="http://www.thymeleaf.org">
<head>
<link href="/css/post.css" rel="stylesheet" />
<link rel="stylesheet" href="/css/home.css" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.7.1.min.js"></script>
<script src="/js/home.js" type="text/javascript"></script>

<meta charset="ISO-8859-1">
<title>Buddy's Connect</title>

<style type="text/css">
</style>
</head>

<body>
	<div id="main-container">
		<header id="header">
			<!-- <section>
				<img id="fb-icon" src="/images/fb.png" width="30" />
			</section> -->
			<!-- 			<section>
				<input type="text" id="search" placeholder="Search Friend" />
			</section> -->
			<section>
				<a href="/" style="color: white"><img src="/images/user.png"
					width="30" />${name} Profile</a>
			</section>

			<!-- 			<section>
				<img src="/images/chat.png" width="30" />
			</section>
			<section>
				<img src="/images/earth.png" width="30" />
			</section> 
			<section>
				<img src="/images/setting.png" style="margin-left: 40px;" width="30" />
			</section>-->

		</header>
	</div>
	<div class="container">
		<h1>Welcome ${name}</h1>
		<a href="/logout">logout</a>&nbsp;&nbsp; <a href="/updatePassword">Update
			Password</a>&nbsp;&nbsp; <a href="/clearAccount">Clear Account</a>&nbsp;&nbsp;
		<a href="/deleteAccount">Delete Account</a>
		<form class="form-inline" id="searchForm" name="searchForm"
			action="posts" method="post">
			<input class="form-control mr-sm-2" type="search"
				onkeyup="searchUser(this)" placeholder="Search friends"
				aria-label="Search">
			<main id="main" style="display: none;">
				<c:forEach items="${usersList}" var="user">
					<div id="myModal" class="friend">
						<span>${user}</span> <a href="/addFriend/${user}">Add Friend</a>
					</div>
				</c:forEach>
			</main>
			<div class="Container">
				<h2>Friends requests</h2>
				<table>
					<tbody>
						<c:forEach items="${friendsRequestList}" var="friendRequest">
							<tr>
								<td>${friendRequest}</td>
								<td><a href="/confirmFriendRequest/${friendRequest}">Confirm</a></td>
								<td><a href="/removeFriendRequest/${friendRequest}">Delete
										Request</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<article style="border: 1px solid black">
					<h2>Friends</h2>
					<table>
						<tbody>
							<c:forEach items="${friendsList}" var="friend">
								<tr>
									<td>${friend}&nbsp;&nbsp;</td>
									<td><a href="/removeFriend/${friend}">Remove&nbsp;&nbsp;</a></td>
									<td><a href="/viewFriendProfile/${friend}">View
											Profile&nbsp;&nbsp;</a></td>
									<td><a href="/viewMessage/${friend}">Message</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</article>
				<article style="border: 1px solid black">
					<h2>Create a Post</h2>
					<a href="postPage">Click To Post</a>
				</article>
				<article style="border: 1px solid black">
					<h2>Your Posts</h2>
					<c:forEach items="${posts}" var="post">
						<div class="posts${post.postId}">
							<span class="userName">${post.user.name}&nbsp;&nbsp;</span> <span
								id="creation_date">${post.postDate}&nbsp;&nbsp;</span> <img
								src="/images/${post.imagePath}" width="50px" height="50px">&nbsp;&nbsp;
							<span class="post_content">${post.content}&nbsp;&nbsp;</span>
							<div class="dropdown">
								<div class="dropbtn">
									<img src="/images/setting.png" height="10px" width="10px">
								</div>
								<span class="caret">&nbsp;&nbsp;</span>
								<div id="myDropdown" class="dropdown-content">
									<a
										href="editPost?content=${post.content}&postId=${post.postId}">edit</a>
									<a href="deletePost?postId=${post.postId}">delete</a>
								</div>
								<%-- <a href="/like/${postId}&${name}">Like</a> --%>
							</div>
						</div>
					</c:forEach>
				</article>
				<article style="border: 1px solid black">
					<h2>Messages</h2>
					<c:forEach items="${userMessages}" var="messages">
						<div>
							<span>${messages}</span>
						</div>
					</c:forEach>
				</article>
			</div>

		</form>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="${contextPath}/js/bootstrap.min.js"></script>
</body>
</html>