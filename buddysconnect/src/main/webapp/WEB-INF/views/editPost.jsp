<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

</head>
<body>
<h3>edit content of the post</h3>
 
  <form method="post" action="/updatePost/${postId}">
  <placeholder>previous content of the post is : ${content}</placeholder>
  <input type="text" name="updatedContent"></input>
  <input type="submit">
  </form>
 
</body>
</html>