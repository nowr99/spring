<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지공지공지</title>
</head>
<body>
	<h1>공지사항 글쓰기</h1>
	<form action="/admin/noticeWrite" method="post">
		<input name="ntitle">
		<textarea name="ncontent"></textarea>
		<button type="submit">공지 작성하기</button>
	</form>
</body>
</html>