<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table width="500" border="1">
		<form action="write" method="post">
			<tr>
				<td>�̸�</td>
				<td><input type="text" name="bname" size="50"></td>
			</tr>
			<tr>
				<td>����</td>
				<td><input type="text" name="btitle" size="50"></td>
			</tr>
			<tr>
				<td>����</td>
				<td><textarea rows="10" name="bcontent"></textarea></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="�Է�"></td>
			</tr>
		</form>
	</table>
</body>
</html>