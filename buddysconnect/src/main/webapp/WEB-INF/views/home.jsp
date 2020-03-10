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
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.7.1.min.js"></script>
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
<script type="text/javascript">
	$(document).ready(function(){
		document.getElementById("main").style.display = "none";
	});
	let main = document.querySelector('main');

	function searchUser(input){
	    //console.log(input.value);
	    let userInput = input.value;
	    	   
	    let friends = document.querySelectorAll('.friend');

	    //console.log(products)

	    friends.forEach(friend => {
	    	document.getElementById("main").style.display = "block";
	        let email = friend.querySelector('span').innerText;

	        if((email).includes(userInput)){
	            friend.style.display = 'block';
	        }else{
	            friend.style.display = 'none';
	        }
	    }) 
	}
</script>
<body>

	<h1>Welcome ${name}</h1>
	<a href="/logout">logout</a>&nbsp;&nbsp;
	<a href="/updatePassword">Update Password</a>&nbsp;&nbsp;
	<a href="/deleteAccount">Delete Account</a>
	<form class="form-inline" id="searchForm" name="searchForm"
		action="posts" method="post">
		<input class="form-control mr-sm-2" type="search"
			onkeyup="searchUser(this)" placeholder="Search" aria-label="Search">
		<main id="main" style="display: none;">
			<c:forEach items="${addFriendList}" var="user">
				<div id="myModal" class="friend">
					<span>${user}</span> <a href="/addFriend/${user}">Add Friend</a>
					<!-- <button id="remove">Remove</button>
	                        <button id="block">Block</button> -->
				</div>
			</c:forEach>
		</main>
		<div class="Container">

			<article>
				<h2>Friends requests</h2>
				<table>
					<tbody>
						<c:forEach items="${friendsRequestList}" var="friendRequest">
							<tr>
								<td>${friendRequest}</td>
								<td><a href="/confirmFriendRequest/${friendRequest}">Confirm</a></td>
								<td><a href="/removeFriendRequest/${friendRequest}">Delete Request</a></td>
							</tr>
						</c:forEach>

					</tbody>
				</table>
			</article>
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
								<td><a href="/removeFriend/${friend}">Remove</a></td>
							</tr>
						</c:forEach>

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
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="${contextPath}/js/bootstrap.min.js"></script>
</body>
</html>