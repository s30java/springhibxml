<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> Registration Form</title>
</head>
<body>
<center>
<div style="color: teal;font-size: 30px">Edit User Form</div>
<p>${message}</p>
<form:form  modelAttribute="user" commandName="user"  method="POST" action="${pageContext.request.contextPath}/user/edit/${user.id}.html">
<table width="400px" height="150px">
<tr>
<td><form:label path="firstName">First Name</form:label></td>
<td><form:input  path="firstName"/></td>
</tr>
<tr>
<td><form:label path="lastName">Last Name</form:label></td>
<td><form:input  path="lastName"/></td>
</tr>
<tr>
<td><form:label path="gender">Gender</form:label></td>
<td><form:input readonly="true" path="gender"/></td>
</tr>
<tr>
<td><form:label path="city">City</form:label></td>
<td><form:input readonly="true"  path="city"/> </td>
</tr>
<tr><td></td><td>
<input type="submit" value="Update" />
</td></tr>
</table>
</form:form>


<a href="${pageContext.request.contextPath}/userList.html" >Click Here to see User List</a>
</center>
</body>
</html>
