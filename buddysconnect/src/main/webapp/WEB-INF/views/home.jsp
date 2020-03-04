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
	color : lightblue;
}
</style>
<body>

	Welcome Aliens.. 
	<a href="/logout">logout</a>
	<form class="form-inline" id="searchForm" name="searchForm" action="searchUser" method="post">
      <input class="form-control mr-sm-2" type="search" onkeyup="searchUser(this)" placeholder="Search"
        aria-label="Search">
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
      <div class="COntainer">
      	
      </div>
    </form>
</body>
</html>