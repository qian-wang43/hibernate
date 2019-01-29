<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="HomeController">
First Name: <input type="text" name="firstName" /><br />
Last Name: <input type="text" name="lastName" /><br />
Email: <input type="text" name="email" /><br />
Phone Number: <input type="text" name="phone" /><br />
<input type="submit" value="Go!" />
</form>



<form method="post" action="HomeController">
First Name: <input type="text" name="firstName1" /><br />
Last Name: <input type="text" name="lastName1" /><br />
<input type="hidden" name="query" value="true" />
<input type="submit" value="Go!" />
</form>



</body>
</html>