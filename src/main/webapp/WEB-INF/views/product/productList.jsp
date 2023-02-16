<%@page import="java.util.List"%>
<%@page import="com.woo.s1.product.ProductDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 리스트 페이지</title>
<c:import url="../template/common_css.jsp"></c:import>
<link rel="stylesheet" href="/resources/css/table.css">
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	<h1 class="col-md-7 mx-auto text-center border-bottom border-dark-pb-3 mt-5">Product List Page</h1>
	
	<div class="row col-md-7 mx-auto mt-4">
		<table class="table table-hover">
			<thead>
				<tr>
					<th>상품명</th>
					<th>평점</th>
				</tr>
			</thead>
			
			<tbody class="table-group-divider">		
				<c:forEach items="${list}" var="dto"> <!-- dto는 page영역에 담김 -->
					<tr>
						<td><a href="./detail?productNum=${dto.productNum}">${pageScope.dto.productName}</a></td>
						<td>${dto.productJumsu}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<!-- paging -->
		<div class="row">
			<nav aria-label="Page navigation example">
				<ul class="pagination">
					<li class="page-item">
						<a class="page-link" href="./list?page=1" aria-label="Previous">
							<span aria-hidden="true">&laquo;</span>
						</a>									
					</li>
					
					<li class="page-item ${pager.before?'disabled':''}">
						<a class="page-link" href="./list?page=${pager.startNum-1}" aria-label="Previous">
							<span aria-hidden="true">&lsaquo;</span>
						</a>
					</li>
					
					<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
						<li class="page-item"><a class="page-link" href="./list?page=${i}&kind=${pager.kind}&search=${pager.search}">${i}</a></li>
					</c:forEach>
					
					<li class="page-item ${pager.after eq false ? 'disabled':''}">
						<a class="page-link" href="./list?page=${pager.lastNum+1}" aria-label="Next">
							<span aria-hidden="true">&rsaquo;</span>
						</a>
					</li>
					
					<li class="page-item">
						<a class="page-link" href="./list?page=${pager.totalPage}" aria-label="Next">
							<span aria-hidden>&raquo;</span>
						</a>
					</li>
				</ul>
			</nav>	
		</div>
		
		<!-- 검색창 -->
		<div class="row">
			<form class="row g-3" action=".productList" method="get">
				<div class="col-auto">
					<label for="kind" class="visually-hidden">Kind</label>
					<select>
						<option></option>
						<option></option>
					</select>
				</div>
				<div>
					<label></label>
					<input>					
				</div>
				<div>
					<button></button>
				</div>
			</form>
		</div>
		
		
		<div class="mb-3">
			<a href="./productAdd" class="btn btn-primary col-3">상품등록</a>
		</div>
	</div>
	<c:import url="../template/common_js.jsp"></c:import>
</body>
</html>