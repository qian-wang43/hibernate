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

<h1>Create a new person</h1>
<form method="post" action="HomeController">
First Name: <input type="text" name="firstName" /><br />
Last Name: <input type="text" name="lastName" /><br />
Email: <input type="text" name="email" /><br />
Phone Number: <input type="text" name="phone" /><br />
<input type="submit" value="Go!" />
</form>


<h1>Query the phone number by name</h1>
<form method="post" action="HomeController">
First Name: <input type="text" name="firstName1" /><br />
Last Name: <input type="text" name="lastName1" /><br />
<input type="hidden" name="query" value="true" />
<input type="submit" value="Go!" />
</form>

<c:if test="${requestScope.mode=='create'}">
	<c:forEach var="item" items="${requestScope.personList}">
	<h2>${item.email} ${item.firstName} ${item.lastName} ${item.phone}</h2>
	</c:forEach>

</c:if>
<c:if test="${requestScope.mode=='query'}">
	<c:if test="${requestScope.personList.size()!=0}">
		<c:forEach var="item" items="${personList}">
			<h2>The phone number of the person queried is ${item.phone}</h2>
		</c:forEach>
	
	</c:if>
	
	<c:if test="${requestScope.personList.size()==0}">
			<h2>No such person</h2>
	</c:if>
</c:if>



</body>
</html>