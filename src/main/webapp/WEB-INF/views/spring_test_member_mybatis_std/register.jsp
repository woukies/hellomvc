<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<thead>
			<tr>
				<th colspan="2">
					<h1>회원 가입 신청</h1><br>
					* 표시 항목: 필수 입력
				</th>
			</tr>
		</thead>
		<tbody>
			<form action="register_check" method="post">
			<tr>
				<td>아이디</td>
				<td><input type="text" name="mem_uid"></td>
			</tr>
			<tr>
				<td>암호</td>
				<td><input type="password" name="mem_pwd"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="mem_name"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="등록">
				</td>
			</tr>
			</form>
		</tbody>
	</table>
</body>
</html>