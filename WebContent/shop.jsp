<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
</head>
<body>

<h1>Shopping cart</h1>
<ul>
    <c:forEach items="${items}" var="cartItem">
        <li><c:out value="${cartItem}" /></li>
    </c:forEach>
</ul>
<a href="shop.html">I want to continue shopping</a>
</body>
</html>