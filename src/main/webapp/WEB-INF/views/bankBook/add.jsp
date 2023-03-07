<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>상품등록 페이지</title>
	<c:import url="../template/common_css.jsp"></c:import>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
	<div class="contanier-fluid">
		<div class="row justify-content-center my-4">		
			<h1 class="col-md-7 text-center">상품등록 페이지</h1>
		</div>
<div class="row justify-content-center my-4">
	<form class="col-md-7" action="./add" method="post" enctype="multipart/form-data">
		<div class="mb-3">
   			<label for="bookName" class="form-label">제품명</label>
   			<input name="bookName" type="text" class="form-control" id="bookName" placeholder="제품명을 입력하세요">   			
 		</div>
	
		<div class="mb-3">
   			<label for="bookRate" class="form-label">이자율</label>
			<input name="bookRate" type="text" class="form-control" id="bookRate" placeholder="이자율을 입력하세요">			
		</div>
		
		<div class="mb-3">
   			<label for="bookDetail" class="form-label">상세정보</label>
   			<textarea name="bookDetail" class="form-control" id="bookDetail" placeholder="설명을 입력하세요"></textarea>   			
		</div>
		
		<div id="fileList">
			<!-- <div class="row mb-3">
				<label for="files" class="form-label">이미지</label>
				<input type="file" class="form-control" id="files" name="pic">
			</div> -->
			<button type="button" id="fileAdd">Add</button>
		</div>
		
		<div class="mb-3 form-check form-switch">
			<label class="form-check-label" for="bookSale">판매여부</label>
			<input name="bookSale" class="form-check-input" value="1" type="checkbox" role="switch" id="bookSale">
		</div>
		
		<div class="mb-3">			
			<button class="my btn btn-danger" type="submit">등록</button>
		</div>		
	</form>
	</div>
</div>
		<script src="../resources/js/fileManager.js"></script>
		<c:import url="../template/common_js.jsp"></c:import>
		<script>
			setMax(3);
			// setParam('f');
		</script>
</body>
</html>