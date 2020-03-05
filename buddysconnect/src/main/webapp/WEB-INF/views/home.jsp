<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
body{
	background-color : lightblue;
}
article{
	display: inline-block;
	vertical-align:top;
	margin: 10px;
	padding:10px;
	border: 1px solid Olive;
	border-radius:15px;
	width: 30%;
	text-align: left;	
}
</style>
<body>

	Welcome Aliens.. 
	<a href="/logout">logout</a>
	<form class="form-inline" id="searchForm" name="searchForm" action="searchUser" method="post">
      <input class="form-control mr-sm-2" type="search" onkeyup="searchUser(this)" placeholder="Search"
        aria-label="Search">
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
      <div class="Container">
      	<article>
      		<img alt="" src=".../images/man.png">
      		<input type="button" name="friendReq" id="friendReq">
      		<input type="button" name="messages" id="messages">
      		<input type="button" name="notification" id="notification">
      		<input type="button" name="feed" id="feed">
      	</article>
      	<article>
      		<h2>Friends</h2>
      	</article>
      	<article>
      	<h2>Post a Comment</h2>
      	<textarea></textarea>
      	<input type="submit" name="post" value="Add Post">
      	</article>
      	<article>
      	<h2>Your Posts</h2>
      	</article>
      </div>
    </form>
</body>
</html>