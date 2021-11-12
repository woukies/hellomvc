<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table border="1" align="center">
		<form action="login_ok" method="post">
		<tr align="center">
			<td width="100">사용자 ID</td>
			<td><input type="text" maxlength="15" name="mem_uid" width="200"></td>
		</tr>
		<tr align="center">
			<td>비밀번호</td>
			<td><input type="password" maxlength="15" name="mem_pwd" width="200"></td>
		</tr>
		<tr align="center">
			<td colspan="2">
				<input type="submit" value="로그인">
				&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="button" value="회원가입">
			</td>
		</tr>
		</form>
	</table>
</body>
</html>