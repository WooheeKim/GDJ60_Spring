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
	<div class="container-fluid">
		<div class="row md-6">
			<h1 class="col-md-7 mx-auto text-center border-bottom border-dark-pb-3">상품등록 페이지</h1>
		</div>
	
	<form class="col-md-7 mx-auto center" action="./add" method="post" enctype="multipart/form-data">
		<div class="row mb-3">
   			<label for="bookName" class="col-sm-0 col-form-label">상품명</label>
   			<div class="col-sm-6">
     			<input name="bookName" type="text" class="form-control" id="bookName" placeholder="제품명을 입력하세요">
   			</div>
 		</div>
	
		<div class="row mb-3">
   			<label for="bookRate" class="col-sm-0 col-form-label">이자율</label>
			<div class="col-sm-6">
				<input name="bookRate" type="text" class="form-control" id="bookRate" placeholder="이자율을 입력하세요">
			</div>
		</div>
		
		<div class="row mb-3">
   			<label for="bookDetail" class="col-sm-0 col-form-label">상세정보</label>
  			<div class="col-sm-6">
   				<textarea name="bookDetail" class="form-control" id="bookRate" placeholder="제품명을 입력하세요"></textarea>
   			</div>
		</div>
		
		<div id="fileList">
			<!-- <div class="row mb-3">
				<label for="files" class="form-label">이미지</label>
				<input type="file" class="form-control" id="files" name="pic">
			</div> -->
			<button type="button" id="fileAdd">Add</button>
		</div>
		<!-- <fieldset>
			<legend>판매여부</legend>
			<label for="woo1">판매</label>
			<input id="woo1" type="radio" checked="checked" name="bookSale" value="1">
			<label for="woo2">판매중단</label>
			<input id="woo2" type="radio" name="bookSale" value="0">
		</fieldset>
		<fieldset>
			<legend>판매여부</legend>
			<select name="bookSale">
				<option value="1">판매</option>
				<option value="0" selected="selected">판매중단</option>
			</select>
		</fieldset> -->
		<fieldset>
			<!-- <input type="submit" value="등록"> -->
			<button type="submit">등록</button>
		</fieldset>
		
		</form>
	</div>
		<script src="../resources/js/fileManager.js"></script>
		<script>
			setMax(3);
			// setParam('f');
		</script>
		<c:import url="../template/common_js.jsp"></c:import>
</body>
</html>