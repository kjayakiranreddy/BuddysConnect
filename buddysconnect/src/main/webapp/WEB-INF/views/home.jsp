<%@page import="org.springframework.ui.Model"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:th="http://www.thymeleaf.org">
<head>
<link href="/css/post.css" rel="stylesheet" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">


<script src="/js/home.js" type="text/javascript"></script>
<meta charset="ISO-8859-1">
<title>Buddy's Connect</title>
</head>
<style>


#main-container {
	width: 100%;
	margin: 0px auto;
}

#header {
	width: 100%;
	background-color: #4267b2;
	padding: 10px;
	color: white;
}

#header:after {
	content: ".";
	display: block;
	height: 0;
	clear: both;
	visibility: hidden;
}
#header section>#fb-icon {
	margin-left: 140px;
}

#header section>img {
	float: left;
	margin-left: 10px;
}

#header section>input {
	float: left;
	margin-top: 0px;
	margin-left: 10px;
	margin-right: 400px;
}

#header nav {
	width: 50%;
	float: left;
}

#header nav ul {
	list-style: none;
}

#header nav ul li {
	float: left;
	min-width: 10%;
	padding: 4px;
	margin-left: 10px;
	background-color: #ffffcc;
	text-align: center;
	color: black;
}

#header nav ul li a, a {
	text-decoration: none;
}


.dropbtn {
  background-color: #3498DB;
  color: white;
  padding: 10px;
  border: none;
  cursor: pointer;
  height:15px;
width:15px;
}



.dropbtn:hover, .dropbtn:focus {
  background-color: #2980B9;
}

.dropdown {
  position: relative;
  display: inline-block;
  float: right:
}

.dropdown-content {
  display: none;
  position: absolute;
  background-color: #f1f1f1;
  min-width: 160px;
  overflow: auto;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
}

.dropdown-content a {
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
}

.dropdown a:hover {background-color: #ddd;}

.show {display: block;}

.dropdown:hover .dropdown-content {
  display: block;
}


.posts
{
    width: 50%;
    border: 1px solid blue;
    text-align: center;
    height: 250px;

}

.posts img
{
    display: inline-block;  
    border: 1px solid red;
    margin: 2px;
    height : 200px;
    width  : 250px;
}

.dropbtn img{
border:none;
height:8px;
width:8px;
}

</style>
<body>
	<div id="main-container">
		<header id="header">
			<section>
				<img id="fb-icon" src="/images/fb.png" width="30" />
			</section>

			<section>
				<input type="text" id="search" placeholder="Search Friend"
					autocomplete="off" />
			</section>
			<section>
				<img src="/images/user.png" width="30" />
			</section>
			<section>
				<img src="/images/chat.png" width="30" />
			</section>
			<section>
				<img src="/images/earth.png" width="30" />
			</section>
			<section>
				<img src="/images/setting.png" style="margin-left: 40px;" width="30" />
			</section>

		</header>
	</div>



	<h1>Welcome ${name}</h1>
	<div class="logout">
		<a href="/logout">logout</a>
	</div>
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
				<h2>Create a Post</h2>
				<a href="postPage">Post</a>
			</article>
			<c:forEach items="${posts}" var="post">
				<div class="posts${post.postId}">
					<span class="userName">${post.user.name}</span>
					 <span id="creation_date">${post.postDate}</span> 
						<img src="/images/${post.imagePath}" width="50px" height="50px">
						<span class="post_content">${post.content}</span>
						<div class="dropdown">
				<div class="dropbtn"><img src="/images/setting.png" height="10px" width="10px"></div>
						<span class="caret"></span>
					<div id="myDropdown" class="dropdown-content">
						<a href="editPost?content=${post.content}&postId=${post.postId}">edit</a>
						<a href="deletePost?postId=${post.postId}">delete</a>
					</div>
					<a href="/like/${postId}&${name}" name="like">Like</a>
					<input type="text" name="commentContent"></input>
					<a href="comment" name="comment">comment</a>
				</div>
				</div>
			</c:forEach>

		</div>
	</form>
</body>
</html>