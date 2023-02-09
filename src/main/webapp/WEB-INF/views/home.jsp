<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
	<title>Home</title>
	<link rel="stylesheet" href="./resources/css/main.css">
</head>
<body>
<h1>
	Hello world!  
</h1>
<class href = "./product/list?num=1&num=2&num=3" class="menu">product List</a>
<a href = "/product/list" class="menu">product List</a>
<a href = "./member/memberLogin" class="menu">member Login</a>
<a href = "/bankBook/list" class="menu">BankBook List</a>
<a href = "./bankBook/list" class="menu">BankBook List</a>

<img alt="아이유1" src="/resources/images/IU.jpg">
<img alt="아이유2" src="./resources/images/IU2.jpg">
<img alt="아이유3" src="./resources/images/IU3.jpg">
<iframe width="560" height="315" src="https://www.youtube.com/embed/Z4BEsS-oiGU" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>

<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
