<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table width="500" border="1" border-spacing="0">
		<tr>
			<th>이름</th>
			<th>가격</th>
			<th>설명</th>
		</tr>
		<c:forEach items="${list}" var="dto">
		<tr>
			<td>${dto.name}</td>
			<td>${dto.price}</td>
			<td>${dto.description}</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>