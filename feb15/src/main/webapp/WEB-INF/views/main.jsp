<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board</title>
</head>
<body>
	<h1>Board</h1>
	<table>
		<thead>
			<tr>
				<th>글번호</th>
				<th>글제목</th>
				<th>글쓴이</th>
				<th>날짜</th>
				<th>조회수</th>
			</tr>
		</thead>	
		<tbody>
			<c:forEach items="${list }" var="e">
			<tr>
				<td>${e.board_no }</td>
				<td>${e.board_title }[${e.board_comment }]</td>
				<td>${e.board_write }</td>
				<td>${e.board_date }</td>
				<td>${e.board_count }</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>