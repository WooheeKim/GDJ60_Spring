<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>
<a href = "./product/list?num=1&num=2&num=3">product List</a>
<a href = "/product/list">product List</a>
<a href = "./member/memberLogin">member Login</a>
<a href = "/bankBook/list">BankBook List</a>
<a href = "./bankBook/list">BankBook List</a>

<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
