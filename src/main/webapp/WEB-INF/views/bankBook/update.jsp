<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>상품수정 Page</h1>
	
	<form action="./update" method="post">
		<input type="hidden" name="bookNumber" value="${dto.bookNumber}">
		
		<fieldset>
			<legend>상품명</legend>
			<input type="text" name="bookName" value="${dto.bookName}" placeholder="제품명을 입력해주세요">
		</fieldset>
		<fieldset>
			<legend>이자율</legend>
			<input type="text" name="bookRate" value="${dto.bookRate}">
		</fieldset>
		<fieldset>
			<legend>상세정보</legend>
			<textarea name="bookDetail" rows="" cols="">${dto.bookDetail}</textarea>
		</fieldset>
		<fieldset>
			<legend>판매여부</legend>
			<label for="woo1">판매</label>
			<input id="woo1" type="radio" ${dto.bookSale eq 1 ? 'checked':''} checked="checked" name="bookSale" value="1">
			<label for="woo2">판매중단</label>
			<input id="woo2" type="radio" ${dto.bookSale eq 0 ? 'checked':''} name="bookSale" value="0">
		</fieldset>
		<fieldset>
			<legend>판매여부</legend>
			<select name="bookSale">
				<option ${dto.bookSale eq 1 ? 'selected':''} value="1">판매</option>
				<option ${dto.bookSale eq 0 ? 'selected':''} value="0">판매중단</option>
			</select>
		</fieldset>
		<fieldset>
			<input type="submit" value="수정">
			<button type="submit">수정</button>
		</fieldset>	
	</form>
</body>
</html>