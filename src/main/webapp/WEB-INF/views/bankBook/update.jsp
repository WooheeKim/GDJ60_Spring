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
		<input type="hidden" name="bookNumber" value="${dto.bookNumber}"><br>
		<input type="text" name="bookName" value="${dto.bookName}" placeholder="제품명을 입력해주세요"><br>
		<input type="text" name="bookRate" value="${dto.bookRate}"><br>
		<textarea name="bookDetail" rows="" cols="">${dto.bookDetail}</textarea><br>
		<input type="text" name="bookSale" value="${dto.bookSale}"><br>
		<input type="submit" value="수정">
		<button type="submit">수정</button>	
	</form>
</body>
</html>